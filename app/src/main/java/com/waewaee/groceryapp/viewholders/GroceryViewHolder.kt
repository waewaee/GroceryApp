package com.waewaee.groceryapp.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.delegates.GroceryViewItemActionDelegate
import kotlinx.android.synthetic.main.view_holder_grocery_item.view.*

class GroceryViewHolder(itemView: View, private val mDelegate: GroceryViewItemActionDelegate) : BaseViewHolder<GroceryVO>(itemView) {

    override fun bindData(data: GroceryVO) {
        itemView.tvTitle.text = data.name
        itemView.tvDescription.text = data.description
        itemView.tvCount.text = "x ${data.amount.toString()}"

        itemView.btnDelete.setOnClickListener {
            mDelegate.onTapDeleteGrocery(data.name ?: "")
        }

        itemView.btnEdit.setOnClickListener {
            mDelegate.onTapEditGrocery(data.name ?: "", data.description ?: "", data.amount ?: 0)
        }

        itemView.btnFileUpload.setOnClickListener {
            mDelegate.onTapFileUpload(data)
        }

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivGroceryImage)
    }
}