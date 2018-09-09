package com.mbit.inventorytracker.emkd_scan

interface OnScannerRead {
    fun onReadData(text: String)
    fun onReadStatus(text: String)
    fun exceptionMessage(text: String)
}