package com.waewaee.groceryapp.data.models

import android.graphics.Bitmap
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.network.FirebaseApi
import com.waewaee.groceryapp.network.auth.AuthManager
import com.waewaee.groceryapp.network.remoteconfig.FirebaseRemoteConfigManager

interface GroceryModel {

    var mFirebaseApi : FirebaseApi
    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    var mAuthManager: AuthManager

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit)

    fun addGrocery(name: String ,description : String, amount: Int, image: String)

    fun removeGrocery(name: String)

    fun uploadImageAndUpdateGrocery(grocery : GroceryVO, image : Bitmap)

    fun getUserName(): String

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getAppNameFromRemoteConfig() : String
}