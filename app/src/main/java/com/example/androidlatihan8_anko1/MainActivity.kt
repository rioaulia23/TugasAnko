package com.example.androidlatihan8_anko1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnlogin.setOnClickListener {
            val username = etuser.text.toString().trim()
            val pass = etpass.text.toString().trim()
            handlingForLogin(username, pass)
        }
        regis.setOnClickListener {
            toast("Pindah ke halaman Register")
            startActivity(intentFor<Register>())
        }
    }

    private fun handlingForLogin(username: String, pass: String) {
        info { "username = $username, password = $pass" }
        if (username.equals("master") && pass.equals("master123")) {
            toast("Welcome $username")

        } else {
            alert(title = "Warning", message = "password atau username salah") {
                positiveButton(buttonText = "ok") {

                }
                isCancelable = false
            }.show()
        }
    }
}
