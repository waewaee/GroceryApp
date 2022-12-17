package com.waewaee.groceryapp.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.waewaee.groceryapp.analytics.PARAMETER_EMAIL
import com.waewaee.groceryapp.analytics.SCREEN_REGISTER
import com.waewaee.groceryapp.analytics.TAP_REGISTER
import com.waewaee.groceryapp.data.models.AuthenticationModel
import com.waewaee.groceryapp.data.models.AuthenticationModelImpl
import com.waewaee.groceryapp.mvp.presenters.AbstractBasePresenter
import com.waewaee.groceryapp.mvp.presenters.RegisterPresenter
import com.waewaee.groceryapp.mvp.views.RegisterView

class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(context : Context, email: String, password: String, userName: String) {
        sendEventsToFirebaseAnalytics(context, TAP_REGISTER, PARAMETER_EMAIL, email)
        mAuthenticationModel.register(email, password, userName, onSuccess = {
            mView.navigateToToLoginScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onUiReady(
        context: Context,
        owner: LifecycleOwner
    ) {
        sendEventsToFirebaseAnalytics(context, SCREEN_REGISTER)
    }
}