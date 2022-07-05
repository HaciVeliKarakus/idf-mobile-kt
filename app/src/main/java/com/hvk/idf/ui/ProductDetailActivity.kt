package com.hvk.idf.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.hvk.idf.databinding.ActivityProductDetailBinding
import com.hvk.idf.data.models.ProductModel

class ProductDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.extras!!.get("product") as ProductModel

        Glide.with(binding.root)
            .load(product.image_url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions().centerCrop())
            .into(binding.imageView)

        supportActionBar!!.title = product.brand
        binding.textViewProductID.text = product.id
        binding.textViewBrand.text = product.brand
        binding.textViewName.text = product.name
        binding.textViewBarcode.text = product.barcode
        binding.textViewCrawlerSlug.text = product.crawler_slug
        binding.textViewCategory.text = product.category
        binding.textViewCrawlerDescription.text = product.description
//        price
        binding.textViewPrice.text = product.price
        binding.textViewDiscountPrice.text = product.disc_price
//        master details
        binding.textViewMasterID.text = product.master_id
        binding.textViewMasterStatus.text = product.master_status
        binding.textViewIsMaster.text = product.is_master.toString()
//        date details

        binding.textViewCreateDate.text = product.created_at
        binding.textViewUpdateDate.text = product.updated_at
    }
}