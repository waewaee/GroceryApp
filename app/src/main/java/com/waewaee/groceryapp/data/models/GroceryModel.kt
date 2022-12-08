package com.waewaee.groceryapp.data.models

import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.network.FirebaseApi

interface GroceryModel {

    var mFirebaseApi : FirebaseApi

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit)
}