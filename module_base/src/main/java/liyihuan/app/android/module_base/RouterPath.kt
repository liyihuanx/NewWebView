package liyihuan.app.android.module_base

/**
 * @ClassName: RouterPath
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/9/14 22:27
 */
class RouterPath {

    object Main {
        private const val groupPath = "/Main/"
        const val MainActivity = groupPath + "MainActivity"
        const val SecondActivity = groupPath + "SecondActivity"
    }

    object WebView {
        private const val groupPath = "/WebView/"
        const val WebViewActivity = groupPath + "WebViewActivity"

    }

}