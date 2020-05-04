package com.example.memo;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = getTabHost();
        TabHost.TabSpec spec;
        Intent intent = new Intent().setClass(this, ShowMyData.class);
        spec = host.newTabSpec("show").setIndicator("show memo").setContent(intent);
        host.addTab(spec);

        intent = new Intent().setClass(this, WriteMemoActivity.class);
        spec = host.newTabSpec("show").setIndicator("write memo").setContent(intent);
        host.addTab(spec);

        host.setCurrentTab(0);
    }
}
