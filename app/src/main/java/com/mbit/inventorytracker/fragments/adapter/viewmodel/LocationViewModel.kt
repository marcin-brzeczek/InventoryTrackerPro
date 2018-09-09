package com.mbit.inventorytracker.fragments.adapter.viewmodel

import android.content.Context
import com.mbit.inventorytracker.database.dto.Location
import com.mbit.inventorytracker.fragments.adapter.ITypesFactory

class LocationViewModel(val item: Location, val context: Context) : ViewModel() {

    override fun type(typesFactory: ITypesFactory): Int {
        return typesFactory.type(item)
    }
}