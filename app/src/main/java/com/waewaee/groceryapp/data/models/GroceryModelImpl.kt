package com.waewaee.groceryapp.data.models

import android.graphics.Bitmap
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.network.CloudFirestoreFirebaseApiImpl
import com.waewaee.groceryapp.network.FirebaseApi
import com.waewaee.groceryapp.network.auth.AuthManager
import com.waewaee.groceryapp.network.auth.FirebaseAuthManager
import com.waewaee.groceryapp.network.remoteconfig.FirebaseRemoteConfigManager

object GroceryModelImpl : GroceryModel {
//    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override var mAuthManager: AuthManager = FirebaseAuthManager

    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager


    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFailure)
    }

    override fun addGrocery(name: String, description: String, amount: Int, image: String) {
        mFirebaseApi.addGrocery(name, description, amount, image)
    }

    override fun removeGrocery(name: String) {
        mFirebaseApi.deleteGrocery(name)
    }

    override fun uploadImageAndUpdateGrocery(grocery: GroceryVO, image: Bitmap) {
        mFirebaseApi.uploadImageAndEditGrocery(image, grocery)
    }

    override fun getUserName(): String {
        return mAuthManager.getUserName()
    }

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getAppNameFromRemoteConfig(): String {
        return mFirebaseRemoteConfigManager.getToolbarName()
    }
}