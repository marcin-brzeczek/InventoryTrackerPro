package com.mbit.inventorytracker.database

import com.mbit.inventorytracker.database.dto.Item
import com.mbit.inventorytracker.database.dto.User
import com.raizlabs.android.dbflow.sql.language.From
import com.raizlabs.android.dbflow.sql.language.SQLite
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DBContext @Inject constructor() {

    val items: From<Item>
        get() = SQLite.select().from(Item::class.java)

    val users: From<User>
        get() = SQLite.select().from(User::class.java)

    val isEmpty :Boolean
    get() = !items.hasData()
}