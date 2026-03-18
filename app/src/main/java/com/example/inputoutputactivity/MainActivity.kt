package com.example.inputoutputactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    enum class languages {
        ENGLISH,
        AFRIKAANS,
        SPANISH,
        XHOSA,
        ZULU,
        TSWANA,
        SOTHO,
    } 
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val clickMeButton = findViewById<Button>(R.id.clickBtn)
        val welcomeTxt = findViewById<TextView>(R.id.Hellotext)
        val nameTxtField = findViewById<EditText>(R.id.Nametext)
        val zuluSwitch = findViewById<Switch>(R.id.zuluSwitch)

        clickMeButton?.setOnClickListener {

            Toast.makeText(this@MainActivity, "Button clicked",
                Toast.LENGTH_LONG
                    ).show()

            welcomeTxt.text = "Welcome, ${nameTxtField.text}!"
        }
        clickMeButton?.setOnClickListener {
            var greeting: String
            val zulu: Boolean = zuluSwitch.isChecked
            val age: Int = 20
            if (zuluSwitch.isChecked) {
                   greeting = "Sawubona, ${nameTxtField.text}!"
                } else {
                    greeting = "Greetings, ${nameTxtField.text}!"
                }
                welcomeTxt.text = greeting
            }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}