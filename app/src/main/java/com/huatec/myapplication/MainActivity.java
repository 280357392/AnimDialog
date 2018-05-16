package com.huatec.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_determine;
    private Button btn_cancel;
    private AlertDialog dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 单击手机返回按钮，启动对话框
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断如果单击了返回按钮
        if (keyCode == KeyEvent.KEYCODE_BACK){
            //创建对话框实例
            dlg = new AlertDialog.Builder(this).create();
            dlg.show();//显示对话框
            Window window = dlg.getWindow();//对话框窗口
            window.setGravity(Gravity.CENTER);//设置对话框显示在屏幕中间
            window.setWindowAnimations(R.style.dialog_style);//添加动画
            window.setContentView(R.layout.dialog_layout);//设置对话框的布局文件
            //获取对话框确定和取消按钮
            btn_determine = window.findViewById(R.id.btn_determine);
            btn_cancel = window.findViewById(R.id.btn_cancel);
            initEvent();//初始化事件
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initEvent() {
        //确定
        btn_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();//关闭对话框
                finish();//退出当前界面
            }
        });

        //取消
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();//关闭对话框
            }
        });
    }
}
