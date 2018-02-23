package com.elyseswoverland.ankoplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {
    lateinit var ui: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = MainActivityUi()
        ui.setContentView(this)

        ui.button.setOnClickListener {
            alert(Appcompat, "Hello, ${ui.name.text}!", "Important Message") {
                positiveButton("Hi, you!") {}
            }.show()
        }
    }
}
