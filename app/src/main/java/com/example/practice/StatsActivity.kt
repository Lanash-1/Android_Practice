package com.example.practice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.practice.model.Stat

class StatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val stat = intent.getSerializableExtra("STAT") as Stat
        val resultStat = "Name: ${stat.firstName} ${stat.lastName}\nCountry: ${stat.country}\nCenturies: ${stat.centuries}\nStatus: ${stat.status}"

        findViewById<TextView>(R.id.textView2).apply {
            text = resultStat
        }

        val getStatBtn = findViewById<Button>(R.id.getStats)
        getStatBtn.setOnClickListener {
            val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("STAT", resultStat)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}