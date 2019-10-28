package com.ishow.noah.modules.touch

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Created by yuhaiyang on 2019-10-25.
 *
 */
class TestTouchViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var dispatchStatus: TouchStatus = TouchStatus.RunSuperTrue
    var touchStatus: TouchStatus = TouchStatus.RunSuperTrue
    var interceptStatus: TouchStatus = TouchStatus.RunSuperTrue

    init {
        setBackgroundColor(Color.CYAN)
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

    override fun onInterceptTouchEvent(event: MotionEvent?): Boolean {
        TouchUtils.log(TAG_CLASS, "onInterceptTouchEvent:", event)

        return when (interceptStatus) {
            TouchStatus.OnlySuper -> super.onInterceptTouchEvent(event)
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
        private const val TAG_CLASS = "GROUP"
    }
}