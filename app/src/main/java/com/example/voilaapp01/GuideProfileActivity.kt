package com.example.voilaapp01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_guide_search_switcher.*

class GuideProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_profile)

       /* cv_guide.setOnClickListener{
            val intent = Intent(this,GuideProfileActivity::class.java)
            startActivity(intent)
        }
*/
    }
}