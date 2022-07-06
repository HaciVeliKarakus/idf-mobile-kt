package com.hvk.idf.data.paging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hvk.idf.data.models.ProductListQuery
import com.hvk.idf.data.models.ProductModel
import com.hvk.idf.data.paging.datasource.ProductPagingSource
import com.hvk.idf.data.paging.datasource.initQueryParams
import com.hvk.idf.data.service.ProductApi
import com.hvk.idf.data.service.ServiceGenerator
import com.hvk.idf.ui.ProductsActivity
import com.hvk.idf.utils.TokenManager
import kotlinx.coroutines.flow.Flow

class ProductActivityViewModel : ViewModel() {
    private lateinit var service: ProductApi


    fun initService(context: ProductsActivity, productListQuery: ProductListQuery) {
        val token = TokenManager(context).fetchAuthToken()
        initQueryParams(productListQuery, context)
        service = ServiceGenerator(token).buildService(ProductApi::class.java)
    }

    fun getListData(): Flow<PagingData<ProductModel>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { ProductPagingSource(service) }
        ).flow.cachedIn(viewModelScope)
    }


}