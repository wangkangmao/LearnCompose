package tv.yunxi.learncompose

import android.app.Application
import android.content.Context

/**
 * @author: created by wangkm
 * @time: 2022/05/03 22:00
 * @desc：
 * @email: 1240413544@qq.com
 */

class App : Application(){

    init {
        instance = requireNotNull(this)
    }

    companion object {
        private lateinit var instance: App

        fun applicationContext(): Context {
            return instance
        }
    }
}