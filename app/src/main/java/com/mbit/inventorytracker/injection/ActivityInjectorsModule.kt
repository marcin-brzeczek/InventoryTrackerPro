package com.mbit.inventorytracker.injection

import com.mbit.inventorytracker.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorsModule {
    @ContributesAndroidInjector abstract fun provideMainActivityInjector(): MainActivity
}