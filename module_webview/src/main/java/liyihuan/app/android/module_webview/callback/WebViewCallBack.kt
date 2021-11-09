package liyihuan.app.android.module_webview.callback

import android.webkit.WebResourceRequest
import android.webkit.WebView

/**
 * @ClassName: WebViewCallBack
 * @Description: 打开WebActivity时的回调
 * @Author: liyihuan
 * @Date: 2021/7/15 22:22
 */
interface WebViewCallBack {

    fun pageStarted(url: String?)

    fun pageFinished(url: String?)

    fun pageError()

    fun updateTitle(title: String?)

    fun overrideUrlLoading(view: WebView?, url: WebResourceRequest?): Boolean
}