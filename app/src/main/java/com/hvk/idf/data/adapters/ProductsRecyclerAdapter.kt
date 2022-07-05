package com.hvk.idf.data.adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.hvk.idf.R
import com.hvk.idf.data.models.ProductModel
import com.hvk.idf.ui.ProductDetailActivity
import java.io.Serializable


class ProductsRecyclerAdapter(val context: Context, private var productList: List<ProductModel>) :
    RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val titleTxt: TextView = itemView!!.findViewById(R.id.title_text)
        val brandTxt: TextView = itemView!!.findViewById(R.id.brand_text)
        val priceTxt: TextView = itemView!!.findViewById(R.id.price_text)
        val image: ImageView = itemView!!.findViewById(R.id.image)
        val detailBtn: Button = itemView!!.findViewById(R.id.details_button)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTxt.text = productList[position].name
        holder.brandTxt.text = productList[position].brand
        holder.priceTxt.text = productList[position].price
        holder.detailBtn.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java).apply {
                putExtra("product", productList[position] as Serializable)
            }
            with(context) {
                startActivity(intent)
            }

        }



        Glide.with(context)
            .load(productList[position].image_url)
            .thumbnail(0.05f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setData(results: List<ProductModel>) {
        this.productList = results
        this.notifyDataSetChanged()
    }


}