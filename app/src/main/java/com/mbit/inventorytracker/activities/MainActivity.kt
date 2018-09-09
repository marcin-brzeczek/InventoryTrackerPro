package com.mbit.inventorytracker.activities

import android.os.Bundle
import com.mbit.inventorytracker.fragments.report.ReportRoute
import com.mbit.inventorytracker.R
import com.mbit.inventorytracker.activities.abstraction.ActivityBase

class MainActivity : ActivityBase() {

    override val layoutId = R.layout.activity_main
    override val startRoute get() = ReportRoute()

}