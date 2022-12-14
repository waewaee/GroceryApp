package com.waewaee.groceryapp.mvp.presenters

import com.waewaee.groceryapp.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}