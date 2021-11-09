var myjs = {};
myjs.os = {};
myjs.os.isIOS = /iOS|iPhone|iPad|iPod/i.test(navigator.userAgent);
myjs.os.isAndroid = !myjs.os.isIOS;
myjs.callbacks = {}

myjs.callback = function (callbackname, response) {
   var callbackobject = myjs.callbacks[callbackname];
   console.log("xxxx"+callbackname);
   if (callbackobject !== undefined){
       if(callbackobject.callback != undefined){
          console.log("xxxxxx"+response);
            var ret = callbackobject.callback(response);
           if(ret === false){
               return
           }
           delete myjs.callbacks[callbackname];
       }
   }
}

myjs.takeNativeAction = function(commandname, parameters){
    console.log("myjs takenativeaction")
    var request = {};
    request.name = commandname;
    request.param = parameters;
    if(window.myjs.os.isAndroid){
        console.log("android take native action" + JSON.stringify(request));
        window.mywebview.takeNativeAction(JSON.stringify(request));
    } else {
        window.webkit.messageHandlers.mywebview.postMessage(JSON.stringify(request))
    }
}

myjs.takeNativeActionWithCallback = function(commandname, parameters, callback) {
    var callbackname = "nativetojs_callback_" +  (new Date()).getTime() + "_" + Math.floor(Math.random() * 10000);
    myjs.callbacks[callbackname] = {callback:callback};

    var request = {};
    request.name = commandname;
    request.param = parameters;
    request.param.callbackname = callbackname;
    if(window.myjs.os.isAndroid){
        window.mywebview.takeNativeAction(JSON.stringify(request));
    } else {
        window.webkit.messageHandlers.mywebview.postMessage(JSON.stringify(request))
    }
}

window.myjs = myjs;
