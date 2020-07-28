package com.krayz.myfootballmatch.ui.base

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<VM : BaseViewModel?> : AppCompatActivity() {
    protected var viewModel: VM? = null
    @NonNull
    protected abstract fun createViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }
}