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
        val clickButton = findViewById<Button>(R.id.implicitIntent)
        clickButton.setOnClickListener {
            val intent = Intent().apply {
                this.action = Intent.ACTION_VIEW
                this.data = (Uri.parse("https://www.geeksforgeeks.org/"))
            }
            startActivity(intent)
        }

        val shareButton = findViewById<Button>(R.id.share)
        shareButton.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hello")
                type = "text/plain"
            }

            val title: String = resources.getString(R.string.chooser)

            val chooser: Intent = Intent.createChooser(sendIntent, title)
//            startActivity(sendIntent)

// Verify the original intent will resolve to at least one activity
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }

        val passIntentValueBtn = findViewById<Button>(R.id.passIntent)
        val stat = Stat("Sachin", "Tendulkar", 100, "India", "Retired")
        passIntentValueBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("STAT", stat)
            }
            startActivity(intent)
        }


        val constraintBtn = findViewById<Button>(R.id.constraint)
        constraintBtn.setOnClickListener {
            val constraintIntent = Intent(this, ConstraintLayoutExample::class.java)
            startActivity(constraintIntent)
        }

        val linearLayoutBtn = findViewById<Button>(R.id.linearLayoutExample)
        linearLayoutBtn.setOnClickListener {
            val linearIntent = Intent(this, LinearLayoutExample::class.java)
            startActivity(linearIntent)
        }
    }
}