package com.mbit.inventorytracker.activities

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.mbit.inventorytracker.R
import kotlinx.android.synthetic.main.activity_barcode_generation.*
import net.glxn.qrgen.android.QRCode

class BarcodeGenerationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode_generation)


        generateButton.setOnClickListener {
            val text = contentEditText.text.toString()

            if (text.isEmpty()) {
                Toast.makeText(this, "Enter something to create a barcode", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            /*
            * Generate bitmap from the text provided,
            * The QR code can be saved using other methods such as stream(), file(), to() etc.
            * Check out the GitHub README page for the same
            * (https://github.com/kenglxn/QRGen)
            * */
            val bitmap = QRCode.from(text).withSize(1000, 1000).bitmap()
            generationImageView.setImageBitmap(bitmap)
        }
    }
}
