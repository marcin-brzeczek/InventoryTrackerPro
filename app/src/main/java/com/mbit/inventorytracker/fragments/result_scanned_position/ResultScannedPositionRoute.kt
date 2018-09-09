package com.mbit.inventorytracker.fragments.result_scanned_position

import android.os.Bundle
import android.os.Parcel
import com.mbit.inventorytracker.backstack.BaseRoute
import paperparcel.PaperParcel

const val LOCATION_NAME_SCAN = "location_name2"

@PaperParcel
data class ResultScannedPositionRoute(val locationName: String? = null, val tag: String = ResultScannedPositionRoute::javaClass.name) : BaseRoute() {

    override fun createFragment() = ResultScannedPositionFragment().apply {
        arguments = (arguments ?: Bundle()).apply {
            putString(LOCATION_NAME_SCAN, locationName)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        PaperParcelResultScannedPositionRoute.writeToParcel(this, parcel, flags)
    }

    companion object {
        @JvmField
        val CREATOR = PaperParcelResultScannedPositionRoute.CREATOR
    }
}