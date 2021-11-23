package com.inis.famo.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inis.famo.R
import com.inis.famo.ui.event.UniversalBus
import com.inis.famo.utils.ViewState
import com.inis.famo.utils.showSnackMessage
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, M : BaseViewModel>(@LayoutRes val layoutRes: Int) : DaggerAppCompatActivity() {
    protected lateinit var binding: T
    protected lateinit var viewModel: M

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract fun viewModelClass(): Class<M>

    protected abstract fun T.initView()

    protected abstract fun T.addEvent()

    protected abstract fun M.observeLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this
        binding.initView()
        binding.addEvent()
        viewModel = ViewModelProvider(this, viewModelFactory).get(viewModelClass())
        viewModel.observeLiveData()

        //EventBus register
        UniversalBus.register(this)
    }

    protected fun addFragment(fragment: Fragment, tag: String, isAddBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container_main_activity, fragment, tag)
            if (isAddBackStack) addToBackStack(null)
            commit()
        }
    }

    protected fun replaceFragment(fragment: Fragment, isAddBackStack: Boolean = false) : Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_main_activity, fragment, fragment.tag)
            if (isAddBackStack) addToBackStack(null)
            commit()
        }
        return true
    }

    fun showLoading() {
        // TODO: 12/2/2021 showLoading
    }

    fun hideLoading() {
        // TODO: 12/2/2021 hideLoading
    }

    fun showSnackMessage(view: View,message: String) {
        view.showSnackMessage(message)
    }

    protected fun showSnackMessage(view: View,message: String, action: String, callbackAction: () -> Unit) {
        view.showSnackMessage(message, action, callbackAction)
    }

    fun onBack() {
        finish()
    }

    override fun onDestroy() {
        UniversalBus.unregister(this)
        super.onDestroy()
    }
}
