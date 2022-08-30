package com.example.practice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity2 : AppCompatActivity() {

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
        if(result?.resultCode == Activity.RESULT_OK){
            findViewById<TextView>(R.id.textView).apply {
                text = result.data?.getStringExtra("STAT")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val stat = intent.getSerializableExtra("STAT")

        val showStatBtn = findViewById<Button>(R.id.showStats)
        showStatBtn.setOnClickListener {
            val intent = Intent(this, StatsActivity::class.java).apply {
                putExtra("STAT", stat)
            }
            resultContract.launch(intent)
        }


    }
}