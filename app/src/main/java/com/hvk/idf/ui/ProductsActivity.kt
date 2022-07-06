package com.hvk.idf.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hvk.idf.data.models.ProductListQuery
import com.hvk.idf.data.paging.adapters.ProductsRecyclerAdapter
import com.hvk.idf.data.paging.viewmodel.ProductActivityViewModel
import com.hvk.idf.databinding.ActivityProductsBinding
import kotlinx.coroutines.flow.collectLatest


class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: ProductsRecyclerAdapter
    private lateinit var productListQuery: ProductListQuery

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentExtras()
        initLate()
        initRecyclerView()
        initViewModel()

    }

    fun setTitleText(titleText: String) {
        supportActionBar?.title = "$titleText product found"
    }

    private fun getIntentExtras() {
        productListQuery = ProductListQuery(
            search = intent.extras!!.get("search") as String,
            id = intent.extras!!.get("id") as String,
            name = intent.extras!!.get("name") as String,
            barcode = intent.extras!!.get("barcode") as String,
        )
        println(productListQuery)
    }


    private fun initLate() {
        recyclerView = binding.recyclerview
        recyclerViewAdapter = ProductsRecyclerAdapter(this@ProductsActivity)
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProductsActivity)
            addItemDecoration(
                DividerItemDecoration(
                    applicationContext,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        val viewModel =
            (ViewModelProvider(this@ProductsActivity)[ProductActivityViewModel::class.java]).apply {
                initService(this@ProductsActivity,productListQuery)
            }
        lifecycleScope.launchWhenCreated {

            viewModel.getListData().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }
}