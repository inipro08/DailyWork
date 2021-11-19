package com.inis.famo.data.base

import com.google.gson.Gson
import io.reactivex.*
import io.reactivex.functions.Function
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.lang.reflect.Type

class RxErrorHandlingCallAdapterFactory : CallAdapter.Factory() {

    companion object {
        fun create() =
            RxErrorHandlingCallAdapterFactory()
    }

    private val instance = RxJava2CallAdapterFactory.create()

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *> {
        @Suppress("UNCHECKED_CAST")
        return RxCallAdapterWrapper(
            instance.get(returnType, annotations, retrofit) as CallAdapter<Any, Any>
        )
    }
}

class RxCallAdapterWrapper<R>(private val wrapped: CallAdapter<R, Any>) : CallAdapter<R, Any> {

    override fun responseType(): Type {
        return wrapped.responseType()
    }

    override fun adapt(call: Call<R>): Any {
        return when (val result = wrapped.adapt(call)) {
            is Single<*> -> {
                result.onErrorResumeNext(Function<Throwable, SingleSource<Nothing>> { throwable ->
                    Single.error(convertToBaseException(throwable))
                })
            }
            is Observable<*> -> {
                result.onErrorResumeNext(Function<Throwable, ObservableSource<Nothing>> { throwable ->
                    Observable.error(convertToBaseException(throwable))
                })
            }
            is Completable -> {
                result.onErrorResumeNext { throwable ->
                    Completable.error(convertToBaseException(throwable))
                }
            }
            else -> result
        }
    }

    private fun convertToBaseException(throwable: Throwable): BaseException {
        try {
            if (throwable is BaseException) {
                return throwable
            }

            if (throwable is HttpException) {
                val response = throwable.response()
                if (response != null) {
                    if (response.errorBody() == null) {
                        return BaseException.toHttpError(response)
                    }
                    try {
                        val errorResponse = response.errorBody()!!.string()
                        val baseErrorResponse =
                            Gson().fromJson(errorResponse, BaseErrorResponse::class.java)
                        return if (baseErrorResponse != null) {
                            // Get error data from server
                            baseErrorResponse.code = throwable.code().toString()
                            BaseException.toServerError(baseErrorResponse)
                        } else {
                            // Get error data cause http connection
                            BaseException.toHttpError(response)
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
            return BaseException.toUnexpectedError(throwable)
        } catch (e: Exception) {
            return BaseException.toUnexpectedError(throwable)
        }
    }
}
