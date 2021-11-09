package liyihuan.app.android.newwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*
import liyihuan.app.android.module_common.RouterPath

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWebView.setOnClickListener {
            ARouter.getInstance()
                .build(RouterPath.WebView.WebViewActivity)
                .navigation()
        }

    }
}