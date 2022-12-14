package com.waewaee.groceryapp.mvp.presenters

import com.waewaee.groceryapp.mvp.views.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(email: String, password: String, userName: String)
}