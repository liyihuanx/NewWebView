package liyihuan.app.android.module_webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_web.*
import liyihuan.app.android.module_webview.callback.WebViewCallBack
import liyihuan.app.android.module_webview.webview.BaseWebView

/**
 * @ClassName: WebFragment
 * @Description: java类作用描述
 * @Author: liyihuan
 * @Date: 2021/11/9 23:07
 */
class WebFragment : Fragment(), WebViewCallBack {

    private lateinit var rootview: View
    private lateinit var webUrl: String
    private lateinit var baseWebView: BaseWebView

    companion object {
        fun newInstance(url: String): WebFragment {
            val bundle = Bundle()
            bundle.putString(WebConstants.URL, url)
            val fragment = WebFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview = inflater.inflate(R.layout.fragment_web, container, false)
        baseWebView = rootview.findViewById(R.id.baseWebView)
        return rootview
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO 这里不行
//        baseWebView.initWebClient(this)
        arguments?.let {
            webUrl = it.getString(WebConstants.URL).toString()
//            baseWebView.loadUrl(webUrl)
        }
    }

    override fun pageStarted(url: String?) {

    }

    override fun pageFinished(url: String?) {

    }

    override fun pageError() {

    }

    override fun updateTitle(title: String?) {
    }

    override fun overrideUrlLoading(view: WebView?, url: WebResourceRequest?): Boolean {
        return false
    }
}