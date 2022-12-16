package com.waewaee.groceryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.viewholders.GroceryViewHolder
import com.waewaee.groceryapp.R
import com.waewaee.groceryapp.delegates.GroceryViewItemActionDelegate

class GroceryAdapter(
    private val mDelegate: GroceryViewItemActionDelegate,
    private val viewTypeFlag: String
    ) : BaseRecyclerAdapter<GroceryViewHolder, GroceryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        when (viewTypeFlag) {
            "1" -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item_grid,parent,false)
                return GroceryViewHolder(view, mDelegate)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item,parent,false)
                return GroceryViewHolder(view, mDelegate)
            }
        }
    }
}