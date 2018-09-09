package com.mbit.inventorytracker.fragments.result_scanned_position

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.cache.LocationCache.locationName
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import com.mbit.inventorytracker.fragments.new_position.NEW_ITEM_CODE
import com.mbit.inventorytracker.utilities.inflate
import kotlinx.android.synthetic.main.fragment_result_scan_position.*

class ResultScannedPositionFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_result_scan_position, container) {
                val itemCode: String? = arguments.getString(NEW_ITEM_CODE)

                tvLokalization.setText(locationName)
                editTextEAN.setText(itemCode)

            }
}