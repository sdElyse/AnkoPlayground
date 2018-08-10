package com.elyseswoverland.ankoplayground

import android.os.Bundle
import android.support.v4.view.GestureDetectorCompat
import android.support.v7.app.AppCompatActivity
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.WindowManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.setContentView





/**
 * Created by e78307
 * on 2/23/18.
 */
class FloatingActivity : AppCompatActivity(), AnkoLogger, GestureDetector.OnGestureListener {
    lateinit var ui: FloatingActivityUi
    lateinit var gestureDetector: GestureDetectorCompat
    val swipeMinDist = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = FloatingActivityUi()
        ui.setContentView(this)

        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        gestureDetector = GestureDetectorCompat(this, this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.gestureDetector.onTouchEvent(event)) {
            true
        } else super.onTouchEvent(event)
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        if (e2!!.y - e1!!.y > swipeMinDist) {
            finish()
        }
        return true
    }

    override fun onShowPress(e: MotionEvent?) {

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
    }

    override val loggerTag: String
        get() = "TAG"
}