package com.hvk.idf.data.paging.adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.hvk.idf.R
import com.hvk.idf.data.models.ProductModel
import com.hvk.idf.ui.ProductDetailActivity
import java.io.Serializable


class ProductsRecyclerAdapter(val context: Context) :
    PagingDataAdapter<ProductModel, ProductsRecyclerAdapter.MyViewHolder>(DiffUtilCallBack()) {

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        private val titleTxt: TextView = itemView!!.findViewById(R.id.title_text)
        private val brandTxt: TextView = itemView!!.findViewById(R.id.brand_text)
        private val priceTxt: TextView = itemView!!.findViewById(R.id.price_text)
        private val image: ImageView = itemView!!.findViewById(R.id.image)
        internal val detailBtn: Button = itemView!!.findViewById(R.id.details_button)


        fun bind(data: ProductModel, context: Context) {
            titleTxt.text = data.name
            brandTxt.text = data.brand

            priceTxt.text = data.price

            detailBtn.setOnClickListener {
                val intent = Intent(context, ProductDetailActivity::class.java).apply {
                    putExtra("product", data as Serializable)
                }
                with(context) {
                    startActivity(intent)
                }

            }
            Glide.with(itemView)
                .load(data.image_url)
                .thumbnail(0.05f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions().centerCrop())
                .into(image)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        getItem(position)?.let {
            holder.bind(it, context)
        }

    }


    class DiffUtilCallBack : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }

    }
}