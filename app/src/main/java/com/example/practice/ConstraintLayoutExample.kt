package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.practice.databinding.ActivityConstraintLayoutExampleBinding

class ConstraintLayoutExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConstraintLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null){
            supportFragmentManager.commit {
                add<ChatsFragment>(R.id.constraint_fragment)
            }
        }

        val chatButton = findViewById<Button>(R.id.chatButton)
        chatButton.setOnClickListener {
            supportFragmentManager.commit {
                replace<ChatsFragment>(R.id.constraint_fragment)
            }
        }

        val statusButton = findViewById<Button>(R.id.statusButton)
        statusButton.setOnClickListener {
            supportFragmentManager.commit {
                //addToBackStack(null)
                replace<StatusFragment>(R.id.constraint_fragment)
            }
        }

    }
}