// IWebviewProcessToMainProcessInterface.aidl
package liyihuan.app.android.module_webview;

// Declare any non-default types here with import statements
import liyihuan.app.android.module_webview.ICallbackFromMainprocessToWebViewProcessInterface;

interface IWebviewProcessToMainProcessInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void handleWebCommand(String commandName, String jsonParams, in ICallbackFromMainprocessToWebViewProcessInterface callback);
}
