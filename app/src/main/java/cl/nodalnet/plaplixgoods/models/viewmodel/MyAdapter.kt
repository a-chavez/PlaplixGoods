package cl.nodalnet.plaplixgoods.models.viewmodel

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cl.nodalnet.plaplixgoods.models.room.ProductsItem
import kotlinx.android.synthetic.main.item_products.view.*

class MyAdapter() : RecyclerView.Adapter<MyAdapter.mViewHolder>() {
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
            // por hacer
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}