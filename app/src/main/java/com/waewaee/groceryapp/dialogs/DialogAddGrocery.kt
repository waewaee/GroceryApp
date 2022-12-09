package com.waewaee.groceryapp.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.waewaee.groceryapp.R
import com.waewaee.groceryapp.mvp.presenters.MainPresenter
import com.waewaee.groceryapp.mvp.presenters.impls.MainPresenterImpl
import kotlinx.android.synthetic.main.dialog_add_grocery.*
import kotlinx.android.synthetic.main.dialog_add_grocery.view.*

class GroceryDialogFragment : DialogFragment() {

    companion object {
        const val TAG_ADD_GROCERY_DIALOG = "TAG_ADD_GROCERY_DIALOG"

        fun newFragment(): GroceryDialogFragment {
            return GroceryDialogFragment()
        }
    }

    private lateinit var mPresenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_grocery, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()

        view.btnAddGrocery.setOnClickListener {
            mPresenter.onTapAddGrocery(
                etGroceryName.text.toString(),
                etDescription.text.toString(),
                etAmount.text.toString().toInt()
            )
            dismiss()
        }
    }

    private fun setUpPresenter() {
        activity?.let {
            mPresenter = ViewModelProviders.of(it).get(MainPresenterImpl::class.java)
        }
    }
}