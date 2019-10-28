package com.ishow.noah.modules.touch

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.Observer
import com.ishow.common.widget.dialog.picker.PickerDialog
import com.ishow.common.widget.textview.TextViewPro
import com.ishow.noah.modules.base.mvvm.view.AppBindActivity
import com.ishow.noah.R
import com.ishow.noah.databinding.AViewTouchBinding
import kotlinx.android.synthetic.main.a_view_touch.*

/**
 * Created by yuhaiyang on 2019-10-25.
 */
class ViewTouchActivity : AppBindActivity<AViewTouchBinding, ViewTouchViewModel>() {

    private var dispatchStatus: TouchStatus = TouchStatus.RunSuperTrue
    private var touchStatus: TouchStatus = TouchStatus.RunSuperTrue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindContentView(R.layout.a_view_touch)
    }

    override fun initViews() {
        super.initViews()
        touchView.setOnClickListener {
            Log.i(TAG, "    VIEW  onClick activity dispatchTouchEvent true")
        }
    }

    override fun initViewModel(vm: ViewTouchViewModel) {
        super.initViewModel(vm)
        vm.activityDispatch.observe(activity, Observer { dispatchStatus = it })
        vm.activityTouch.observe(activity, Observer { touchStatus = it })
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> Log.i(TAG, "============================")
        }

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


    @Suppress("unused")
    fun onViewClick(v: View) {
        when (v.id) {
            R.id.activityDispatch,
            R.id.activityTouch,
            R.id.viewGroupDispatch,
            R.id.viewGroupTouch,
            R.id.viewGroupInterceptTouch,
            R.id.viewDispatch,
            R.id.viewTouch -> showSelectDialog(v)
        }
    }

    private fun showSelectDialog(v: View) {
        val list = mutableListOf<TouchPickerData>()
        list.add(TouchPickerData(TouchStatus.OnlySuper))
        list.add(TouchPickerData(TouchStatus.RunSuperTrue))
        list.add(TouchPickerData(TouchStatus.RunSuperFalse))
        list.add(TouchPickerData(TouchStatus.NoSuperTrue))
        list.add(TouchPickerData(TouchStatus.NoSuperFalse))
        val dialog = PickerDialog<TouchPickerData>(context)
        dialog.setData(list)
        dialog.setOnSelectedListener { dataBinding.vm?.setCurrentType(v, it) }
        dialog.show()
    }

    companion object {
        private const val TAG = "yhy"
        private const val TAG_CLASS = "ACTIVITY"
    }


}