package com.elyseswoverland.ankoplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat

class MainActivity : AppCompatActivity(), AnkoLogger {
    lateinit var ui: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = MainActivityUi()
        ui.setContentView(this)

        info("MainActivity shown")

        ui.button.setOnClickListener {
            startActivity<FloatingActivity>()
        }
    }

    private fun showAlert(name: String) {

        val dialog = alert(Appcompat, "I heard you like TeabagActivities", "Hello, $name!") {
            positiveButton("Yes, he does") {}
        }.show()
//        if (dialog is AlertDialog) {
////            dialog.window.setDimAmount(0.5f)
//        }
    }

    private fun sendEmail(emailAddress: String) {
        email(emailAddress, "Test email", "Test message")
    }

    private fun sendText(phoneNumber: String) {
        sendSMS(phoneNumber, "They love me. Especially now that I can text you from this amazing app")
    }

    private fun shareText(text: String) {
        share(text)
    }

    override val loggerTag: String
        get() = "TAG"
}
