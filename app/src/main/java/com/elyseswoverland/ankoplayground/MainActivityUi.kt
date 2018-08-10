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
    lateinit var circularGraph: ImageView
    override fun createView(ui: AnkoContext<MainActivity>): View = ui.apply {
        relativeLayout {
            verticalLayout {
                name = editText {
                    hint = "Name"
                    visibility = View.GONE
                }.lparams(width = matchParent) {
                    marginStart = dip(16)
                    marginEnd = dip(16)
                }
                circularGraph = imageView(R.drawable.circulargraph) {
                    //                    scaleType = ImageView.ScaleType.FIT_XY
                    transitionName = "simple_activity_transition"
                }.lparams(width = 1000, height = 1000) {
                    gravity = Gravity.CENTER_HORIZONTAL
                    bottomMargin = dip(64)
                }
                button = button("Go") {
                    //                    onClick { ctx.toast("Hello, ${name.text}!") }
                }.lparams(width = matchParent) {
                    marginStart = dip(64)
                    marginEnd = dip(64)
                }
            }.lparams(width = matchParent, height = wrapContent) {
                centerInParent()
            }
        }
    }.view
}