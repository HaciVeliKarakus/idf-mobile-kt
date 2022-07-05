package com.hvk.idf.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hvk.idf.R
import com.hvk.idf.databinding.ActivityCrawlersBinding

class CrawlersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrawlersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrawlersBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_crawlers)


    }

}