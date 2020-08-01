package com.example.voilaapp01.activities

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.voilaapp01.R
import kotlinx.android.synthetic.main.activity_common_web_view.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class CommonWebView : AppCompatActivity() {




    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_common_web_view)

        val register=intent.getStringExtra("RegisterTourist")
         val urldelhi= intent.getStringExtra("D")
         val urlbomdil = intent.getStringExtra("bomdil")
         val urlpanipat = intent.getStringExtra("panipat")
         val urlbyebur = intent.getStringExtra("byebur")
         val urlshillong = intent.getStringExtra("shillong")


        wv_common.loadUrl(register)
        wv_common.loadUrl(urldelhi)
        wv_common.loadUrl(urlbomdil)
        wv_common.loadUrl(urlbyebur)
        wv_common.loadUrl(urlpanipat)
        wv_common.loadUrl(urlshillong)


    }
}