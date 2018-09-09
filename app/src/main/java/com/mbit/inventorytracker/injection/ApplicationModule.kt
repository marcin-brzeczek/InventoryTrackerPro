package com.mbit.inventorytracker.injection

import com.mbit.inventorytracker.InitApp
import com.mbit.inventorytracker.database.DBContext
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class ApplicationModule(private val _application: InitApp) {

    @Provides
    @Singleton
    fun provideApplication(): InitApp = _application


    @Provides
    @Singleton
    fun providesDBContext(): DBContext = DBContext()
}