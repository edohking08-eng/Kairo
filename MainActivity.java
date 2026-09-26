package com.king.kairo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int gold = Color.rgb(216,179,90);

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(36, 60, 36, 36);
        root.setBackgroundColor(Color.rgb(8,9,12));

        TextView title = new TextView(this);
        title.setText("KAIRO");
        title.setTextColor(gold);
        title.setTextSize(38);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, 1);

        TextView subtitle = new TextView(this);
        subtitle.setText("YOUR PERSONAL INTELLIGENCE");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(12);
        subtitle.setGravity(Gravity.CENTER);

        TextView status = new TextView(this);
        status.setText("\nKAIRO v0.1\nCore online\nAccessibility: not enabled yet");
        status.setTextColor(Color.WHITE);
        status.setTextSize(16);
        status.setGravity(Gravity.CENTER);
        status.setPadding(0, 35, 0, 35);

        Button accessibility = new Button(this);
        accessibility.setText("OPEN KAIRO ACCESSIBILITY");
        accessibility.setTextColor(Color.BLACK);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(gold);
        bg.setCornerRadius(28);
        accessibility.setBackground(bg);
        accessibility.setOnClickListener(v -> {
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        });

        Button mic = new Button(this);
        mic.setText("ALLOW MICROPHONE");
        mic.setOnClickListener(v -> {
            if (android.os.Build.VERSION.SDK_INT >= 23 &&
                checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 10);
            }
        });

        root.addView(title, new LinearLayout.LayoutParams(-1, -2));
        root.addView(subtitle, new LinearLayout.LayoutParams(-1, -2));
        root.addView(status, new LinearLayout.LayoutParams(-1, -2));
        root.addView(accessibility, new LinearLayout.LayoutParams(-1, 60));
        root.addView(mic, new LinearLayout.LayoutParams(-1, 60));

        setContentView(root);
    }
}
