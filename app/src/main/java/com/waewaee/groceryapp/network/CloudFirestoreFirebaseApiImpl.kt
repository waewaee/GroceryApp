package com.waewaee.groceryapp.network

import com.waewaee.groceryapp.data.vos.GroceryVO

object CloudFirestoreFirebaseApiImpl : FirebaseApi{
    override fun getGroceries(
        onSuccess: (groceries: List<GroceryVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {

    }

    override fun addGrocery(name: String, description: String, amount: Int) {

    }

    override fun deleteGrocery(name: String) {

    }

}