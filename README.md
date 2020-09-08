# 主要功能

- 几行代码轻松实现底部导航栏（Tab文字图片高度随意更改）；
- 中间可添加加号按钮，也可添加文字；（足够的属性满足你需要实现的加号样式）
- 如果还不能满足、中间可添加自定义View；
- Tab中随意添加小红点提示、数字消息提示；
- 点击按钮可跳转界面、也可作为Tab切换Fragment；
- 2.0.+迁移AndroidX、支持ViewPager2;
- 剥离导航栏、不传Fragment则不会创建ViewPager、可自行实现ViewPager使用setupWithViewPager方法与之关联；
- 支持仅图片、仅文字的方式.；
- 支持字体单位修改、SP和DP切换；
- 支持红点消息大于99、则显示椭圆可自定义背景颜色及角度；
- 更多使用参考简书；



简书地址:[https://www.jianshu.com/p/ce8e09cda486](https://www.jianshu.com/p/ce8e09cda486 "悬停显示")


# 效果图

![image](https://github.com/forvv231/EasyNavigation/blob/master/screenshot/pre.gif)



![image](https://github.com/forvv231/EasyNavigation/blob/master/screenshot/pre5.jpg)
![image](https://github.com/forvv231/EasyNavigation/blob/master/screenshot/pre3.jpg)
![image](https://github.com/forvv231/EasyNavigation/blob/master/screenshot/pre4.jpg)


# 实现
- 依赖

Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
     	implementation 'com.github.Vincent7Wong:EasyNavigation:1.5.0'
     	//2.0.5  AndroidX版本、支持ViewPager2
     	implementation 'com.github.Vincent7Wong:EasyNavigation:2.0.5'
```

---
```
navigationBar.defaultSetting()  //恢复默认配置、可用于重绘导航栏
                .titleItems(tabText)      //  Tab文字集合  只传文字则只显示文字
                .normalIconItems(normalIcon)   //  Tab未选中图标集合
                .selectIconItems(selectIcon)   //  Tab选中图标集合
                .fragmentList(fragments)       //  fragment集合
                .fragmentManager(getSupportFragmentManager())
                .iconSize(20)     //Tab图标大小
                .tabTextSize(10)   //Tab文字大小
                .tabTextTop(2)     //Tab文字距Tab图标的距离
                .normalTextColor(Color.parseColor("#666666"))   //Tab未选中时字体颜色
                .selectTextColor(Color.parseColor("#333333"))   //Tab选中时字体颜色
                .scaleType(ImageView.ScaleType.CENTER_INSIDE)  //同 ImageView的ScaleType
                .navigationBackground(Color.parseColor("#80000000"))   //导航栏背景色
                .setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabSelectEvent(View view, int position) {
                        //Tab点击事件  return true 页面不会切换

                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        //Tab重复点击事件
                        return false;
                    }
                })
                .smoothScroll(false)  //点击Tab  Viewpager切换是否有动画
                .canScroll(true)    //Viewpager能否左右滑动
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)   //默认MODE_NORMAL 普通模式  //MODE_ADD 带加号模式
                .centerTextStr("发现")
                .centerImageRes(R.mipmap.add_image)
                .centerIconSize(36)    //中间加号图片的大小
                .centerLayoutHeight(100)   //包含加号的布局高度 背景透明  所以加号看起来突出一块
                .navigationHeight(60)  //导航栏高度
                .lineHeight(10)         //分割线高度  默认1px
                .lineColor(Color.parseColor("#ff0000"))
                .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM) //RULE_CENTER 加号居中addLayoutHeight调节位置 EasyNavigationBar.RULE_BOTTOM 加号在导航栏靠下
                .centerLayoutBottomMargin(10)   //加号到底部的距离
                .hasPadding(true)    //true ViewPager布局在导航栏之上 false有重叠
                .hintPointLeft(-3)  //调节提示红点的位置hintPointLeft hintPointTop（看文档说明）
                .hintPointTop(-3)
                .hintPointSize(6)    //提示红点的大小
                .msgPointLeft(-10)  //调节数字消息的位置msgPointLeft msgPointTop（看文档说明）
                .msgPointTop(-10)
                .msgPointTextSize(9)  //数字消息中字体大小
                .msgPointSize(18)    //数字消息红色背景的大小
                .centerAlignBottom(true)  //加号是否同Tab文字底部对齐  RULE_BOTTOM时有效；
                .centerTextTopMargin(50)  //加号文字距离加号图片的距离
                .centerTextSize(15)      //加号文字大小
                .centerNormalTextColor(Color.parseColor("#ff0000"))    //加号文字未选中时字体颜色
                .centerSelectTextColor(Color.parseColor("#00ff00"))    //加号文字选中时字体颜色
                .setMsgPointColor(Color.BLUE) //数字消息、红点背景颜色
                .setMsgPointMoreRadius(5) //消息99+角度半径
                .setMsgPointMoreWidth(50)  //消息99+宽度
                .setMsgPointMoreHeight(40)  //消息99+高度
                .textSizeType(EasyNavigationBar.TextSizeType.TYPE_DP)  //字体单位 建议使用DP  可切换SP
                .setOnTabLoadListener(new EasyNavigationBar.OnTabLoadListener() { //Tab加载完毕回调
                    @Override
                    public void onTabLoadCompleteEvent() {
                        navigationBar.setMsgPointCount(0, 7);
                        navigationBar.setMsgPointCount(1, 109);
                        navigationBar.setHintPoint(4, true);
                    }
                })
                //.setupWithViewPager() ViewPager或ViewPager2
                .build();
```
---
# 更新

- 此版本较上一版本有很大更新、实现方式也调整了下、如有错误及时反馈
- 2.0.+迁移AndroidX、支持ViewPager2;
- 剥离导航栏、不传Fragment则不会创建ViewPager、可自行实现ViewPager使用setupWithViewPager方法与之关联；
- 新增仅图片、仅文字的方式。titleItems和normalIconItems不能同时为空。如果没有titleItems、则仅显示图片，没有normalIconItems则仅显示文字，没有selectIconItems则Tab没有切换效果；
- 新增字体单位修改、SP和DP切换；
- 新增红点消息大于99、则显示椭圆可自定义背景颜色及角度；
- 修复控件宽度计算问题；
- 新增重复选择回调；
- 方法名字诸多修改；（中间Tab的相关属性由add改为center/万分抱歉）
- 取消Tab点击动画

---
# Demo

github：[https://github.com/Vincent7Wong/EasyNavigation](https://github.com/Vincent7Wong/EasyNavigation)

apk：http://d.6short.com/7r4d

![image.png](https://upload-images.jianshu.io/upload_images/5739496-be94c7122ef83c51.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

