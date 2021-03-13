package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button4;
    private Button button5;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav);
        button1 = findViewById(R.id.main_button1);
        button2 = findViewById(R.id.main_button2);
        button4 = findViewById(R.id.main_button4);
        button5 = findViewById(R.id.main_button5);
        progressBar = findViewById(R.id.progress_bar);
        toolbar = findViewById(R.id.mainToolbar);
        button4.setVisibility(View.GONE);
        toolbar.inflateMenu(R.menu.menumain);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.sitting:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more:
                        Toast.makeText(MainActivity.this, "正在跳转...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://pic.sogou.com/pics?query=%E5%A4%A9%E7%BA%BF%E5%AE%9D%E5%AE%9D%E5%A4%B4%E5%83%8F&w=05009900"));
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        swipeRefreshLayout = findViewById(R.id.main_sw);
        swipeRefreshLayout.setColorSchemeResources(R.color.red, R.color.green, R.color.purple_500);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "正在刷新", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                        button4.setVisibility(View.VISIBLE);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LaLaFragment.class);
                startActivity(intent);
            }
        });

        progressBar.setVisibility(View.GONE);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                Demo d1 = new Demo();
                d1.start();
            }
        });
    }

    class Demo extends Thread {
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(MainActivity.this, PuctureTele.class);
            startActivity(intent);
        }
    }


    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menumain, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.right:
//                Toast.makeText(this,"哈哈",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.left:
//                Toast.makeText(this,"嘿嘿",Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return true;
//    }
}