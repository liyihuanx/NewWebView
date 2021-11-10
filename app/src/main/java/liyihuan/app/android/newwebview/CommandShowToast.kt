package liyihuan.app.android.newwebview

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.auto.service.AutoService
import liyihuan.app.android.module_base.AppContext.get
import liyihuan.app.android.module_webview.ICallbackFromMainprocessToWebViewProcessInterface
import liyihuan.app.android.module_webview.command.Command

@AutoService(Command::class)
class CommandShowToast : Command {
    override fun name(): String {
        return "showToast"
    }

    override fun execute(
        parameters: Map<*, *>?,
        callback: ICallbackFromMainprocessToWebViewProcessInterface?
    ) {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            Toast.makeText(get(), parameters?.get("message")?.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}