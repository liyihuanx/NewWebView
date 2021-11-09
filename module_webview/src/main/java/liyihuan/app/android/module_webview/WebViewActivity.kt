package liyihuan.app.android.module_webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import liyihuan.app.android.module_common.RouterPath

/**
 * @ClassName: WebViewActivity
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/11/9 21:57
 */
@Route(path = RouterPath.WebView.WebViewActivity)
class WebViewActivity : AppCompatActivity() {

    //    @Autowired(required = true)
//    @JvmField
    var webUrl: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

//        ARouter.getInstance().inject(this)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        val fragment: Fragment = WebFragment.newInstance(webUrl)
        transaction.add(R.id.flContent, fragment, "WebFragment").show(fragment)
            .commitAllowingStateLoss()

    }
}