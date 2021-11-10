package liyihuan.app.android.module_base

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @ClassName: BaseApplication
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/11/9 22:13
 */
open class BaseApplication : Application(), ViewModelStoreOwner  {
    private val appViewModelStore :ViewModelStore by lazy{
        ViewModelStore()
    }

    override fun getViewModelStore(): ViewModelStore {
        return appViewModelStore
    }


}