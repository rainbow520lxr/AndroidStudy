package com.example.simplealbum;

import android.opengl.GLUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class GalleryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ImageView iv;  //图像
    private Gallery gy;   //缩略图
    private int[] imgs = {R.drawable.test1, R.drawable.test2, R.drawable.test3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        //初始化组件
        iv = findViewById(R.id.iv);
        gy = findViewById(R.id.gy);
        iv.setImageResource(imgs[0]);
        Log.v("sucesss", "1");
        initGallery();
    }

    public void initGallery(){
        //边距转换
        int dip_pad = Utils.dip2px(20);
        Log.v("sucesss", "2");
        //获取gallery
        gy = findViewById(R.id.gy);
        //设置内边距
        gy.setPadding(0, dip_pad, 0, dip_pad);
        //设置各项之间的间距
        gy.setSpacing(dip_pad);
        //设置画廊视图选中的透明度
        Log.v("sucesss", "3");
        gy.setUnselectedAlpha(0.5f);
        //给画廊设置适配器
        Log.v("sucesss", "4");
        gy.setAdapter(new GalleryAdapter(this, imgs));
        //设置点击
        Log.v("sucesss", "5");
        gy.setOnItemClickListener(this);





    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        iv.setImageResource(imgs[position]);
    }
}
