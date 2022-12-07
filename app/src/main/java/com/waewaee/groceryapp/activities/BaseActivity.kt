package com.waewaee.groceryapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.waewaee.groceryapp.mvp.presenters.AbstractBasePresenter
import com.waewaee.groceryapp.mvp.views.BaseView
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    inline fun <reified T : AbstractBasePresenter<W>, reified W: BaseView> getPresenter(): T {
        val presenter = ViewModelProviders.of(this).get(T::class.java)
        if (this is W) presenter.initPresenter(this)
        return presenter
    }
}