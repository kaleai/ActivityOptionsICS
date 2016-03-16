 ActivityOptionsICS
 
 #本项目停止维护
 
===========
f you are thinking on customizing the animation of Activity transition then probably you would look for ActivityOptions.However ActivityOptions class introduced in Android 4.1 (Jelly bean). ActivityOptionsICS can make it use in 3.1+. The library provided some methods which can help you to customize the Activity Animation.


Screenshot
--
Please waiting for loading...

![](https://raw.githubusercontent.com/tianzhijiexian/ActivityOptionsICS/master/pictures/001.gif)

![](https://raw.githubusercontent.com/tianzhijiexian/ActivityOptionsICS/master/pictures/002.gif)


![](https://raw.githubusercontent.com/tianzhijiexian/ActivityOptionsICS/master/pictures/003.gif)

![](https://raw.githubusercontent.com/tianzhijiexian/ActivityOptionsICS/master/pictures/004.gif)


ActivityOptionsCompatICS
--

1. public static ActivityOptionsCompatICS makeCustomAnimation(Context context,int enterResId, int exitResId)
>This method allows to pass custom animation and when the Atyctivi is launched, it gets rendered accordingly. Here you can pass animation for transitioning out Activity as well as for transitioning in Activity   

2. public static ActivityOptionsCompatICS makeScaleUpAnimation(View source, int startX, int startY, int width, int height)  
>This method scales up the Activity from the initial size to its final representational size. It can be used to scale up the activity from the view which has launched this activity.  

3. public static ActivityOptionsCompatICSmakeThumbnailScaleUpAnimation(View source, Bitmap thumbnail, int startX, int startY)   
>In this animation, a thumbnail of the activity scales up to the final size of the activity.  

4. public static ActivityOptionsCompatICS makeSceneTransitionAnimation(Activity activity, View view, sharedElement,int sharedElementId)
>This method carries the position of one shared element to the started Activity.The position of <code>sharedElement</code> will be used as the epicenter for the exit Transition. 

5. public static ActivityOptionsCompatICS makeSceneTransitionAnimation(Activity activity, Pair<View, Integer>... sharedElements)
>This method carries the position of multiple shared elements to the started Activity. The position of the first element in sharedElements will be used as the epicenter for the exit Transition. The position of the associated shared element in the launched Activity will be the epicenter of its entering Transition.  


ActivityCompatICS
----
1. public static void startActivity(Activity activity, Intent intent, Bundle bundle) 

TransitionCompat
----
1. TransitionCompat.startTransition(this, R.layout.activity_target);
2. TransitionCompat.finishAfterTransition(this);

 		


# How to use
	
If you want use this library, you only have to download this project, import it into your workspace and add the project as a library in your android project settings.

### In MainActivity  


 **makeCustomAnimation** 
 
       public void customAnim() {
        		ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeCustomAnimation(this,
        				R.anim.slide_bottom_in, R.anim.slide_bottom_out);
        		ActivityCompatICS.startActivity(MainActivity.this, intent, options.toBundle());
        	}
**makeScaleUpAnimation**  

    public void scaleUpAnim(View view) {
    		ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeScaleUpAnimation(view,
    				 0, 0, //拉伸开始的坐标
    	             view.getMeasuredWidth(), view.getMeasuredHeight());//初始的宽高
    		ActivityCompatICS.startActivity(MainActivity.this, intent, options.toBundle());
    	}
	
**makeThumbnailScaleUpAnimation**  

    public void thumbNailScaleAnim(ImageView view) {
    		view.setDrawingCacheEnabled(true);
    		 Bitmap bitmap = view.getDrawingCache();
    		  ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeThumbnailScaleUpAnimation(
    		    view, bitmap, 0, 0);
    		  // Request the activity be started, using the custom animation options.
    		  ActivityCompatICS.startActivity(MainActivity.this, intent, options.toBundle());
    		  //view.setDrawingCacheEnabled(false);
    	}
	
**makeSceneTransitionAnimation**

    screenTransitAnimByPair(
					Pair.create((View)orginalImageView, R.id.target_imageView),
					Pair.create((View)orginalTextView, R.id.target_textView),
					Pair.create((View)chromeIView, R.id.target_chrome_imageView));   
# 
    public void screenTransitAnimByPair(Pair<View, Integer>... views) {
    		isSceneAnim = true;
    		ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeSceneTransitionAnimation(
    				MainActivity.this, views);
    		ActivityCompatICS.startActivity(MainActivity.this, intent, options.toBundle());
    	}
  
  
##In TargetActivity
1.make translucentTheme in style.xml    
 
	<style name="TranslucentTheme" parent="AppBaseTheme">
        <item name="android:windowIsTranslucent">true</item>
    </style
2.set targetActivity's theme in manifest.xml        

	<activity   
		android:name="com.example.activityoptionsjbtest.TargetActivity"   
		android:theme="@style/TranslucentTheme" />     
  
3.start transition in targetActivity    

    public class TargetActivity extends Activity{

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_target);

		    TransitionCompat.startTransition(this, R.layout.activity_target);
	    }
	    
	    @Override
	    public void onBackPressed() {
		    //super.onBackPressed();
		    TransitionCompat.finishAfterTransition(this); 
	    }
    }  


Developed By
--------------------

Kale <developer_kale@qq.com>  

![](https://avatars3.githubusercontent.com/u/9552155?v=3&s=460)
