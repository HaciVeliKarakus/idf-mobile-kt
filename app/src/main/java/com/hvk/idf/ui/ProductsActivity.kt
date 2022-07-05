package com.hvk.idf.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hvk.idf.data.adapters.ProductsRecyclerAdapter
import com.hvk.idf.databinding.ActivityProductsBinding
import com.hvk.idf.data.models.ProductResponse
import com.hvk.idf.data.service.ProductApi
import com.hvk.idf.data.service.ServiceGenerator
import com.hvk.idf.utils.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding


    private val TAG = "ProductsActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val token = TokenManager(this@ProductsActivity).fetchAuthToken()
        val recyclerView = binding.recyclerview

        val service = ServiceGenerator(token).buildService(ProductApi::class.java)
        service.getProduct(1)
            .enqueue(object : Callback<ProductResponse> {
                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                    if (response.isSuccessful) {
                        println(response.body()!!.results)
                        recyclerView.layoutManager = LinearLayoutManager(this@ProductsActivity)

                        val recyclerAdapter =
                            ProductsRecyclerAdapter(
                                this@ProductsActivity,
                                response.body()!!.results
                            )
                        recyclerView.setHasFixedSize(true)
                        recyclerView.adapter = recyclerAdapter

                    } else
                        println(TAG + "onResponse: " + response.errorBody().toString())
                }

                override fun onFailure(
                    call: Call<ProductResponse>,
                    t: Throwable
                ) {
                    println(TAG + "onFailure: " + t.message)
                }

            })


        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    println("test")
                }
            }
        })
    }


}