package com.mbit.inventorytracker.fragments.choose_location

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.database.DBContext
import com.mbit.inventorytracker.database.dto.Location
import com.mbit.inventorytracker.fragments.FragmentType
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import com.mbit.inventorytracker.fragments.adapter.ItemAdapter
import com.mbit.inventorytracker.fragments.adapter.TypesFactoryImpl
import com.mbit.inventorytracker.fragments.adapter.viewmodel.LocationViewModel
import com.mbit.inventorytracker.utilities.inflate
import kotlinx.android.synthetic.main.fragment_choose_location.*
import javax.inject.Inject

class ChooseLocationFragment : FragmentBase() {

    @Inject
    lateinit var databaseContext: DBContext

    private lateinit var _adapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_choose_location, container) {
                setHasOptionsMenu(true)
            }

    override fun onStart() {
        super.onStart()
        val viewModels = databaseContext.items.queryList().distinctBy { it.oldLocation }.map { LocationViewModel(Location(it.oldLocation), activity.baseContext) }
        rv_locations.layoutManager = LinearLayoutManager(activity.baseContext)
        _adapter = ItemAdapter(viewModels.toMutableList(), TypesFactoryImpl(), FragmentType.ChooseLocationFragment)
        rv_locations.adapter = _adapter
    }
}