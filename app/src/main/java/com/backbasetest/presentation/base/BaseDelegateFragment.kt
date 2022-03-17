package com.backbasetest.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseDelegateFragment<T : ViewBinding> : Fragment() {

    @get:LayoutRes
    abstract val layoutId: Int

    private var _viewBinding: T? = null
    protected val viewBinding: T
        get() = _viewBinding ?: throw RuntimeException("ViewBinding is null")

    abstract fun bindView(view: View): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _viewBinding = bindView(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }
}