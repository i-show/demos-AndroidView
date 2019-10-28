package com.ishow.noah.modules.touch

import androidx.databinding.BindingAdapter
import com.ishow.common.widget.textview.TextViewPro

/**
 * Created by yuhaiyang on 2019-10-28.
 *
 */
object ViewTouchBindingAdapter {

    @JvmStatic
    @BindingAdapter("bindTouchStatus")
    fun bindTouchStatus(view: TextViewPro, status: TouchStatus) {
        view.setText(status.des)
    }

    @JvmStatic
    @BindingAdapter(value = ["bindDispatchTouchStatus", "bindTouchStatus", "bindInterceptStatus"])
    fun bindTouchStatus(
        view: TestTouchViewGroup,
        dispatch: TouchStatus,
        intercept: TouchStatus,
        touch: TouchStatus
    ) {
        view.dispatchStatus = dispatch
        view.interceptStatus = intercept
        view.touchStatus = touch
    }


    @JvmStatic
    @BindingAdapter(value = ["bindDispatchTouchStatus", "bindTouchStatus"])
    fun bindTouchStatus(
        view: TestTouchView,
        dispatch: TouchStatus,
        touch: TouchStatus
    ) {
        view.dispatchStatus = dispatch
        view.touchStatus = touch
    }
}