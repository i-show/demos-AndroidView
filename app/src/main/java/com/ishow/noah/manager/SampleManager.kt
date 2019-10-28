package com.ishow.noah.manager

import com.ishow.noah.enties.Sample
import com.ishow.noah.modules.touch.ViewTouchActivity

import java.util.ArrayList

/**
 * Created by yuhaiyang on 2017/10/12.
 * 管理器
 */

object SampleManager {


    val samples: MutableList<Sample>
        get() {
            val list = ArrayList<Sample>()
            list.add(Sample.instance("ViewTouch", ViewTouchActivity::class.java))
            return list
        }
}
