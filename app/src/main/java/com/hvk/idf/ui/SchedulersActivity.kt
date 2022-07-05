package com.hvk.idf.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hvk.idf.R
import com.hvk.idf.databinding.ActivityHomeBinding

class SchedulersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_schedulers)


    }
}