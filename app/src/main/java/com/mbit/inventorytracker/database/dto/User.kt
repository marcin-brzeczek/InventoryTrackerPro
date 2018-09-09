package com.mbit.inventorytracker.database.dto

import android.os.Parcel
import com.mbit.inventorytracker.database.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import com.mbit.inventorytracker.abstraction.ParcelableLite

import paperparcel.PaperParcel
import java.util.*


@PaperParcel
@Table(database = AppDatabase::class)
data class User(

        @Column
        var name: String = "",

        @PrimaryKey
        @Column
        var id: UUID = UUID.randomUUID()

) : BaseModel(), ParcelableLite {
    @Deprecated("Do not use this method! Used only to materialize the object by database provider.")
    internal constructor () : this(name = "")

    companion object {
        @JvmField
        val CREATOR = PaperParcelUser.CREATOR
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelUser.writeToParcel(this, dest, flags)
    }
}