package com.qdigo.tinkerlearndemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tinkerpatch.sdk.TinkerPatch;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView tv;
    private android.widget.Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn = (Button) findViewById(R.id.btn);
        this.tv = (TextView) findViewById(R.id.tv);
        tv.setText("这新功能");
        initView();
    }

    private void initView() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                        + "/patch_signed_7zip.apk");
                if(file.exists()){
                    Log.w("MainActivity","true");
                }else{
                    Log.w("MainActivity","false");
                }
                /*TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath()
                                + "/patch_signed_7zip.apk");//等下要push到SD卡里面去apk，以达到更新的目的*/
                TinkerPatch.with().fetchPatchUpdate(true);
            }
        });
    }
}
