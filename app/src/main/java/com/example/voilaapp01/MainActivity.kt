package com.example.voilaapp01

import android.app.ActivityOptions
import android.content.Intent
import android.content.IntentFilter.create
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.view.animation.PathInterpolatorCompat.create
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create
import com.bumptech.glide.Glide
import com.google.android.material.card.*
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI.create

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*logo animation intent*/


        val firstimage = findViewById<View>(R.id.voila_logo_main)
//        val secondimage = findViewById<View>(R.id.voila_logo_home)

        btn_skip.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            val options =
                ActivityOptions.makeSceneTransitionAnimation(this, firstimage, "voilalogo")
            startActivity(intent, options.toBundle())
            overridePendingTransition(R.anim.down_slide_up,R.anim.down_slide_up)
        }




        btn_tourist.setOnClickListener {
            val intent = Intent(this, TouristLogin::class.java)
            startActivity(intent)
            overridePendingTransition(
                android.R.anim.slide_in_left,
                android.R.anim.slide_in_left
            )

        }


    }
}