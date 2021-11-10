package liyihuan.app.android.module_webview.mainprocess

import android.app.Service
import android.content.Intent
import android.os.IBinder
import liyihuan.app.android.module_webview.ICallbackFromMainprocessToWebViewProcessInterface
import liyihuan.app.android.module_webview.command.Command
import java.util.*

/**
 * @author created by liyihuanx
 * @date 2021/11/10
 * @description: 类的描述
 */
class MainCommandService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return MainCommandsManager.instance
    }
}