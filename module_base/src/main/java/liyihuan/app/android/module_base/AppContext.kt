package liyihuan.app.android.module_base

import android.app.Application
import android.content.Context
import java.lang.Exception

/**
 * @ClassName: AppContext
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/8/26 23:50
 */
object AppContext {
    private var application: Application? = null
    fun get(): Application {
        if (application == null) {
            try {
                application = Class.forName("android.app.ActivityThread")
                    .getMethod("currentApplication")
                    .invoke(null) as Application
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        return application!!
    }

    fun getApplicationContext(): Context {
        return get().applicationContext
    }

}