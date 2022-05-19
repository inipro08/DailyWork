package com.inis.dailywork.ui.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.inis.dailywork.BR
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseBottomSheet<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel>(@LayoutRes val layoutRes: Int) :
    BottomSheetDialogFragment() {

    protected lateinit var binding: ViewBinding

    abstract val viewModel: ViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.initViews()
        binding.addEvents()
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.apply {
            setCancelable(false)
            setCanceledOnTouchOutside(false)
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            root.isClickable = true
            root.isFocusable = true
            setVariable(BR.viewModel, this@BaseBottomSheet.viewModel)
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPress()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onActivityDestroyed()
    }

    protected open fun onBackPress() {
        close()
    }

    protected fun close() {
        activity?.supportFragmentManager?.popBackStack()
    }

    protected abstract fun ViewBinding.initViews()

    protected abstract fun ViewBinding.addEvents()
}
