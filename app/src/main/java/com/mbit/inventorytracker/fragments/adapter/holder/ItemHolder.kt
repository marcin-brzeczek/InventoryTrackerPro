package com.mbit.inventorytracker.fragments.adapter.holder

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.fragments.FragmentType
import com.mbit.inventorytracker.fragments.adapter.ItemStatus
import com.mbit.inventorytracker.fragments.adapter.holder.GenericViewHolder
import com.mbit.inventorytracker.fragments.adapter.viewmodel.ItemViewModel

class ItemHolder(view: View) : GenericViewHolder<ItemViewModel>(view) {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun bind(itemVM: ItemViewModel, fragmentType: FragmentType) {

        when (fragmentType) {

            FragmentType.EmptyListFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                (itemView.findViewById(R.id.tvAmountPos) as TextView).setText(itemVM.item.startNumber.toString())
            }

            FragmentType.ScannedListFragment -> {
                (itemView.findViewById(R.id.tvName) as TextView).setText(itemVM.item.name)
                val tvAmount = (itemView.findViewById(R.id.tvAmountPos) as TextView)
                tvAmount.setText(itemVM.item.endNumber.toString())

                when (itemVM.getStatus()) {
                    ItemStatus.Brak -> tvAmount.setTextColor(itemVM.context.getColor(R.color.red200))
                    ItemStatus.Nadwyzka -> tvAmount.setTextColor(itemVM.context.getColor(R.color.blue400))
                    ItemStatus.Zgodny -> tvAmount.setTextColor(itemVM.context.getColor(R.color.teal400))
                }
            }
        }
    }
}