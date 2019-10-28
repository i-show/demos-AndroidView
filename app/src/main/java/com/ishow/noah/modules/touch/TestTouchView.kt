package com.ishow.noah.modules.touch

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by yuhaiyang on 2019-10-25.
 *
 */
class TestTouchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var dispatchStatus: TouchStatus = TouchStatus.RunSuperTrue
    var touchStatus: TouchStatus = TouchStatus.RunSuperTrue

    init {
        setBackgroundColor(Color.BLUE)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        TouchUtils.log(TAG_CLASS, "dispatchTouchEvent:", event)
        return when (dispatchStatus) {
            TouchStatus.OnlySuper -> super.dispatchTouchEvent(event)

            TouchStatus.RunSuperTrue -> {
                super.dispatchTouchEvent(event)
                true
            }
            TouchStatus.RunSuperFalse -> {
                super.dispatchTouchEvent(event)
                false
            }
            TouchStatus.NoSuperTrue -> true
            TouchStatus.NoSuperFalse -> false
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        TouchUtils.log(TAG_CLASS, "onTouchEvent:", event)
        return when (touchStatus) {
            TouchStatus.OnlySuper -> super.onTouchEvent(event)

            TouchStatus.RunSuperTrue -> {
                super.onTouchEvent(event)
                true
            }
            TouchStatus.RunSuperFalse -> {
                super.onTouchEvent(event)
                false
            }
            TouchStatus.NoSuperTrue -> true
            TouchStatus.NoSuperFalse -> false
        }
    }

    companion object {
        private const val TAG = "yhy"
        private const val TAG_CLASS = "VIEW"
    }
}