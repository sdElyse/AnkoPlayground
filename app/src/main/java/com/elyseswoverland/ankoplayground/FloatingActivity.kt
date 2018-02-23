package com.elyseswoverland.ankoplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView

/**
 * Created by e78307
 * on 2/23/18.
 */
class FloatingActivity : AppCompatActivity() {
    lateinit var ui: FloatingActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = FloatingActivityUi()
        ui.setContentView(this)
    }
}