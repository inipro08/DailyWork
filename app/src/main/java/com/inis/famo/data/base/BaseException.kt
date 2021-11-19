package com.inis.famo.data.base

import retrofit2.Response
import java.io.IOException

class BaseException : RuntimeException {

    var errorType: Int = NETWORK
    var errorResponse: BaseErrorResponse? = null
    var response: Response<*>? = null

    val serverErrorCode: String
        get() = errorResponse?.code ?: ""

    constructor(type: Int, cause: Throwable) : super(cause.message, cause) {
        this.errorType = type
    }

    constructor(type: Int, errorResponse: BaseErrorResponse?) {
        this.errorType = type
        this.errorResponse = errorResponse
    }

    constructor(type: Int, response: Response<*>?) {
        this.errorType = type
        this.response = response
    }

    override val message: String?
        get() = when (errorType) {
            SERVER -> errorResponse?.message

            NETWORK -> cause?.message

            HTTP -> response?.message()

            UNEXPECTED -> cause?.message

            else -> {
                "Unexpected error has occurred"
            }
        }

    companion object {

        /**
         * An [IOException] occurred while communicating to the server.
         */
        const val NETWORK = 0
        /**
         * A non-2xx HTTP status code was received from the server.
         */
        const val HTTP = 1
        /**
         * A error server with code & message
         */
        const val SERVER = 2
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        const val UNEXPECTED = 3

        fun toHttpError(response: Response<*>): BaseException {
            return BaseException(HTTP, response)
        }

        fun toNetworkError(cause: Throwable): BaseException {
            return BaseException(NETWORK, cause)
        }

        fun toServerError(errorResponse: BaseErrorResponse): BaseException {
            return BaseException(SERVER, errorResponse)
        }

        fun toUnexpectedError(cause: Throwable): BaseException {
            return BaseException(UNEXPECTED, cause)
        }
    }
}
