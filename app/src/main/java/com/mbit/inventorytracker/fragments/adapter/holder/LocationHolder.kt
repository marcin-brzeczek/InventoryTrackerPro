package com.mbit.inventorytracker.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.backstack.BackstackService
import com.mbit.inventorytracker.cache.LocationCache
import com.mbit.inventorytracker.fragments.FragmentType
import com.mbit.inventorytracker.fragments.adapter.holder.GenericViewHolder
import com.mbit.inventorytracker.fragments.adapter.viewmodel.LocationViewModel
import com.mbit.inventorytracker.fragments.scan_positions.ScanPositionsRoute

class LocationHolder(view: View) : GenericViewHolder<LocationViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: LocationViewModel, fragmentType: FragmentType) {

        when (fragmentType) {

            FragmentType.ChooseLocationFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).apply {
                    setText(itemVM.item.name)
                    setOnClickListener {    BackstackService.get(itemView.context).goTo(ScanPositionsRoute())
                        LocationCache.locationName = itemVM.item.name}
                }
            }
        }
    }
}