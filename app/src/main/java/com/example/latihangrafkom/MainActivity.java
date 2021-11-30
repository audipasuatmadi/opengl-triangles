package com.example.latihangrafkom;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    static float rValue,gValue,bValue,aValue,top,left,right;
    static EditText rInput,gInput,bInput,aInput,InputA,InputB,InputC;
    Button draw;
    private GLSurfaceView glView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        glView = new MyGLSurfaceView(this);
        setContentView(R.layout.activity_main);
        rInput = (EditText) findViewById(R.id.rInput);
        gInput = (EditText) findViewById(R.id.gInput);
        bInput = (EditText) findViewById(R.id.bInput);
        aInput = (EditText) findViewById(R.id.aInput);
        InputA = (EditText) findViewById(R.id.InputA);
        InputB = (EditText) findViewById(R.id.InputB);
        InputC = (EditText) findViewById(R.id.InputC);
        draw = (Button)  findViewById(R.id.btn_submit);
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(rInput.getText().toString())) {
                    isEmptyFields = true;
                    rInput.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(gInput.getText().toString())) {
                    isEmptyFields = true;
                    gInput.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(bInput.getText().toString())) {
                    isEmptyFields = true;
                    bInput.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(aInput.getText().toString())) {
                    isEmptyFields = true;
                    aInput.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(InputA.getText().toString())) {
                    isEmptyFields = true;
                    InputA.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(InputB.getText().toString())) {
                    isEmptyFields = true;
                    InputB.setError("Field ini tidak boleh kosong");
                }
                if (TextUtils.isEmpty(InputC.getText().toString())) {
                    isEmptyFields = true;
                    InputC.setError("Field ini tidak boleh kosong");
                }
                if (!isEmptyFields) {
                    top = Float.valueOf(InputA.getText().toString());
                    left = -Float.valueOf(InputB.getText().toString());
                    right = Float.valueOf(InputC.getText().toString());

                    rValue = Float.valueOf(rInput.getText().toString());
                    gValue = Float.valueOf(gInput.getText().toString());
                    bValue = Float.valueOf(bInput.getText().toString());
                    aValue = Float.valueOf(aInput.getText().toString());
                    setContentView(glView);
                }



            }
        });
    }
    public static float getR(){
        return rValue;
    }
    public static float getG(){
        return gValue;
    }
    public static float getB(){
        return bValue;
    }
    public static float getA(){
        return aValue;
    }
    public static float getTop(){
        return top;
    }
    public static float getLeft(){
        return left;
    }
    public static float getRight(){
        return right;
    }
}
class MyGLSurfaceView extends GLSurfaceView{
    private final MyRenderer renderer;
    public MyGLSurfaceView(Context context){
        super(context);
        setEGLContextClientVersion(2);
        renderer = new MyRenderer();
        setRenderer(renderer);
    }
}