package com.bumbumapps.fifteenpuzzlepro;

import android.app.Application;

/** Applies system-bar insets to every activity (edge-to-edge is enforced when targeting API 35+). */
public class PuzzleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new EdgeToEdgeCallbacks());
    }
}
