package liyihuan.app.android.module_webview.mainprocess

import com.google.gson.Gson
import liyihuan.app.android.module_webview.ICallbackFromMainprocessToWebViewProcessInterface
import liyihuan.app.android.module_webview.IWebviewProcessToMainProcessInterface
import liyihuan.app.android.module_webview.command.Command
import java.util.*

/**
 * @author created by liyihuanx
 * @date 2021/11/10
 * @description: 类的描述
 */
class MainCommandsManager private constructor() : IWebviewProcessToMainProcessInterface.Stub() {
    private val mCommands: HashMap<String, Command> = HashMap<String, Command>()

    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            MainCommandsManager()
        }
    }


    init {
        // 收集使用了注解的类
        val serviceLoader = ServiceLoader.load(Command::class.java)
        for (command in serviceLoader) {
            if (!mCommands.containsKey(command.name())) {
                mCommands[command.name()] = command
            }
        }
    }


    override fun handleWebCommand(
        commandName: String,
        jsonParams: String?,
        callback: ICallbackFromMainprocessToWebViewProcessInterface?
    ) {
        executeCommand(
            commandName, Gson().fromJson<Map<*, *>>(
                jsonParams,
                MutableMap::class.java
            ), callback
        )
    }


    private fun executeCommand(
        commandName: String,
        params: Map<*, *>?,
        callback: ICallbackFromMainprocessToWebViewProcessInterface? = null
    ) {
        mCommands[commandName]?.execute(params, callback)
    }

}