package com.waewaee.groceryapp.mvp.presenters.impls

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.waewaee.groceryapp.analytics.SCREEN_HOME
import com.waewaee.groceryapp.data.models.GroceryModelImpl
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.mvp.presenters.AbstractBasePresenter
import com.waewaee.groceryapp.mvp.presenters.MainPresenter
import com.waewaee.groceryapp.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mGroceryModel = GroceryModelImpl
    private var mChosenGroceryForFileUpload: GroceryVO? = null

    override fun onTapAddGrocery(name: String, description: String, amount: Int) {
        mGroceryModel.addGrocery(name, description, amount, "")
    }

    override fun onPhotoTaken(bitmap: Bitmap) {
        mChosenGroceryForFileUpload?.let {
            mGroceryModel.uploadImageAndUpdateGrocery(it, bitmap)
        }
    }

    override fun getUserName(): String {
        return mGroceryModel.getUserName()
    }

    override fun onTapEditGrocery(name: String, description: String, amount: Int) {
        mView.showGroceryDialog(name, description, amount.toString())
    }

    override fun onTapFileUpload(grocery: GroceryVO) {
        mChosenGroceryForFileUpload = grocery
        mView.openGallery()
    }

    override fun onUiReady(
        context: Context,
        owner: LifecycleOwner
    ) {
        sendEventsToFirebaseAnalytics(context, SCREEN_HOME)
        mGroceryModel.getGroceries(
            onSuccess = {
                mView.showGroceryData(it)
            },
            onFailure = {
                mView.showErrorMessage(it)
            }
        )
        mView.displayToolbarTitle(mGroceryModel.getAppNameFromRemoteConfig())
        mView.showGroceryListViewTypeAsConfig(mGroceryModel.getGroceryViewType())
    }

    override fun onTapDeleteGrocery(name: String) {
        mGroceryModel.removeGrocery(name)
    }

}