package com.example.voilaapp01.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.voilaapp01.HomePage
import com.example.voilaapp01.R
import com.example.voilaapp01.RetrofitClient
import com.example.voilaapp01.TouristLogin
import com.example.voilaapp01.model.SignupResponse
import com.example.voilaapp01.model.UserSignup
import kotlinx.android.synthetic.main.activity_tourist_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TouristSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourist_signup)


        btn_skip_SU_tourist.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        btn_SU_tourist.setOnClickListener {


            /*Defining Variable*/
            val email_su = et_SU_email_tourist.text.toString().trim()
            val name_su = et_SU_name_tourist.text.toString().trim()
            var e = et_SU_age_tourist.text.toString().trim()
            val age_su = Integer.parseInt(e)
            var m = et_SU_number_tourist.text.toString().trim()
            val phone_su = Integer.parseInt(m)
            val nation = et_SU_nation_tourist.text.toString().trim()
            val gender_su = et_SU_gender_tourist.text.toString().trim()
            val password_su = et_SU_pass_tourist.text.toString().trim()
            val confirm_pass = et_SU_confirmpass_tourist.text.toString().trim()


            /*if else confirm pass==pass*/

            if (password_su == confirm_pass) {

                /*PostParam for Signup*/

                val postparams = UserSignup(
                    name_su,
                    gender_su,
                    phone_su,
                    age_su,
                    email_su,
                    "venu",
                    nation,
                    false,
                    password_su
                )

                val signUpRequest = RetrofitClient.create().signup(postparams)
                signUpRequest.enqueue(object : Callback<SignupResponse> {


                    /*On Faliure*/

                    override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                        Log.d("faliure2.1", t.toString())
                    }

                    /*on response*/

                    override fun onResponse(
                        call: Call<SignupResponse>,
                        response: Response<SignupResponse>
                    ) {
                        /*Toast*/
                        Toast.makeText(this@TouristSignup,
                            "SignUp Successful",
                            Toast.LENGTH_SHORT).show()

                        val intent=Intent(this@TouristSignup,TouristLogin::class.java)
                        startActivity(intent)

                        val signupResponse = response.body()!!
                        Log.d("faliure3", signupResponse.toString())
                    }


                })
            } else {
                Toast.makeText(
                    this,
                    "The Passwords do not match.\n Please check and try again.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}