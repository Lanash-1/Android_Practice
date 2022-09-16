package com.example.practice

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.practice.model.Credentials
import com.example.practice.model.Stat

class MainActivity : AppCompatActivity() {

    lateinit var credentials: Credentials

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
        if(result?.resultCode == Activity.RESULT_OK){
            credentials = result.data?.getSerializableExtra("CREDENTIALS") as Credentials
        }
    }


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

        val relativeLayoutBtn = findViewById<Button>(R.id.relativeLayoutExample)
        relativeLayoutBtn.setOnClickListener {
            val linearIntent = Intent(this, RelativeLayoutExample::class.java)
            startActivity(linearIntent)
        }

        val formBtn = findViewById<Button>(R.id.formUiExample)
        formBtn.setOnClickListener {
            val formIntent = Intent(this, TextInputLayoutExample::class.java)
            resultContract.launch(formIntent)
        }
    }
}