package cl.nodalnet.plaplixgoods.models.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cl.nodalnet.plaplixgoods.R
import cl.nodalnet.plaplixgoods.models.room.ProductsItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.item_products.view.*

class MyAdapter(var mProductsID: ProductsID) : RecyclerView.Adapter<MyAdapter.mViewHolder>() {
    private var dataList = emptyList<ProductsItem>()

    fun updateListSeed(mDataList: List<ProductsItem>){

        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val mProductsUrl    = itemView.imgProducts
        val mProductsDetail = itemView.tvDetail
        val mProductsPrice  = itemView.tvPrice
        val mProductsId     = itemView.tvId
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {
            mProductsID.passData(dataList[adapterPosition].id)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_products,parent,false)
        return mViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val mProductsItem: ProductsItem = dataList[position]
        holder.mProductsId.text = mProductsItem.id.toString()
        holder.mProductsDetail.text = mProductsItem.name.capitalize()
        holder.mProductsPrice.text = mProductsItem.price.toString()
        Glide.with(holder.itemView.context)
            .load(mProductsItem.image)
            .transform(CenterCrop(), RoundedCorners(20))
            .into(holder.mProductsUrl)
    }

    override fun getItemCount() = dataList.size

    interface ProductsID{
        fun passData(mProductsID: Int )
    }
}