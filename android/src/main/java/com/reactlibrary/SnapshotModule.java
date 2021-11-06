// SnapshotModule.java

package com.reactlibrary;

import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class SnapshotModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public SnapshotModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Snapshot";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    /**
     *  enable Screen capture
     *  use demo
     *  import Snapshot  from 'react-native-snapshot'
     *  Snapshot.enableSnapshot((status)=>{})
     * @param callback
     */
    @ReactMethod
    public void enableSnapshot(final Callback callback) {

        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getCurrentActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
                callback.invoke(true);
            }
        });
    }

    /**
     * disable Screen capture
     * @param callback
     */
    @ReactMethod
    public void disableSnapshot(final Callback callback) {
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getCurrentActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
                callback.invoke(true);
            }
        });
    }
}
