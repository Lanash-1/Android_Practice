package com.example.practice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practice.model.Stat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickButton = findViewById<Button>(R.id.button2)
        clickButton.setOnClickListener {
            val intent = Intent().apply {
                this.action = Intent.ACTION_VIEW
                this.data = (Uri.parse("https://www.geeksforgeeks.org/"))
            }
            startActivity(intent)
        }

        val shareButton = findViewById<Button>(R.id.button3)
        shareButton.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hello")
                type = "text/plain"
            }

            val title: String = resources.getString(R.string.chooser)

            val chooser: Intent = Intent.createChooser(sendIntent, title)
            startActivity(sendIntent)

// Verify the original intent will resolve to at least one activity
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }

        val passIntentValueBtn = findViewById<Button>(R.id.button)
        val stat = Stat("Sachin", 100, "India", true)
        passIntentValueBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("STAT", stat)
            }
            startActivity(intent)
        }

//        intentValueButton.setOnClickListener {
//            val valuesIntent = Intent(this, MainActivity2::class.java).apply {
//                putExtra("NAME", "Sachin")
//                putExtra("CENTURIES", 100)
//                putExtra("COUNTRY", "India")
//                putExtra("IS_RETIRED", true)
//            }
//            startActivity(valuesIntent)
//        }
    }
}