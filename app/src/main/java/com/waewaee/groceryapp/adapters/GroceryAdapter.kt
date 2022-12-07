package com.waewaee.groceryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.viewholders.GroceryViewHolder
import com.waewaee.groceryapp.R

class GroceryAdapter() : BaseRecyclerAdapter<GroceryViewHolder, GroceryVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item,parent,false)
        return GroceryViewHolder(view)
    }
}