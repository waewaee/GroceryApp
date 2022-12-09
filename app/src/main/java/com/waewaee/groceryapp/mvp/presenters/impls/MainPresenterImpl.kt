package com.waewaee.groceryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.waewaee.groceryapp.data.models.GroceryModelImpl
import com.waewaee.groceryapp.mvp.presenters.AbstractBasePresenter
import com.waewaee.groceryapp.mvp.presenters.MainPresenter
import com.waewaee.groceryapp.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mGroceryModel = GroceryModelImpl

    override fun onTapAddGrocery(name: String, description: String, amount: Int) {
        mGroceryModel.addGrocery(name,description,amount)
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mGroceryModel.getGroceries(
            onSuccess = {
                mView.showGroceryData(it)
            },
            onFailure = {
                mView.showErrorMessage(it)
            }
        )
    }
}