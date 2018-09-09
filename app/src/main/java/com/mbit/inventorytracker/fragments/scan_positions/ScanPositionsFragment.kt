package com.mbit.inventorytracker.fragments.scan_positions

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.activities.BarcodeScanningActivity
import com.mbit.inventorytracker.activities.MainActivity
import com.mbit.inventorytracker.cache.LocationCache.locationName
import com.mbit.inventorytracker.database.dto.Item
import com.mbit.inventorytracker.database.dto.Item_Table
import com.mbit.inventorytracker.emkd_scan.OnScannerRead
import com.mbit.inventorytracker.emkd_scan.ScanWrapper
import com.mbit.inventorytracker.emkd_scan.ScannerType
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import com.mbit.inventorytracker.fragments.new_position.NewItemRoute
import kotlinx.android.synthetic.main.fragment_scan_positions.*
import kotlinx.android.synthetic.main.fragment_scan_positions.view.*
import org.jetbrains.anko.find

class ScanPositionsFragment : FragmentBase(), OnScannerRead {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_scan_positions, container, false).apply {
            try {
                ScanWrapper.initScanner(activity.baseContext, ScannerType.CAMERA)
            } catch (e: Exception) {
                exceptionMessage(context.getString(R.string.error_init_scanner) + e.message)
            }
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNewItem.setOnClickListener { navigateTo(NewItemRoute(locationName = locationName)) }
        layout_button_scan.setOnClickListener { startActivityForResult(Intent(activity, BarcodeScanningActivity::class.java),2) }
        layout_button_scan.find<TextView>(R.id.title).setText(getString(R.string.scan_code))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2) {
            val text: String? = data?.getStringExtra("HANDLED_CODE")
            text?.let { getPositionByCode(it) }
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            ScanWrapper.registerScannerListener(this)

        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_registry_scanner) + e.message)
        }
    }

    public override fun onPause() {
        super.onPause()
        try {
            ScanWrapper.unregisterScannerListener()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.error_unregistry_scanner) + e.message)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            ScanWrapper.deinitScanner()
        } catch (e: Exception) {
            exceptionMessage(getString(R.string.cant_release_scanner) + e.message)
        }
    }

    override fun onReadData(data: String) {
        editTextEAN.setText(data)
        val enterSuffix = "\n"
        val finishData = if (data.contains(enterSuffix)) data.removeSuffix(enterSuffix) else data
        getPositionByCode(finishData)
    }


    override fun onReadStatus(text: String) {
    }

    override fun exceptionMessage(text: String) {
        Toast.makeText(activity.baseContext, text, Toast.LENGTH_LONG).show();
    }

    private fun getPositionByCode(codew: String) {
        val item: Item? = dbContext.items.where(Item_Table.code.eq(codew)).and(Item_Table.oldLocation.eq(locationName)).querySingle()
        item?.let {
            sectionLogo.visibility = View.GONE
            sectionScann.visibility = View.VISIBLE
            tvName.setText(it.name)
            tvAmount.setText((++it.endNumber).toString())
            tvLokalization.setText(it.oldLocation)
            it.save()
        } ?: showNewPositionDialog(codew)
    }

    fun showNewPositionDialog(codePos: String) {
        NewPositionDialogFragment({ navigateTo(NewItemRoute(code = codePos, locationName = locationName)) }).show((activity as MainActivity).fragmentManager, "dialog")
    }

}