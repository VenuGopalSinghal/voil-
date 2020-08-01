package com.example.voilaapp01

import android.app.Application
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.voilaapp01.activities.CommonWebView
import com.example.voilaapp01.activities.FilterActivity
import com.example.voilaapp01.model.SearchResponse
import com.example.voilaapp01.model.Searchfilter
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_search_page.*
import org.intellij.lang.annotations.JdkConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)





        cv_Delhi.isClickable
        cv_Delhi.setOnClickListener {
            val intent = Intent(this, CommonWebView::class.java)
            intent.putExtra(
                "D",
                "https://www.tripadvisor.com/Tourism-g304551-New_Delhi_National_Capital_Territory_of_Delhi-Vacations.html"
            )
            startActivity(intent)
        }
        cv_bomdil.isClickable
        cv_bomdil.setOnClickListener {
            val intent = Intent(this, CommonWebView::class.java)
            intent.putExtra(
                "bomdil",
                "https://www.tripadvisor.com/Tourism-g858482-Bomdila_West_Kameng_District_Arunachal_Pradesh-Vacations.html"
            )
            startActivity(intent)

        }
        cv_byebur.isClickable
        cv_byebur.setOnClickListener {
            val intent = Intent(this, CommonWebView::class.java)
            intent.putExtra(
                "byebur",
                "https://www.tripadvisor.com/Tourism-g297591-Bihar-Vacations.html"
            )
            startActivity(intent)
        }
        cv_panipat.isClickable
        cv_panipat.setOnClickListener {
            val intent = Intent(this, CommonWebView::class.java)
            intent.putExtra(
                "panipat",
                "https://www.tripadvisor.com/Tourism-g1584808-Panipat_Panipat_District_Haryana-Vacations.html"
            )
            startActivity(intent)
        }
        cv_shillong.isClickable
        cv_shillong.setOnClickListener {
            val intent = Intent(this, CommonWebView::class.java)
            intent.putExtra(
                "shillong",
                "https://www.tripadvisor.com/Tourism-g503702-Shillong_East_Khasi_Hills_District_Meghalaya-Vacations.html"
            )
            startActivity(intent)
        }

        submit_button.setOnClickListener {


            /*for spinner*/



        spinner_enter_destination.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@HomePage,
                        "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                        Toast.LENGTH_LONG
                    ).show()
                    var State: String = adapterView?.getItemAtPosition(position) as String

                }
            }





        //from Calender
        val fromCalendar = Calendar.getInstance()
        //  val date =SimpleDateFormat("yyyy-mm-dd").format(fromCalendar)
        val year = fromCalendar.get(Calendar.YEAR)
        var month = fromCalendar.get(Calendar.MONTH)
        val day = fromCalendar.get(Calendar.DAY_OF_MONTH)

//        TouristLogin.token


//____________________________________________________________________________________________________

/*
*//*From Date*//*
        fromDate.setOnClickListener {
            val fromDatePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, fyear, fmonth, fdayOfMonth ->


                    tv_fromdate.text = "" + fdayOfMonth + "/" + (fmonth + 1) + "/" + fyear
                    val fromDate: String =
                        (fyear.toString() + "-" + "0" + (fmonth + 1).toString() + "-" + "0" + fdayOfMonth.toString())
                    Toast.makeText(this, fromDate, Toast.LENGTH_SHORT).show()


                },
                year,
                month,
                day
            )
            fromDatePickerDialog.show()
        }*/



//_________________________________________________________________________________________________


        val filterinput = Searchfilter(
            "Delhi", "2020-07-04",
            "2020-07-07", 5, 2, false
        )

        val filterRequest = RetrofitClient.create().search(filterinput)

        filterRequest.enqueue(object : Callback<SearchResponse> {
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e("thisisune",t.message)
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            )
            {
                val searcherror = response.toString()
                Log.d("thisisthemferror", searcherror)
            }
        })

    }
    }

    }


