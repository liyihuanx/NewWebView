package liyihuan.app.android.newwebview

import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.google.auto.service.AutoService
import liyihuan.app.android.module_base.RouterPath
import liyihuan.app.android.module_webview.ICallbackFromMainprocessToWebViewProcessInterface
import liyihuan.app.android.module_webview.command.Command

/**
 * @author created by liyihuanx
 * @date 2021/11/10
 * @description: 类的描述
 */
@AutoService(Command::class)
class CommandOpenActivity : Command {
    override fun name(): String {
        return "openActivity"
    }

    override fun execute(
        parameters: Map<*, *>?,
        callback: ICallbackFromMainprocessToWebViewProcessInterface?
    ) {
        // 这里拿到的是SecondActivity
        val path = when(parameters?.get("message")?.toString()){
            "SecondActivity" ->{
                RouterPath.Main.SecondActivity
            }
            else -> {
                ""
            }
        }
        ARouter.getInstance().build(path)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .navigation()
    }
}