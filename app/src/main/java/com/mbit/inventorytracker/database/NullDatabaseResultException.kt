package com.mbit.inventorytracker.database

class NullDatabaseResultException : Exception {
    constructor() : super("Query returned nothing!")
    constructor(message: String) : super(message)
}