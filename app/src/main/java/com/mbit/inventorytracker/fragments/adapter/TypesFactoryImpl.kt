package com.mbit.inventorytracker.fragments.adapter

import android.view.View

import com.mbit.inventorytracker.fragments.adapter.holder.GenericViewHolder
import com.mbit.inventorytracker.fragments.adapter.holder.ItemHolder
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.database.dto.Item
import com.mbit.inventorytracker.database.dto.Location
import com.mbit.inventorytracker.fragments.adapter.holder.LocationHolder

class TypesFactoryImpl : ITypesFactory {

    override fun type(location: Location): Int = R.layout.location_row
    override fun type(item: Item) = R.layout.item_row

    override fun holder(type: Int, view: View): GenericViewHolder<*> {
        return when (type) {
            R.layout.item_row -> ItemHolder(view)
            R.layout.location_row -> LocationHolder(view)
            else -> throw RuntimeException("Illegal view type")
        }
    }
}