package com.mbit.inventorytracker.fragments.adapter.viewmodel

import com.mbit.inventorytracker.fragments.adapter.ITypesFactory

abstract class ViewModel {
    abstract fun type(typesFactory: ITypesFactory): Int
}