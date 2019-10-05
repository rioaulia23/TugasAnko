package com.example.androidlatihan8_anko1.AnkoLayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import com.example.androidlatihan8_anko1.After
import com.example.androidlatihan8_anko1.R
import com.example.androidlatihan8_anko1.Register
import org.jetbrains.anko.*

class Main2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewLogin().setContentView(this)

        val btn: Button = findViewById(R.id.btnlogin)
        val regis: TextView = findViewById(R.id.regis)
        val nama: TextView = findViewById(R.id.etname)
        val pass: TextView = findViewById(R.id.et_inputpass)

        btn.setOnClickListener {
            val nama = nama.text.toString().trim()
            val pass = pass.text.toString().trim()
            handlingForLogin(nama, pass)
        }
        regis.setOnClickListener {
            startActivity(intentFor<Register>())
        }
    }

    class ViewLogin : AnkoComponent<Main2> {
        override fun createView(ui: AnkoContext<Main2>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.abu
                }
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent) {
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20
                    }
                    textView {
                        text = "Login"
                        textSize = 20.0f
                        textColor = Color.CYAN
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    editText {
                        hint = "Input Your Name"
                        id = R.id.etname
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    editText {
                        hint = "Input Your Password"
                        id = R.id.et_inputpass
                        inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    button("Login") {
                        id = R.id.btnlogin
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Register"
                        id = R.id.regis
                        textSize = 15.0f
                        textColor = Color.BLUE
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                }
            }
        }

    }

    private fun handlingForLogin(username: String, pass: String) {
        info { "username = $username, password = $pass" }
        if (username.equals("master") && pass.equals("master123")) {
            toast("Welcome $username")
            startActivity(intentFor<After>("nama" to username))
            finish()
        } else {
            alert(title = "Warning", message = "password atau username salah") {
                positiveButton(buttonText = "ok") {

                }
                isCancelable = false
            }.show()
        }
    }
}