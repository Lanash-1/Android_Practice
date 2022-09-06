package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.practice.model.Stat

class LinearLayoutExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout_example)

        val submitBtn = findViewById<Button>(R.id.submit_btn)


        submitBtn.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.firstName).text
            val lastName = findViewById<EditText>(R.id.lastName).text
            val country = findViewById<EditText>(R.id.country).text
            val centuryCount = findViewById<EditText>(R.id.century).text
            val radioGroup = findViewById<RadioGroup>(R.id.status_radio_group)
            val status = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text
            val newStat = Stat(firstName.toString(), lastName.toString(), centuryCount.toString().toInt(), country.toString(), status.toString())
            val submitIntent = Intent(this, StatsActivity::class.java).apply {
                putExtra("STAT", newStat)
            }
            startActivity(submitIntent)
        }


    }

}