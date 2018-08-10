package com.elyseswoverland.ankoplayground

import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import org.jetbrains.anko.*

/**
 * Created by e78307
 * on 2/23/18.
 */
class FloatingActivityUi : AnkoComponent<FloatingActivity> {
    lateinit var circularGraph: ImageView
    override fun createView(ui: AnkoContext<FloatingActivity>): View = ui.apply {
        relativeLayout {
            verticalLayout {
                backgroundDrawable = ContextCompat.getDrawable(ctx,
                        R.drawable.rounded_white_background)

                circularGraph = imageView(R.drawable.circulargraph) {
                    scaleType = ImageView.ScaleType.FIT_XY
                    transitionName = "simple_activity_transition"
                }.lparams(width = 300, height = 300) {
                    gravity = Gravity.START
                }
            }.lparams(width = matchParent, height = matchParent) {
                topMargin = dip(150)
                marginStart = dip(16)
                marginEnd = dip(16)
            }
        }
    }.view
}