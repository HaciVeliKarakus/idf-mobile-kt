package com.hvk.idf.data.paging.datasource
//
//import android.net.Uri
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.hvk.idf.data.service.ProductApi
//
//class ProductDataSource(private val service: ProductApi) : PagingSource<Int, ProductApi>() {
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductApi> {
//        val pageNumber = params.key ?: 1
//        return try {
//            val response = service.getProduct(pageNumber)
//
//            var nextPageNumber: Int? = null
//            if (response.?.next != null) {
//                val uri = Uri.parse(pagedResponse.pageInfo.next)
//                val nextPageQuery = uri.getQueryParameter("page")
//                nextPageNumber = nextPageQuery?.toInt()
//            }
//
//            LoadResult.Page(
//                data = data.orEmpty(),
//                prevKey = null,
//                nextKey = nextPageNumber
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, ProductApi>): Int = 1
//}