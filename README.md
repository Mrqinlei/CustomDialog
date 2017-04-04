
## AlertDialog 使用

这篇文章将介绍一些 AlertDialog 常用的样式，修改按钮字体颜色，添加dialog的显示、消失的动画。最后将向你介绍如何自定义一个 AlertDialog。源码地址 : [https://github.com/Mrqinlei/CustomDialog](https://github.com/Mrqinlei/CustomDialog)
<!-- more -->
## Material Dialog  
本文中使用的 AlertDialog 是 android.support.v7.app 中的它与 android.app 中的不同可以参考这篇文章: [http://www.jianshu.com/p/6caffdbcd5db](http://www.jianshu.com/p/6caffdbcd5db) ,现在介绍它的基本用法.  

### 基本使用   
#### 基本样式  

![](http://i.imgur.com/nC7GWPQ.png)

-	设置图标  
```
		builder.setIcon(R.mipmap.ic_launcher);//设置图标
```
-	设置标题
```
		builder.setTitle("Material Design Dialog");//设置标题 
```
-	设置内容
```
		builder.setMessage("这是 Material Design Dialog");//设置内容  
```
-	设置按钮
	-	确定按钮
```
			builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
	            }
	        });
```
	-	取消按钮
```
			builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
	            }
	        });
```
	-	中立按钮
```
			builder.setNeutralButton("中性", new DialogInterface.OnClickListener() {
	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                Toast.makeText(MainActivity.this, "中性", Toast.LENGTH_SHORT).show();
	            }
	        });
```
	-	显示 dialog
```
			builder.show();
```
#### 修改头布局
![](http://i.imgur.com/6jrovEf.png)  

```
	builder.setCustomTitle(view);
```

#### 列表选项
![](http://i.imgur.com/6jrovEf.png)  

```
	builder.setItems(new String[]{"Item1", "Item2", "Item3"}, new DialogInterface.OnClickListener() {
	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                Toast.makeText(MainActivity.this, "which " + which, Toast.LENGTH_SHORT).show();
	            }
	        });
```

#### 单选列表选项
![](http://i.imgur.com/9kzFhRB.png)  

```
	builder.setSingleChoiceItems(
	                new String[]{"233333", "hahahaha", "lalalala"},//内容定义
	                0, //-1,代表默认不选择
	                new DialogInterface.OnClickListener() {
	                    @Override
	                    public void onClick(DialogInterface dialog, int which) {
	                        Toast.makeText(MainActivity.this, "which" + which, Toast.LENGTH_SHORT).show();
	                    }
	                });
```

#### 列表选项,列表布局可自定义
![](http://i.imgur.com/9bfpGVI.png)  

```
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
```

#### 多选列表选项
![](http://i.imgur.com/b280rhj.png)  

```
builder.setMultiChoiceItems(
                new String[]{"233333", "hahahaha", "lalalala"},//内容定义
                new boolean[]{true, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(MainActivity.this, "which " + which + " " + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });
```

#### 自定义 content 布局
![](http://i.imgur.com/4dlzQ43.png)

```
	View view1 = View.inflate(this, R.layout.normal_dialog, null);
	final EditText editText = (EditText) view1.findViewById(R.id.normal_dialog_edittext);
	builder.setView(view1);
```

#### ProgressDialog 加载中 dialog 
![](http://i.imgur.com/tEy3EKp.png)  

```
        ProgressDialog progressDialog = new ProgressDialog(this, R.style.CustomDialog);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//默认
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
```

new ProgressDialog(this, R.style.CustomDialog); 中的第二个参数 R.style.CustomDialog 可以为 Dialog 设置一些不同的风格: 

```
    <style name="CustomDialog" parent="Theme.AppCompat.Dialog">
        <item name="android:backgroundDimEnabled">true</item><!--true 屏幕变暗-->
        <item name="android:windowBackground">@android:color/transparent</item><!-- 背景透明 -->
    </style>
```

#### 进度条 dialog 
![](http://i.imgur.com/txqWidl.png)  

```
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("软件更新");
        progressDialog.setMessage("新版本来了,快来下载吧!");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setMax(100);
```

通过 setProgress(); 方法设置进度条的进度

### 自定义 dialog (一个带圆角的 dialog)  
![](http://i.imgur.com/KYpCPs8.png)  
#### 布局文件 
设置一个圆角的背景 android:background="@drawable/custom_dialog" 
```
	<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		    android:layout_width="280dp"
		    android:layout_height="200dp"
		    android:background="@drawable/custom_dialog"
		    android:orientation="vertical">
		    <TextView
		        android:layout_width="match_parent"
		        android:layout_height="match_parent"
		        android:gravity="center"
		        android:text="Custom Dialog"
		        android:textColor="@android:color/black"
		        android:textSize="24sp" />
	</LinearLayout>
```

#### 定义一个 Style:  

```
	<!--自定义Dialog-->
    <style name="CustomDialog" parent="Theme.AppCompat.Dialog">
        <item name="android:backgroundDimEnabled">true</item><!--true 屏幕变暗-->
        <item name="android:windowBackground">@android:color/transparent</item><!-- 背景透明 -->
    </style>
```

#### 自定义 Dialog,使用定义的 Style

```
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
```

### 添加动画效果  
![](http://i.imgur.com/wp9JGgy.gif)  

#### 添加动画
-	进入动画  
```
	<?xml version="1.0" encoding="utf-8"?>
	<set xmlns:android="http://schemas.android.com/apk/res/android"
	    android:duration="200">
	    <translate
	        android:fromYDelta="100%"
	        android:toYDelta="0" />
	    <alpha
	        android:fromAlpha="0"
	        android:toAlpha="1" />
	
	</set>
```
-	退出动画
```
	<?xml version="1.0" encoding="utf-8"?>
	<set xmlns:android="http://schemas.android.com/apk/res/android"
	    android:duration="200">
	    <translate
	        android:fromYDelta="0"
	        android:toYDelta="100%" />
	    <alpha
	        android:fromAlpha="1"
	        android:toAlpha="0" />
	</set>
```
#### Style文件设置 
```
    <!--自定义Dialog-->
    <style name="CustomDialog" parent="Theme.AppCompat.Dialog">
        <item name="android:backgroundDimEnabled">true</item><!--true 屏幕变暗-->
        <item name="android:windowBackground">@android:color/transparent</item><!-- 背景透明 -->
        <!-- Dialog进入及退出动画 -->
        <item name="android:windowAnimationStyle">@style/DialogAnimation</item>
    </style>
    <!-- Dialog进出动画 -->
    <style name="DialogAnimation" parent="@android:style/Animation.Dialog">
        <item name="android:windowEnterAnimation">@anim/custom_dialog_in</item>
        <item name="android:windowExitAnimation">@anim/custom_dialog_out</item>
    </style>
```
#### 构造方法中使用
```
	CustomDialog(@NonNull Context context, @StyleRes int themeResId)
```
### 修改 dialog 底部按钮的颜色  
![](http://i.imgur.com/nC7GWPQ.png)
#### 设置 Style 
<!--设置按钮的颜色-->
```
    <style name="CustomDialogButton" parent="Theme.AppCompat.Light.Dialog">
        <item name="buttonBarPositiveButtonStyle">@style/buttonBarPositive</item>
        <item name="buttonBarNeutralButtonStyle">@style/buttonBarNeutral</item>
        <item name="buttonBarNegativeButtonStyle">@style/buttonBarNegative</item>
    </style>
    <style name="buttonBarPositive" parent="@style/Widget.AppCompat.Button.ButtonBar.AlertDialog">
        <item name="android:textColor">@color/sure</item>
    </style>
    <style name="buttonBarNegative" parent="@style/Widget.AppCompat.Button.ButtonBar.AlertDialog">
        <item name="android:textColor">@color/cancel</item>
    </style>
    <style name="buttonBarNeutral" parent="@style/Widget.AppCompat.Button.ButtonBar.AlertDialog">
        <item name="android:textColor">@color/neutrality</item>
    </style> 
```
#### 构造方法中使用
```
	CustomDialog(@NonNull Context context, @StyleRes int themeResId)
```


