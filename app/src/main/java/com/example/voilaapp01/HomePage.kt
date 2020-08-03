package com.example.voilaapp01

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.voilaapp01.activities.CommonWebView
import com.example.voilaapp01.activities.GuideAdapter
import com.example.voilaapp01.model.ExtraFilter
import com.example.voilaapp01.model.SearchResponse
import com.example.voilaapp01.model.SearchFilter2
import kotlinx.android.synthetic.main.activity_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class HomePage : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
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
            val intent = Intent(this, SearchPage::class.java)
            startActivity(intent)


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
            val year = fromCalendar.get(Calendar.YEAR)
            val month = fromCalendar.get(Calendar.MONTH)
            val day = fromCalendar.get(Calendar.DAY_OF_MONTH)



           /* fromDate.setOnClickListener {
                val fromDatePickerDialog = DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, fyear, fmonth, fdayOfMonth ->

                        tv_fromdate.text = "" + fdayOfMonth + "/" + (fmonth + 1) + "/" + fyear
                    },
                    year,
                    month,
                    day
                )
                fromDatePickerDialog.show()
            }

            toDate.setOnClickListener {
                val toDatePickerDialog = DatePickerDialog(
                    this, DatePickerDialog.OnDateSetListener { view, tyear, tmonth, tdayOfMonth ->

                        tv_todate.text = "" + tdayOfMonth + "/" + (tmonth + 1) + "/" + tyear

                    }
                    ,
                    year,
                    month,
                    day
                )
                toDatePickerDialog.show()
            }
*/

//_________________________________________________________________________________________________
        }

        val filterinput = SearchFilter2(
            "Delhi", "2020-08-04",
            "2020-08-07", 5
        )


        val filterRequest = RetrofitClient.create().search(filterinput)
        /*enqueue method*/
        filterRequest.enqueue((object : Callback<SearchResponse2> {

            /*On Faliure*/

            override fun onFailure(call: Call<SearchResponse2>, t: Throwable) {
                Log.e("thisisune", t.message)
            }

            /*On response*/

            override fun onResponse(
                call: Call<SearchResponse2>,
                response: Response<SearchResponse2>
            ) {
                val searcherror = response.toString()
               // Log.d("rzzzzzzzzzzzzzz", response.body()!!.guides[1].city)


                guidedetails = response.body()!!.guides as ArrayList<Guide>
                Log.d("guideDetailsResponse", guidedetails.toString())

                /* for (item in guidedetails) {
                     var guideName: String = item.name
                     var guidecity: String = item.city
                     var guide_chargeperhead: Int = item.perHeadCharge
                     var guideimage: String = item.picUrl
                 }*/

            }


        }))


    }

    companion object {
        var guidedetails = ArrayList<Guide>()
    }

}


