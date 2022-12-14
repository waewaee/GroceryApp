package com.waewaee.groceryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.waewaee.groceryapp.data.models.AuthenticationModel
import com.waewaee.groceryapp.data.models.AuthenticationModelImpl
import com.waewaee.groceryapp.mvp.presenters.AbstractBasePresenter
import com.waewaee.groceryapp.mvp.presenters.LoginPresenter
import com.waewaee.groceryapp.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onUiReady(owner: LifecycleOwner) {}

    override fun onTapLogin(email: String, password: String) {
        mAuthenticationModel.login(email, password, onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}