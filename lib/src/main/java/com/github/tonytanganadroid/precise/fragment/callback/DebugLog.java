package com.github.tonytanganadroid.precise.fragment.callback;

import android.util.Log;

class DebugLog {

    private static final boolean enable_log = false;

    static void d(String tag, String message) {
        if (enable_log) {
            Log.d(tag, message);
        }
    }
}
