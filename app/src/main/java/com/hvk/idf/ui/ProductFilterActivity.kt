package com.hvk.idf.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hvk.idf.databinding.ActivityProductFilterBinding

class ProductFilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initResultButton()
    }

    private fun initResultButton() {
        binding.buttonGetResults.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java).apply {
                putExtra("search", binding.editTextSearch.text.toString())
                putExtra("name", binding.editTextName.text.toString())
                putExtra("id", binding.editTextID.text.toString())
                putExtra("barcode", binding.editTextBarcode.text.toString())
            }
            with(this) {
                startActivity(intent)
            }
        }
    }
}