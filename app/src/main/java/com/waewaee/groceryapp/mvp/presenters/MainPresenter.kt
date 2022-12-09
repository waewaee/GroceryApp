package com.waewaee.groceryapp.mvp.presenters

import com.waewaee.groceryapp.delegates.GroceryViewItemActionDelegate
import com.waewaee.groceryapp.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, GroceryViewItemActionDelegate {
    fun onTapAddGrocery(name: String, description: String, amount: Int)
}
