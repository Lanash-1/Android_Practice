package com.example.practice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.practice.databinding.ActivityTextInputLayoutExampleBinding
import com.example.practice.model.Credentials

class TextInputLayoutExample : AppCompatActivity() {
    private lateinit var binding: ActivityTextInputLayoutExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextInputLayoutExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()
        passwordFocusListener()
        numberFocusListener()

        binding.formSubmitBtn.setOnClickListener {
            submitForm()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun submitForm() {
        binding.emailLayout.helperText = validEmail()
        binding.passwordLayout.helperText = validPassword()
        binding.numberLayout.helperText = validNumber()

        val validEmail = binding.emailLayout.helperText == null
        val validPassword = binding.passwordLayout.helperText == null
        val validPhone = binding.numberLayout.helperText == null

        if (validEmail && validPassword && validPhone) {
            val credentials = Credentials(
                binding.emailInput.text.toString(),
                binding.passwordInput.text.toString(),
                binding.numberInput.text.toString()
            )
            val submitIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("CREDENTIALS", credentials)
            }
            setResult(Activity.RESULT_OK, submitIntent)
            finish()
        }
    }

//    private fun invalidForm() {
//        TODO("Not yet implemented")
//    }



    private fun numberFocusListener() {
        binding.numberInput.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.numberLayout.helperText = validNumber()
            }
        }
    }

    private fun validNumber(): String? {
        val number = binding.numberInput.text.toString()

        if(number.isEmpty()){
            return null
        }
        if(!number.matches(".*[0-9].*".toRegex()))
        {
            return "Must be all Digits"
        }
        if(number.length != 10)
        {
            return "Must be 10 Digits"
        }
        return null

    }

    private fun passwordFocusListener() {
        binding.passwordInput.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.passwordLayout.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.passwordInput.text.toString()
        if(passwordText.length < 8)
        {
            return "Minimum 8 Character Password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }

        return null

    }

    private fun emailFocusListener() {
        binding.emailInput.setOnFocusChangeListener{ _ , focused ->
            if(!focused){
                binding.emailLayout.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.emailInput.text.toString()
        if(emailText.isEmpty()){
            binding.emailInput.error="Empty mail id"
            return binding.emailInput.error as String
        }
        if(Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return null
        }
        return "Invalid Email Address"
    }
}