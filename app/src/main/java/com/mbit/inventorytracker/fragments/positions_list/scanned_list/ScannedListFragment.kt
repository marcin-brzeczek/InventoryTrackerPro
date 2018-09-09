package com.mbit.inventorytracker.fragments.positions_list.scanned_list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.cache.LocationCache.locationName
import com.mbit.inventorytracker.database.DBContext
import com.mbit.inventorytracker.database.dto.Item_Table
import com.mbit.inventorytracker.fragments.FragmentType
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import com.mbit.inventorytracker.fragments.adapter.IOnReloadAdapterListener
import com.mbit.inventorytracker.fragments.adapter.ItemAdapter
import com.mbit.inventorytracker.fragments.adapter.ItemSwipeHelper
import com.mbit.inventorytracker.fragments.adapter.TypesFactoryImpl
import com.mbit.inventorytracker.fragments.adapter.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_empty_list.rv_items
import kotlinx.android.synthetic.main.fragment_scan_list.*
import javax.inject.Inject

class ScannedListFragment : FragmentBase(), IOnReloadAdapterListener {

    @Inject
    lateinit var databaseContext: DBContext

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_scan_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        loadAdapter()
    }

    override fun reload() {
        loadAdapter()
    }

    fun loadAdapter() {
        rv_items.layoutManager = LinearLayoutManager(activity.baseContext)
        val itemAdapter = ItemAdapter(databaseContext.items.where(Item_Table.oldLocation.eq(locationName)).queryList().filter { it.endNumber > 0 }.map { ItemViewModel(it, activity.baseContext) }.toMutableList(), TypesFactoryImpl(), FragmentType.ScannedListFragment)
        rv_items.adapter = itemAdapter
        val itemTouchHelper = ItemTouchHelper(ItemSwipeHelper(itemAdapter, activity, this))
        itemTouchHelper.attachToRecyclerView(rv_items)
        tvSumScannedItems.text = databaseContext.items.where(Item_Table.oldLocation.eq(locationName)).queryList().filter { it.endNumber > 0 }.sumByDouble { item -> item.endNumber }.toString()
        itemAdapter.notifyDataSetChanged()
    }
}