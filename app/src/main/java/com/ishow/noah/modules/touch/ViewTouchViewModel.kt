package com.ishow.noah.modules.touch

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ishow.common.widget.textview.TextViewPro
import com.ishow.noah.R
import com.ishow.noah.modules.base.mvvm.viewmodel.AppBaseViewModel
import kotlinx.android.synthetic.main.a_view_touch.*

/**
 * Created by yuhaiyang on 2019-10-25.
 */
class ViewTouchViewModel(app: Application) : AppBaseViewModel(app) {

    private val _activityDispatch = MutableLiveData<TouchStatus>()
    val activityDispatch: LiveData<TouchStatus>
        get() = _activityDispatch

    private val _activityTouch = MutableLiveData<TouchStatus>()
    val activityTouch: LiveData<TouchStatus>
        get() = _activityTouch

    private val _groupDispatch = MutableLiveData<TouchStatus>()
    val groupDispatch: LiveData<TouchStatus>
        get() = _groupDispatch

    private val _groupIntercept = MutableLiveData<TouchStatus>()
    val groupIntercept: LiveData<TouchStatus>
        get() = _groupIntercept

    private val _groupTouch = MutableLiveData<TouchStatus>()
    val groupTouch: LiveData<TouchStatus>
        get() = _groupTouch


    private val _viewDispatch = MutableLiveData<TouchStatus>()
    val viewDispatch: LiveData<TouchStatus>
        get() = _viewDispatch

    private val _viewTouch = MutableLiveData<TouchStatus>()
    val viewTouch: LiveData<TouchStatus>
        get() = _viewTouch

    init {
        _activityDispatch.value = TouchStatus.OnlySuper
        _activityTouch.value = TouchStatus.OnlySuper
        _groupDispatch.value = TouchStatus.OnlySuper
        _groupIntercept.value = TouchStatus.OnlySuper
        _groupTouch.value = TouchStatus.OnlySuper
        _viewDispatch.value = TouchStatus.OnlySuper
        _viewTouch.value = TouchStatus.OnlySuper
    }


    fun setCurrentType(v: View, data: TouchPickerData) {
        when (v.id) {
            R.id.activityDispatch -> _activityDispatch.value = data.type
            R.id.activityTouch -> _activityTouch.value = data.type
            R.id.viewGroupDispatch -> _groupDispatch.value = data.type
            R.id.viewGroupTouch -> _groupTouch.value = data.type
            R.id.viewGroupInterceptTouch -> _groupIntercept.value = data.type
            R.id.viewDispatch -> _viewDispatch.value = data.type
            R.id.viewTouch -> _viewTouch.value = data.type
        }
    }
}