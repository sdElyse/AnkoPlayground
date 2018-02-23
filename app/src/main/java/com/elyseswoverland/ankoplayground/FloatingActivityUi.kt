package com.elyseswoverland.ankoplayground

import android.support.v4.content.ContextCompat
import android.view.View
import org.jetbrains.anko.*

/**
 * Created by e78307
 * on 2/23/18.
 */
class FloatingActivityUi : AnkoComponent<FloatingActivity> {

    override fun createView(ui: AnkoContext<FloatingActivity>): View = ui.apply {
        relativeLayout {
            verticalLayout {
                backgroundDrawable = ContextCompat.getDrawable(ctx,
                        R.drawable.rounded_white_background)
            }.lparams(width = matchParent, height = matchParent) {
                topMargin = dip(150)
                marginStart = dip(16)
                marginEnd = dip(16)
            }
        }
    }.view
}