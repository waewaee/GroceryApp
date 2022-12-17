package com.waewaee.groceryapp.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.waewaee.groceryapp.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(context: Context, owner: LifecycleOwner)
    fun initPresenter(view: V)
}