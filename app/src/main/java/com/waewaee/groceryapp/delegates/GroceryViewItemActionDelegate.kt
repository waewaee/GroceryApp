package com.waewaee.groceryapp.delegates

interface GroceryViewItemActionDelegate{
    fun onTapDeleteGrocery(name : String)
    fun onTapEditGrocery(name: String, description: String, amount: Int)
}