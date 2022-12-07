package com.waewaee.groceryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.waewaee.groceryapp.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}