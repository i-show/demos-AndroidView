package com.ishow.noah.enties


/**
 * Created by yuhaiyang on 2017/10/12.
 * Sample info
 */

class Sample(var name: String, var action: Class<*>) {

    companion object {
        @JvmStatic
        fun instance(name: String, action: Class<*>): Sample {
            return Sample(name, action)
        }
    }
}
