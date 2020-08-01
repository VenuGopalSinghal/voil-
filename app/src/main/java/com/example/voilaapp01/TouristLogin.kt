package com.example.voilaapp01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.voilaapp01.activities.CommonWebView
import com.example.voilaapp01.model.LoginResponse
import com.example.voilaapp01.model.User
import com.google.android.material.button.MaterialButton
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_tourist_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TouristLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourist_login)


        /*define the local variable email and password*/

        btn_login_tourist.setOnClickListener {
            loader.visibility=View.VISIBLE.times(Short.MIN_VALUE)

            val email = et_email_tourist.text.toString().trim()
            val password = et_pass_tourist.text.toString().trim()

            /*feeding variables to User and storing them in postParams */

            val postParams = User(email, password)

            val loginRequest = RetrofitClient.create().login(postParams)
            loginRequest.enqueue(object : Callback<LoginResponse> {


                /*On FAILURE*/
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                    Log.d("faliure2", postParams.toString())
                    Log.d("faliure2.1", t.toString())


                }

                /*On RESPONSE*/
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()!!

                    //          TouristLogin.token = loginResponse.token

                    if (loginResponse.success) {
                        loader.visibility=View.GONE
                        val builder = AlertDialog.Builder(this@TouristLogin)
                        //set title for alert dialog
                        builder.setTitle("Login Successful")

                        //performing positive action
                        builder.setPositiveButton("Lets get you HOME") { dialogInterface, which ->
                            val intent = Intent(this@TouristLogin, HomePage::class.java)
                            startActivity(intent)
                        }

                        // Create the AlertDialog
                        val alertDialog: AlertDialog = builder.create()
                        // Set other dialog properties
                        alertDialog.setCancelable(false)
                        alertDialog.show()
                    } else {


                        Toast.makeText(this@TouristLogin, "Login Unsuccessful", Toast.LENGTH_SHORT)
                            .show()
                        loader.visibility=View.GONE
                        Log.d("faliure3", loginResponse.toString())

                    }

                }

            })

            btn_register_tourist.isClickable
            btn_register_tourist.setOnClickListener {
                val intent = Intent(this, CommonWebView::class.java)
                intent.putExtra("RegisterTourist", "https://voilas.herokuapp.com/tourists/register")
                startActivity(intent)
            }


            btn_skip_tourist.setOnClickListener {
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)


                /*validations*/

                if (email.isEmpty()) {
                    et_email_tourist.error = "Email required"
                    et_email_tourist.requestFocus()
                    return@setOnClickListener
                }

                if (password.isEmpty()) {
                    et_pass_tourist.error = "Password is Required"
                    et_pass_tourist.requestFocus()
                    return@setOnClickListener
                }
            }
        }
    }

    companion object {

//      lateinit var token: String

    }

}