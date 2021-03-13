package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String json = "{\"name\":\"小   波\",\"content\":\"小波（红色）是最可爱最矮的天线宝宝。她喜欢跳上跳下来表达自己快乐、热情及惊喜的心情。最常讲的字就是 再来，再来 。她常骑着滑板车在山坡上飞驰，还有盯着屋子中央那颗柱上的按钮和遥控器。小波喜欢的歌是“斐点、斐点、斐点”，是广东话“快点、快点、快点”或“慢点、慢点、慢点”的意思。\"}";
        Gson gson = new Gson();
        GsonFormatTele gsonFormatTele = gson.fromJson(json, GsonFormatTele.class);

        setContentView(R.layout.activity_scrolling);
        TextView textView = findViewById(R.id.scr_tv);
        textView.setText(gsonFormatTele.getContent());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(gsonFormatTele.getName());

        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}