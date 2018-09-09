package com.mbit.inventorytracker.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mbit.inventorytracker.fragments.choose_location.ChooseLocationRoute
import com.mbit.inventorytracker.fragments.abstraction.FragmentBase
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.database.dto.User
import com.mbit.inventorytracker.utilities.alsoUnless
import com.mbit.inventorytracker.utilities.displayError
import com.mbit.inventorytracker.utilities.inflate
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.jetbrains.anko.find

const val READ_REQUEST_CODE = 99

class LoginFragment : FragmentBase() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_login, container) {
                val isEmptyDatabase: Boolean = dbContext.isEmpty
                if (isEmptyDatabase) {
                    btnStartNewInventoryOrContinue.find<TextView>(R.id.title).setText(context.getString(R.string.start_new_inventory))
                    btnExportFileAndStartNewInventory.visibility = View.GONE
                } else {
                    btnStartNewInventoryOrContinue.find<TextView>(R.id.title).setText(context.getString(R.string.continue_current_inventory))
                    btnExportFileAndStartNewInventory.visibility = View.VISIBLE
                    btnExportFileAndStartNewInventory.find<TextView>(R.id.title).setText(context.getString(R.string.start_new_inventory))

                }
                btnExportFileAndStartNewInventory.setOnClickListener { exportFileAndStartNewInventory(); saveCurrentInventory = true }
                btnStartNewInventoryOrContinue.setOnClickListener { loadOrOpenDatabase(isEmptyDatabase); saveCurrentInventory = false }
                setHasOptionsMenu(true)
            }

    override fun onResume() {
        super.onResume()
        etLogin.text.clear()
    }

    private fun validateInput() = alsoUnless({ etLogin.text.isNotBlank() && etLogin.text.isNotEmpty() }) {
        etLogin.text.clear()
        displayError(etLogin, context = activity.baseContext)
    }

    private fun loadOrOpenDatabase(isEmptyDatabase: Boolean) {
        if (!validateInput()) return
        if (isEmptyDatabase) {
            selectCSVFile()
        } else {
            navigateTo(ChooseLocationRoute())
        }
        User(etLogin.text.toString()).save()
    }

    private fun exportFileAndStartNewInventory() {
        if (!validateInput()) return
        requestPermissionOrSaveCSV()
        User(etLogin.text.toString()).save()
    }
}