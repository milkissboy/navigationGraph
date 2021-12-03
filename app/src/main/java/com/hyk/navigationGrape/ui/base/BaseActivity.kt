package com.hyk.navigationGrape.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(), CoroutineScope {

    abstract val layoutId: Int

    private val job = Job()

    protected lateinit var binding: T

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind(layoutId)
    }

    private fun bind(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelJob()
    }

    private fun cancelJob() {
        job.cancel()
    }
}