package liyihuan.app.android.module_webview.webview

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import liyihuan.app.android.module_webview.callback.WebViewCallBack
import liyihuan.app.android.module_webview.webset.DefaultWebChromeClient
import liyihuan.app.android.module_webview.webset.DefaultWebSetting
import liyihuan.app.android.module_webview.webset.DefaultWebViewClient

/**
 * @ClassName: BaseWebView
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/7/15 22:09
 */
class BaseWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {


    init {
        DefaultWebSetting.getSetting(this)
        addJavascriptInterface(this, "webview")

    }

    fun initWebClient(webViewCallBack: WebViewCallBack){
        webViewClient = DefaultWebViewClient(webViewCallBack)
        webChromeClient = DefaultWebChromeClient(webViewCallBack)
    }

    @JavascriptInterface
    fun takeNativeAction(jsParam: String?) {

    }
}