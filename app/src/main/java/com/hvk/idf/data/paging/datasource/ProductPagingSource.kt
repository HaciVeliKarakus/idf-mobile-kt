package com.hvk.idf.data.paging.datasource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hvk.idf.data.models.ProductListQuery
import com.hvk.idf.data.models.ProductModel
import com.hvk.idf.data.service.ProductApi
import com.hvk.idf.ui.ProductsActivity

private lateinit var productParams: ProductListQuery
private lateinit var mActivity: ProductsActivity

fun initQueryParams(productListQuery: ProductListQuery, mContext:ProductsActivity) {
    productParams = productListQuery
    mActivity = mContext
}

class ProductPagingSource(
    private val service: ProductApi
) : PagingSource<Int, ProductModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductModel> {
        val nextPage = params.key ?: 1
        return try {
            val response = service.getProduct(
                page = nextPage,
                search = productParams.search,
                name = productParams.name,
                id = productParams.id,
                barcode = productParams.barcode
            )

            mActivity.setTitleText(response.info.count.toString())

            var nextPageNumber: Int? = null
            if (response.links.next != null) {
                val uri = Uri.parse(response.links.next.toString())
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            var prevPageNumber: Int? = null
            if (response.links.previous != null) {
                val uri = Uri.parse(response.links.previous.toString())
                val prevPageQuery = uri.getQueryParameter("page")
                prevPageNumber = prevPageQuery?.toInt()
            }

            LoadResult.Page(
                data = response.results,
                prevKey = prevPageNumber,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ProductModel>): Int = 1
}