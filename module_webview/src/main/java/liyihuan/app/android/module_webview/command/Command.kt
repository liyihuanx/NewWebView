package liyihuan.app.android.module_webview.command

import liyihuan.app.android.module_webview.ICallbackFromMainprocessToWebViewProcessInterface

/**
 * @author created by liyihuanx
 * @date 2021/11/10
 * @description: 类的描述
 */
interface Command {
    fun name(): String
    fun execute(
        parameters: Map<*, *>?,
        callback: ICallbackFromMainprocessToWebViewProcessInterface? = null
    )
}