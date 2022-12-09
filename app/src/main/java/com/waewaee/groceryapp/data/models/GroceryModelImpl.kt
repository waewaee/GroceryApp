package com.waewaee.groceryapp.data.models

import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.network.FirebaseApi
import com.waewaee.groceryapp.network.RealtimeDatabaseFirebaseApiImpl

object GroceryModelImpl : GroceryModel {
    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl

    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFailure)
    }


    override fun addGrocery(name: String, description: String, amount: Int) {
        mFirebaseApi.addGrocery(name, description, amount)
    }

}