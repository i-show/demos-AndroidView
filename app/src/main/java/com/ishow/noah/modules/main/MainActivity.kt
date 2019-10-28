package com.ishow.noah.modules.main

import android.os.Bundle
import com.ishow.common.extensions.open
import com.ishow.common.extensions.showFragment
import com.ishow.noah.R
import com.ishow.noah.databinding.AMainBinding
import com.ishow.noah.enties.Sample
import com.ishow.noah.modules.base.mvvm.view.AppBindActivity

/**
 * Created by yuhaiyang on 2019-10-25.
 */
class MainActivity : AppBindActivity<AMainBinding, MainViewModel>() {

    private val listFragment = ListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindContentView(R.layout.a_main)
    }

    override fun initViewModel(vm: MainViewModel) {
        super.initViewModel(vm)
        showFragment(listFragment)
    }

    fun showDetail(sample: Sample) {
        open(sample.action)
    }
}