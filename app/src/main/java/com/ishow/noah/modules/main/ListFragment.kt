package com.ishow.noah.modules.main

import android.os.Bundle
import android.view.View
import com.ishow.common.adapter.BindAdapter
import com.ishow.noah.BR
import com.ishow.noah.R
import com.ishow.noah.databinding.FSampleListBinding
import com.ishow.noah.enties.Sample
import com.ishow.noah.manager.SampleManager
import com.ishow.noah.modules.base.mvvm.view.AppBindFragment
import com.ishow.noah.modules.base.mvvm.viewmodel.AppBaseViewModel
import kotlinx.android.synthetic.main.f_sample_list.*

/**
 * Created by yuhaiyang on 2019-08-20.
 *
 */

class ListFragment : AppBindFragment<FSampleListBinding, AppBaseViewModel>() {


    override fun getLayout(): Int = R.layout.f_sample_list


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BindAdapter<Sample>(view.context)
        adapter.setOnItemClickListener { gotoDetail(adapter.getItem(it)) }
        adapter.addLayout(BR.item, R.layout.item_sample_main)
        adapter.data = SampleManager.samples
        list.adapter = adapter
    }

    private fun gotoDetail(entry: Sample) {
        (activity as MainActivity).showDetail(entry)
    }

    companion object {
        fun newInstance(): ListFragment {
            val args = Bundle()
            val fragment = ListFragment()
            fragment.arguments = args
            return fragment
        }
    }

}