package com.elyseswoverland.ankoplayground

import android.arch.lifecycle.LifecycleObserver
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat



class MainActivity : AppCompatActivity(), AnkoLogger, LifecycleObserver {
    lateinit var ui: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = MainActivityUi()
        ui.setContentView(this)

        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        if (intent.getStringExtra("data") != null) {
            val message = intent.getStringExtra("data")
            val appDialog = alert(Appcompat, message) {
                positiveButton("OK") {}
            }.show()
        }
//        info(message)

        info("MainActivity shown")

        ui.button.setOnClickListener {
//            startActivity<FloatingActivity>()
            val intent = Intent(this@MainActivity, FloatingActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity,
                    ui.circularGraph,
                    ViewCompat.getTransitionName(ui.circularGraph))
            startActivity(intent, options.toBundle())
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
