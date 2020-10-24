package cl.nodalnet.plaplixgoods

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import cl.nodalnet.plaplixgoods.models.viewmodel.MyAdapter
import cl.nodalnet.plaplixgoods.models.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.item_products.*

class FirstFragment : Fragment(), MyAdapter.ProductsID {
    lateinit var mViewModel: MyViewModel
    var mId: Int? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mRecyclerView = recyclerView_Products
        val mAdapter = MyAdapter(this)

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        mViewModel.mAllProducts.observe(viewLifecycleOwner, Observer {
        mAdapter.updateListProducts(it)

        })

    }

    override fun passData(mProductsID: Int) {
        val mBundle = Bundle()
        mBundle.putInt("id",mProductsID)
        Toast.makeText(context, mProductsID.toString(), Toast.LENGTH_SHORT).show()
    }
}