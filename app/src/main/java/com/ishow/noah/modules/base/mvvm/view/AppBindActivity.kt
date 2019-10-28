package com.ishow.noah.modules.base.mvvm.view

import androidx.databinding.ViewDataBinding
import com.ishow.common.app.mvvm.view.BindActivity
import com.ishow.common.widget.watermark.WaterMarkView
import com.ishow.noah.AppApplication
import com.ishow.noah.modules.base.mvvm.viewmodel.AppBaseViewModel


/**
 * Created by yuhaiyang on 2018/8/8.
 * App层面的BaseActivity
 */
abstract class AppBindActivity<T : ViewDataBinding, VM : AppBaseViewModel> : BindActivity<T, VM>() {

    /**
     * 获取应用的Application
     */
    @Suppress("unused")
    protected val appApplication: AppApplication
        get() = application as AppApplication


    override fun initViews() {
        super.initViews()
        WaterMarkView.attachToActivity(this)
    }
}
