ActivityOptionsICS
===========
f you are thinking on customizing the animation of Activity transition then probably you would look for ActivityOptions.However ActivityOptions class introduced in Android 4.1 (Jelly bean). ActivityOptionsICS can make it use in 3.1+. The library provided some methods which can help you to customize the Activity Animation.

![](http://images.cnitblog.com/blog/651487/201411/281237244814806.gif)
![](http://images.cnitblog.com/blog/651487/201411/281238364811410.gif)
ActivityOptionsCompatICS
-------
1. public static ActivityOptionsCompatICS makeCustomAnimation(Context context,int enterResId, int exitResId)
1. public static ActivityOptionsCompatICS makeScaleUpAnimation(View source, int startX, int startY, int width, int height)
1. public static ActivityOptionsCompatICSmakeThumbnailScaleUpAnimation(View source, Bitmap thumbnail, int startX, int startY) 
1. public static ActivityOptionsCompatICS makeSceneTransitionAnimation(Activity activity, View view, sharedElement,int sharedElementId)
1. public static ActivityOptionsCompatICS makeSceneTransitionAnimation(Activity activity, Pair<View, Integer>... sharedElements)

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


    public class TargetActivity extends Activity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO 自动生成的方法存根
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_target);// 这段代码必须放在TransitionCompatICS各种设置之后
            TransitionCompat.startTransition(this, R.layout.activity_target);
        }
        
       @Override
        public void onBackPressed() {
            //super.onBackPressed();// 这段代码必须放在TransitionCompatICS各种设置之后
            TransitionCompat.finishAfterTransition(this);
            
        }
    }