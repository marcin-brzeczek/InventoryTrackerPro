package com.mbit.inventorytracker.emkd_scan

import android.content.Context

object ScanWrapper {

    private var _typeOfScanner: ScannerType? = null

    @Throws(Exception::class)
    fun initScanner(ctx: Context, typeOfScanner: ScannerType) {
        _typeOfScanner = typeOfScanner

        when (_typeOfScanner) {
            ScannerType.ZEBRA -> EmdkSupport.initEmdkSupport(ctx)
            ScannerType.CIPHERLAB -> CipherLabSupport.initCipherLabSupport(ctx)
            ScannerType.CAMERA -> {}
            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun registerScannerListener(onReadScan: OnScannerRead) {
        when (_typeOfScanner) {
            ScannerType.ZEBRA -> EmdkSupport.emdkSupport?.registerScannerListener(onReadScan)
            ScannerType.CIPHERLAB -> CipherLabSupport.cipherLabSupport?.registerScannerListener(onReadScan)
            ScannerType.CAMERA -> {}

            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun unregisterScannerListener() {
        when (_typeOfScanner) {
            ScannerType.ZEBRA -> EmdkSupport.emdkSupport?.unregisterScannerListeners()
            ScannerType.CIPHERLAB -> CipherLabSupport.cipherLabSupport?.unregisterScannerListeners()
            ScannerType.CAMERA -> {}

            else -> {
            }
        }
    }

    @Throws(Exception::class)
    fun deinitScanner() {
        when (_typeOfScanner) {
            ScannerType.ZEBRA -> EmdkSupport.emdkSupport?.onClosed()
            ScannerType.CIPHERLAB -> CipherLabSupport.cipherLabSupport?.releaseScanner()
            ScannerType.CAMERA -> {}

            else -> {
            }
        }
    }
}
