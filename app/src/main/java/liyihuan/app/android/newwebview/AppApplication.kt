package liyihuan.app.android.newwebview

import com.alibaba.android.arouter.launcher.ARouter
import liyihuan.app.android.module_base.BaseApplication

/**
 * @ClassName: AppApplication
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/11/9 22:14
 */
class AppApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}