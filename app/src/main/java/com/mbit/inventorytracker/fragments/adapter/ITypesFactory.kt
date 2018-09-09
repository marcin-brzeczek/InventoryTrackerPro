package com.mbit.inventorytracker.fragments.adapter

import android.view.View
import com.mbit.inventorytracker.database.dto.Item
import com.mbit.inventorytracker.database.dto.Location
import com.mbit.inventorytracker.fragments.adapter.holder.GenericViewHolder

interface ITypesFactory {
    fun type(item: Item): Int
    fun type(location: Location): Int
    fun holder(type: Int, view: View): GenericViewHolder<*>
}