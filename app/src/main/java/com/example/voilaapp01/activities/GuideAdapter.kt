package com.example.voilaapp01.activities

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.voilaapp01.Guide
import com.example.voilaapp01.HomePage
import com.example.voilaapp01.R
import com.example.voilaapp01.model.GuideViewholder
import com.example.voilaapp01.model.ModelGuideRecycler
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.guide_card.view.*


class GuideAdapter(private val dataList: ArrayList<Guide>) :
    RecyclerView.Adapter<GuideViewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewholder {
        Log.d( "guideDetailsAdapter",dataList.toString())
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.guide_card, parent, false)
        return GuideViewholder(itemView)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: GuideViewholder, position: Int) {
        Log.d("guideDetailsBindViewHolder" , dataList[position].toString())
        holder.guideCity.text = dataList[position].city.toString()
        holder.guideName.text=dataList[position].name.toString()
        holder.guideRates.text=dataList[position].perHeadCharge.toString()
   //     holder.guideImageView.setImageResource()



    }


}