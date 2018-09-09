package com.mbit.inventorytracker.injection

import com.mbit.inventorytracker.fragments.login.LoginFragment
import com.mbit.inventorytracker.fragments.positions_list.empty_list.EmptyListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import com.mbit.inventorytracker.fragments.choose_location.ChooseLocationFragment
import com.mbit.inventorytracker.fragments.new_position.NewItemFragment
import com.mbit.inventorytracker.fragments.positions_list.scanned_list.ScannedListFragment
import com.mbit.inventorytracker.fragments.report.ReportFragment
import com.mbit.inventorytracker.fragments.scan_positions.ScanPositionsFragment

@Module
internal abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFragmentGeneralBase(): FragmentBase

    @ContributesAndroidInjector internal abstract fun contributeLoginFragment(): LoginFragment
    @ContributesAndroidInjector internal abstract fun contributeEmptyListFragment(): EmptyListFragment
    @ContributesAndroidInjector internal abstract fun contributeScannedListFragment(): ScannedListFragment
    @ContributesAndroidInjector internal abstract fun contributeReportFragment(): ReportFragment
    @ContributesAndroidInjector internal abstract fun contributeScanPositionsFragment(): ScanPositionsFragment
    @ContributesAndroidInjector internal abstract fun contributeNewItemFragment(): NewItemFragment
    @ContributesAndroidInjector internal abstract fun contributeChooseLocationFragment(): ChooseLocationFragment
}