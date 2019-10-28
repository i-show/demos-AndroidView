package com.ishow.noah.modules.touch

import android.content.Context
import com.ishow.common.entries.utils.IUnitPicker

/**
 * Created by yuhaiyang on 2019-10-25.
 *
 */
enum class TouchStatus(val des: String) {
    OnlySuper("OnlySuper"),
    RunSuperTrue("RunSuperTrue"),
    RunSuperFalse("RunSuperFalse"),
    NoSuperTrue("NoSuperTrue"),
    NoSuperFalse("NoSuperFalse"),
}

class TouchPickerData(val type: TouchStatus) : IUnitPicker {
    override fun getTitle(context: Context): String = type.des
}

