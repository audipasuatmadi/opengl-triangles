package com.example.latihangrafkom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends Activity {
    private static String selectedColor;

    private GLSurfaceView glView;
    private MaterialButton redButton;
    private MaterialButton greenButton;
    private MaterialButton blueButton;

    private void showTriangle(String color) {
        setSelectedColor(color);
        setContentView(glView);
    }

    public static String getSelectedColor() {
        return selectedColor;
    }

    public static void setSelectedColor(String selectedColor) {
        MainActivity.selectedColor = selectedColor;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.redButton = findViewById(R.id.button_red);
        this.blueButton = findViewById(R.id.button_blue);
        this.greenButton = findViewById(R.id.button_green);
        this.glView = new MyGLSurfaceView(this);

        redButton.setOnClickListener(view -> showTriangle("RED"));
        greenButton.setOnClickListener(view -> showTriangle("GREEN"));
        blueButton.setOnClickListener(view -> showTriangle("BLUE"));

    }
}

class MyGLSurfaceView extends GLSurfaceView {
    private final MyRenderer renderer;

    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        renderer = new MyRenderer();
        setRenderer(renderer);
    }
}