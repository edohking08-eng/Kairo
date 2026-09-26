package com.king.kairo;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class KairoAccessibilityService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // v0.1 only observes the active interface.
        // We will add safe, user-triggered actions in later versions.
    }

    @Override
    public void onInterrupt() {
    }
}
