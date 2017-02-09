package com.example.tom.testmaterial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static com.example.tom.testmaterial.R.layout.activity_test;

public class TestActivity extends AppCompatActivity {
    //先在外層宣告 否則每次按鈕都變成30
    int size=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用來設定Activity本身的畫面配置資源,使用了res/layout/activity_test.xml
        setContentView(activity_test);
        //啟用Toolbar
        /*
        第一行用findViewId來取得畫面配置元件
        因為findViewById的回傳為android.view.View類別因此須轉型而得到Toolbar-----(Toolbar)
        最後呼叫setSupportActionBar指定本類別上方橫向長條元件
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //執行Snackbar的方法
                Snackbar.make(view, "想要顯示的字串", Snackbar.LENGTH_LONG)
                        .setAction("變大", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                TextView txv = (TextView)findViewById(R.id.txv);
                                txv.setTextSize(++ size);
                            }
                        }).show();
            }
        });
    }

}
