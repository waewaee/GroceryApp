package com.waewaee.groceryapp.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.waewaee.groceryapp.adapters.GroceryAdapter
import com.waewaee.groceryapp.data.vos.GroceryVO
import com.waewaee.groceryapp.dialogs.GroceryDialogFragment
import com.waewaee.groceryapp.mvp.presenters.MainPresenter
import com.waewaee.groceryapp.mvp.presenters.impls.MainPresenterImpl
import com.waewaee.groceryapp.mvp.views.MainView
import com.waewaee.groceryapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    private val mAdapter: GroceryAdapter = GroceryAdapter()
    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setUpPresenter()
        setUpRecyclerView()

        setUpActionListeners()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<MainPresenterImpl, MainView>()
    }

    private fun setUpActionListeners() {
        fab.setOnClickListener {
            GroceryDialogFragment.newFragment()
                .show(supportFragmentManager, GroceryDialogFragment.TAG_ADD_GROCERY_DIALOG)
        }
    }

    private fun setUpRecyclerView() {
        rvGroceries.adapter = mAdapter
        rvGroceries.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showGroceryData(groceryList: List<GroceryVO>) {
        mAdapter.setNewData(groceryList)
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG)
    }
}