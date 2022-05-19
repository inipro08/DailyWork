package com.inis.dailywork.ui.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDialog<DialogBinding : ViewDataBinding>(
    context: Context,
    @LayoutRes val layoutId: Int
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding: DialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            layoutId,
            null,
            false
        )
        setContentView(binding.root)
        binding.initViews()
        binding.addEvents()
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window?.decorView?.background = ColorDrawable(Color.TRANSPARENT)
        setCancelable(false)
    }

    protected abstract fun DialogBinding.initViews()

    protected abstract fun DialogBinding.addEvents()
}