package com.mbit.inventorytracker.fragments.login

import android.os.Parcel
import com.mbit.inventorytracker.backstack.BaseRoute
import paperparcel.PaperParcel

@PaperParcel
    data class LoginRoute(val tag: String = LoginRoute::javaClass.name) : BaseRoute() {

        override fun createFragment() = LoginFragment()

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            PaperParcelLoginRoute.writeToParcel(this, parcel, flags)
        }

        companion object {
            @JvmField
            val CREATOR = PaperParcelLoginRoute.CREATOR
        }
    }

