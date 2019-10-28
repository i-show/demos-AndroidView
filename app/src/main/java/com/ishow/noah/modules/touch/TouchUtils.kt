package com.ishow.noah.modules.touch

import android.util.Log
import android.view.MotionEvent
import java.text.FieldPosition

/**
 * Created by yuhaiyang on 2019-10-25.
 *
 */

object TouchUtils {
    private fun actionDes(ev: MotionEvent?): String? {
        if (ev == null) {
            return "ev is null"
        }

        return when (ev.action) {
            MotionEvent.ACTION_DOWN -> "ACTION_DOWN"
            MotionEvent.ACTION_UP -> "ACTION_UP"
            MotionEvent.ACTION_MOVE -> null
            else -> ev.action.toString()
        }
    }


    fun log(_class: String, _method: String, ev: MotionEvent?) {
        val className = formatName(_class, 8, Position.Start)
        val methodName = formatName(_method, 22, Position.End)
        val des = actionDes(ev)
        des?.let {
            Log.i("yhy", "$className  $methodName action = $it")
        }
    }


    private fun formatName(str: String, length: Int, position: Position): String {
        val strLength = str.length

        if (strLength > length) {
            return str
        }
        val count = length - strLength
        return when (position) {
            Position.Start -> genEmptyStr(count) + str
            Position.End -> str + genEmptyStr(count)
        }
    }

    private fun genEmptyStr(count: Int): String {
        val builder = StringBuilder()
        for (i in 0 until count) {
            builder.append(" ")
        }
        return builder.toString()
    }

    private enum class Position {
        Start, End
    }
}