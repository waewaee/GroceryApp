package com.waewaee.groceryapp.delegates

import com.waewaee.groceryapp.data.vos.GroceryVO

interface GroceryViewItemActionDelegate{
    fun onTapDeleteGrocery(name : String)
    fun onTapEditGrocery(name: String, description: String, amount: Int)
    fun onTapFileUpload(grocery: GroceryVO)
}