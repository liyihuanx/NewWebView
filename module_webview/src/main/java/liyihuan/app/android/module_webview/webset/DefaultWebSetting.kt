package liyihuan.app.android.module_webview.webset

import android.content.Context
import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebView

/**
 * @ClassName: WebDefaultSetting
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/7/12 23:00
 */
object DefaultWebSetting {

    lateinit var mWebSettings: WebSettings


    fun getSetting(webView: WebView) {
        val appCacheDir =
            webView.context.getDir("cache", Context.MODE_PRIVATE).path

        mWebSettings = webView.settings
        mWebSettings.apply {
            // 设置WebView是否允许执行JavaScript脚本，默认false，不允许。
            javaScriptEnabled = true
            // 是否支持使用屏幕上的缩放控件和手势进行缩放
            setSupportZoom(true)
            // 设置setBuiltInZoomControls(boolean)可以使用特殊的缩放机制
            builtInZoomControls = false
            // 设置缓存模式
            cacheMode = WebSettings.LOAD_DEFAULT
            // 设置页面文本的尺寸,百分比，默认NORMAL
            textZoom = 100
            // 数据库存储API是否可用
            databaseEnabled = true
            // 应用缓存API是否可用,结合setAppCachePath(String)使用
            setAppCacheEnabled(true)
            // 缓存路径
            databasePath = appCacheDir
            setAppCachePath(appCacheDir)
            // 设置应用缓存内容的最大值
            setAppCacheMaxSize(1024 * 1024 * 80.toLong())
            // WebView是否下载图片资源，默认为true
            loadsImagesAutomatically = true
            // 设置WebView是否支持多窗口
            setSupportMultipleWindows(false)
            //是否阻塞加载网络图片  协议http or https
            blockNetworkImage = false
            //允许加载本地文件html  file协议
            allowFileAccess = true
            // 是否明文存储
            savePassword = false
            saveFormData = false
            // 是否允许WebView度超出以概览的方式载入页面
            loadWithOverviewMode = true
            useWideViewPort = true
            //
            domStorageEnabled = true
            setNeedInitialFocus(true)
            //设置编码格式
            defaultTextEncodingName = "utf-8"

            defaultFontSize = 16
            //设置 WebView 支持的最小字体大小，默认为 8
            minimumFontSize = 10
            // 定位是否可用
            setGeolocationEnabled(true)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                //通过 file url 加载的 Javascript 读取其他的本地文件 .建议关闭
                mWebSettings.allowFileAccessFromFileURLs = false
                //允许通过 file url 加载的 Javascript 可以访问其他的源，包括其他的文件和 http，https 等其他的源
                mWebSettings.allowUniversalAccessFromFileURLs = false
            }
            // 让JavaScript自动打开窗口
            javaScriptCanOpenWindowsAutomatically = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                mWebSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
            } else {
                mWebSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            }
        }

    }


}