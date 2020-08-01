package com.example.voilaapp01.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.voilaapp01.R
import com.example.voilaapp01.SearchPage
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        btn_submit_filter.setOnClickListener {
            val intent = Intent(this,SearchPage::class.java)
            startActivity(intent)
        }
    }
}