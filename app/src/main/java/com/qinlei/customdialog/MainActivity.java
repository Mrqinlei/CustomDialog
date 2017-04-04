package com.qinlei.customdialog;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qinlei.customdialog.adapter.MyListAdapter;
import com.qinlei.customdialog.dialog.CustomDialog;
import com.qinlei.customdialog.model.MyListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 android.support.v7.app.AlertDialog 包中的兼容 5.0 以下版本
 * 参考 http://www.jianshu.com/p/6caffdbcd5db
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 普通,不可取消
     *
     * @param view
     */
    public void normalDialog1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialogButton);
        builder.setCancelable(false);//设置不能取消,需要点击按钮
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setTitle("Material Design Dialog");//设置标题
        builder.setMessage("这是 Material Design Dialog");//设置内容
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("中性", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "中性", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * 自定义 Title 布局
     * 列表选项
     *
     * @param view
     */
    public void normalDialog3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view3 = View.inflate(this, R.layout.custom_title, null);
        ((TextView) view3.findViewById(R.id.title)).setText("CustomTitle");
        builder.setCustomTitle(view3);
        builder.setItems(new String[]{"Item1", "Item2", "Item3"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "which " + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * 多选列表选项
     *
     * @param view
     */
    public void normalDialog2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Design Dialog");
//        builder.setMessage("这是 Material Design Dialog"); 不能设置会使得 setMultiChoiceItems 失效,下面的也一样
        builder.setMultiChoiceItems(
                new String[]{"233333", "hahahaha", "lalalala"},//内容定义
                new boolean[]{true, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(MainActivity.this, "which " + which + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("中性", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "中性", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * 单选列表
     *
     * @param view
     */
    public void normalDialog4(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Design Dialog");
        builder.setSingleChoiceItems(
                new String[]{"233333", "hahahaha", "lalalala"},//内容定义
                0, //-1,代表默认不选择
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "which" + which, Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("中性", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "中性", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * 自定义 content 布局
     *
     * @param view
     */
    public void normalDialog5(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Design Dialog");

        View view1 = View.inflate(this, R.layout.normal_dialog, null);
        final EditText editText = (EditText) view1.findViewById(R.id.normal_dialog_edittext);

        builder.setView(view1);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定" + editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("中性", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "中性", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }


    /**
     * 列表选项,列表布局可自定义
     *
     * @param view
     */
    public void normalDialog8(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Design Dialog");

        final List<MyListBean> lists = new ArrayList<>();
        lists.add(new MyListBean("23232", "232323232323232"));
        lists.add(new MyListBean("hahah", "hahahahhahhahah"));
        lists.add(new MyListBean("lalal", "lalalalallalala"));

        builder.setAdapter(new MyListAdapter(MainActivity.this, lists), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, lists.get(which).title, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * loading dialog
     *
     * @param view
     */
    public void normalDialog6(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this, R.style.CustomDialog);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//默认
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
    }

    /**
     * 进度条 dialog
     *
     * @param view
     */
    public void normalDialog7(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("软件更新");
        progressDialog.setMessage("新版本来了,快来下载吧!");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setMax(100);

        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(2000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressDialog.setProgress((Integer) animation.getAnimatedValue());
            }
        });

        progressDialog.show();
    }

    public void customDialog(View view) {
        //textview 需要指定颜色
        new CustomDialog(this).show();
    }
}
