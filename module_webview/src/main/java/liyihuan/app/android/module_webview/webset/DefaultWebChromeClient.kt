package liyihuan.app.android.module_webview.webset

import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import liyihuan.app.android.module_webview.callback.WebViewCallBack

/**
 * @ClassName: DefaultWebChromeClient
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/7/12 23:36
 */
class DefaultWebChromeClient(private val webViewCallBack: WebViewCallBack) : WebChromeClient() {


    override fun onReceivedTitle(view: WebView, title: String?) {
        webViewCallBack.updateTitle(title)
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)

    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        Log.d("QWER", "onConsoleMessage: ${consoleMessage?.message()}")
        return super.onConsoleMessage(consoleMessage)
    }


    override fun onJsAlert(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsAlert(view, url, message, result)
    }
}