package com.qinlei.customdialog.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.qinlei.customdialog.R;

/**
 * Created by ql on 2017/4/1.
 */

public class CustomDialog extends AlertDialog {
    public CustomDialog(@NonNull Context context) {
        this(context, R.style.CustomDialog); //设置Style
    }

    protected CustomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(final Context context) {
//        setCancelable(true);//是否可以取消 (也可以在调用处设置)
//        setCanceledOnTouchOutside(false);//是否点击外部消失
        setContentView(R.layout.custom_dialog);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window dialog_window = this.getWindow();
        dialog_window.setGravity(Gravity.CENTER);//设置显示的位置
        dialog_window.setAttributes(params);//设置显示的大小
    }
}
