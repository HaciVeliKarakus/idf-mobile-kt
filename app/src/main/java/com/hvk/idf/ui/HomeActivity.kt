package com.hvk.idf.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hvk.idf.R
import com.hvk.idf.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnCrawlers = binding.btnCrawlers.also {
            it.setOnClickListener(this)
        }
        val btnProducts = binding.btnProducts.also {
            it.setOnClickListener(this)
        }
        val btnSchedulers = binding.btnSchedulers.also {
            it.setOnClickListener(this)
        }
        val btnWebhooks = binding.btnWebhooks.also {
            it.setOnClickListener(this)
        }

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_crawlers -> {
                startActivity(Intent(this, CrawlersActivity::class.java))
            }
            R.id.btn_products -> {
                startActivity(Intent(this, ProductsActivity::class.java))
            }
            R.id.btn_schedulers -> {
                startActivity(Intent(this, SchedulersActivity::class.java))
            }
            R.id.btn_webhooks -> {
                startActivity(Intent(this, WebhooksActivity::class.java))
            }
        }
    }
}