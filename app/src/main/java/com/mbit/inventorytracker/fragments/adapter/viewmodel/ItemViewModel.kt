package com.mbit.inventorytracker.fragments.adapter.viewmodel

import android.content.Context
import com.mbit.inventorytracker.database.dto.Item
import com.mbit.inventorytracker.fragments.adapter.IStatusResult
import com.mbit.inventorytracker.fragments.adapter.ITypesFactory
import com.mbit.inventorytracker.fragments.adapter.ItemStatus

class ItemViewModel(val item: Item, val context: Context) : ViewModel(), IStatusResult {

    override fun type(typesFactory: ITypesFactory): Int {
        return typesFactory.type(item)
    }

    override fun getStatus(): ItemStatus {

        with(item) {
            if (startNumber > endNumber)
                return ItemStatus.Brak

            if (startNumber < endNumber)
                return ItemStatus.Nadwyzka
        }
        return ItemStatus.Zgodny
    }
}