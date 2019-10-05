package com.example.androidlatihan8_anko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        btn_regis.setOnClickListener {
            val name = etname.text.toString()
            val pass = et_inputpass.text.toString()
            handlingForRegister(name, pass)
        }
    }

    private fun handlingForRegister(username: String, pass: String) {
        when {
            username.isEmpty() -> toast("username kosong")
            pass.isEmpty() -> toast("password kosong")
            else -> alert(title = "Register", message = "User telah terdaftar") {
                positiveButton(buttonText = "Ok") {
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
        }
    }
}