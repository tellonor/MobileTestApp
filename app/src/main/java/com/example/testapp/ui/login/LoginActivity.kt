package com.example.testapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.testapp.R
import com.example.testapp.WebActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener {
            val intent = Intent(this, WebActivity::class.java)
            val userNameReg: String = findViewById<TextView>(R.id.userName).getText().toString()
            val passwordReg = findViewById<TextView>(R.id.password).getText().toString()

            if(userNameReg=="admin" && passwordReg=="12345") {
                startActivity(intent)
            } else {
                findViewById<TextView>(R.id.error_msg).setVisibility(View.VISIBLE)
            }
        }

    }



}

