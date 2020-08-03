package com.example.voilaapp01.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.guide_card.view.*

class GuideViewholder (itemView: View): RecyclerView.ViewHolder(itemView){

    val guideImageView: ImageView =itemView.guide_imageView
    val guideName : TextView =itemView.tv_guideName
    val guideRates : TextView =itemView.tv_guideRate
    val guideCity : TextView =itemView.tv_guideReviews
}