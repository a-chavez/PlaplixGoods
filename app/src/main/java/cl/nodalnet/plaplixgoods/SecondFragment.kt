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
import cl.nodalnet.plaplixgoods.models.viewmodel.MyAdapter
import cl.nodalnet.plaplixgoods.models.viewmodel.MyViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.item_products.*

class SecondFragment : Fragment() {

    lateinit var mViewModel: MyViewModel
    var mId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        arguments?.let {
            mId = it.getInt("id",1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      mViewModel.getOneGoods(mId).observe(viewLifecycleOwner, Observer {
          tvSecName.setText(it.name)
          tvSecDescr.setText(it.description)
          tvSecPrice.setText(it.price.toString())
          tvSecLastPrice.setText(it.lastPrice.toString())
          tvSecCredit.setText(it.credit.toString())

          Glide.with(this)
              .load(it.image)
              .transform(CenterCrop(), RoundedCorners(20))
              .into(imgsecDetails)
      })


    }
}