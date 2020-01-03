package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var formate = SimpleDateFormat("dd, MMM, YYYY", Locale.US)
        val btnCalculate:Button = findViewById(R.id.buttonCalculate)
        val btnReset:Button = findViewById(R.id.buttonReset)

        btn_date.setOnClickListener {
            val now = Calendar.getInstance();
            val datePicker = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val seletedDate = Calendar.getInstance()
                    seletedDate.set(Calendar.YEAR, year)
                    seletedDate.set(Calendar.MONTH, month)
                    seletedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = formate.format(seletedDate.time)
                    textViewDate.setText(date)
                    btnCalculate.setOnClickListener{calculate(now.get(Calendar.YEAR), year)}
                },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        //btnCalculate.setOnClickListener{calculate(year)}
        btnReset.setOnClickListener{reset()}
    }

    private fun calculate(currentYear:Int, year:Int)
    {
        //val currentYear = Calendar.YEAR
        var age = currentYear - year
        var saving = 0

        if(age >= 16 && age <= 20)
        {
            saving = 5000
        }
        else if(age >= 21 && age <= 25)
        {
            saving = 14000
        }
        else if(age >= 26 && age <= 30)
        {
            saving = 29000
        }
        else if(age >= 31 && age <= 35)
        {
            saving = 50000
        }
        else if(age >= 36 && age <= 40)
        {
            saving = 78000
        }
        else if(age >= 41 && age <= 45)
        {
            saving = 116000
        }
        else if(age >= 46 && age <= 50)
        {
            saving = 165000
        }
        else if(age >= 51 && age <= 55)
        {
            saving = 228000
        }
        else
        {
            saving = 0
        }

        var amount = saving * 0.3

        textViewAge.text = "Member Age: " + age
        textViewMin.text = "Minimun Basic Saving (RM): " + saving
        textViewAmount.text = "Allowable Investment Amount (RM): " + amount
    }

    private fun reset()
    {
        textViewDate.text = " "
        textViewAge.setText(R.string.age)
        textViewMin.setText(R.string.minimum)
        textViewAmount.setText(R.string.amount)
    }
}
