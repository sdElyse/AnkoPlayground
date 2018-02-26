package com.elyseswoverland.ankoplayground

import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import org.jetbrains.anko.*

/**
 * Created by Elyse
 * on 2/22/18.
 */
class MainActivityUi : AnkoComponent<MainActivity> {
    lateinit var name: EditText
    lateinit var button: Button
    lateinit var teabagImage: ImageView
    override fun createView(ui: AnkoContext<MainActivity>): View = ui.apply {
        relativeLayout {
            verticalLayout {
                name = editText {
                    hint = "Name"
                }.lparams(width = matchParent) {
                    marginStart = dip(16)
                    marginEnd = dip(16)
                }
                button = button("Say Hello") {
//                    onClick { ctx.toast("Hello, ${name.text}!") }
                }.lparams(width = matchParent) {
                    marginStart = dip(64)
                    marginEnd = dip(64)
                }
                teabagImage = imageView(R.drawable.tea) {
//                    scaleType = ImageView.ScaleType.FIT_XY
                    transitionName = "simple_activity_transition"
                }.lparams(width = 300, height = 300) {
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }.lparams(width = matchParent, height = wrapContent) {
                centerInParent()
            }
        }
    }.view
}