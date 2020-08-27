package com.zzq.android_yolo_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button detectImgBtn, detectVideoBtn, detectCapBtn;
    Context mContext = this;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detectImgBtn = findViewById(R.id.detect_img_btn);
        detectVideoBtn = findViewById(R.id.detect_video_btn);
        detectCapBtn = findViewById(R.id.detect_cap_btn);

        detectImgBtn.setOnClickListener(listener);
        detectVideoBtn.setOnClickListener(listener);
        detectCapBtn.setOnClickListener(listener);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.detect_img_btn:
                    startActivity(new Intent(mContext, ImageDetectActivity.class));
                    break;
                case R.id.detect_video_btn:
                    startActivity(new Intent(mContext, CameraActivity.class));
                    break;
                case R.id.detect_cap_btn:
                    startActivity(new Intent(mContext, CameraActivity.class));
                    break;
                default:
                    break;
            }
        }
    };

}
