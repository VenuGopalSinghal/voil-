package com.example.voilaapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voilaapp01.activities.GuideAdapter
import com.example.voilaapp01.model.ModelGuideRecycler
import kotlinx.android.synthetic.main.activity_search_page.*
//import javax.security.auth.callback.Callback
import kotlin.collections.ArrayList

class SearchPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_page)



//
       val arrayList = HomePage.guidedetails
//        arrayList.add(ModelGuideRecycler("venu",400.toString(),"sewdawdx",R.id.ClassicSpinner)

        Log.d("guideDetailsSeatchPage", arrayList.toString())
        val guideRecyclerView:RecyclerView  = findViewById(R.id.rv_guide)
        var linearLayoutManager = LinearLayoutManager(this)
        guideRecyclerView.layoutManager = linearLayoutManager


        val guideAdapter =GuideAdapter(arrayList)
        guideRecyclerView.adapter = guideAdapter

    }
}




















