package com.waewaee.groceryapp.mvp.views

import com.waewaee.groceryapp.data.vos.GroceryVO

interface MainView : BaseView {
    fun showGroceryData(groceryList : List<GroceryVO>)
    fun showErrorMessage(message : String)
}