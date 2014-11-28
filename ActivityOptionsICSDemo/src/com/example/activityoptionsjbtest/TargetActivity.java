package com.example.activityoptionsjbtest;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import com.kale.activityoptions.anim.ViewAnimationListenerAdapter;
import com.kale.activityoptions.transition.TransitionCompat;
import com.kale.activityoptions.transition.TransitionListenerAdapter;



public class TargetActivity extends Activity{

	boolean isShowed = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_target);
		
		/**
		 * view动画的监听器，比如thumbNailScaleAnim，screenTransitAnim这样的动画就会在这里得到监听
		 * 
		 * 这里的值是说明动画进行到什么时候，原始的view开始显示
		 * 设置方式是：动画时间越长，可以设置的越精细，越靠近1，动画时间越短设置为0.95就差不多了
		 * 这里的值请自行根据你的动画长度进行调整，如果调整不好可能会出现动画结束后相应元素不见的问题。
		 * 这里测试是如果动画是2000ms，那么用0.998较为合适
		 */
		final float fraction = 0.92f;
		TransitionCompat.addViewAnimListener(new ViewAnimationListenerAdapter() {
			public void onViewAnimationUpdate(View view, ValueAnimator valueAnimator, float progress) {
				super.onViewAnimationUpdate(view, valueAnimator, progress);
				// 判断当前是否是进入的状态，如果是进入的那么isEnter= true
				if (!TransitionCompat.isEnter && progress >= fraction && !isShowed) {
					MainActivity.handler.sendEmptyMessage(123);
					isShowed = true;
				}
			}
		});
		
		/**
		 * 屏幕（场景）动画的监听器，这里用了适配器模式。可以传入完整的接口实现类
		 */
		TransitionCompat.addListener(new TransitionListenerAdapter() {
			@Override
			public void onTransitionEnd(Animator animator, Animation animation,
					boolean isEnter) {
				super.onTransitionEnd(animator, animation, isEnter);
				// TODO:
			}
		});

//		TransitionCompat.setEnterTransition(new SceneFade(this, true));// use to scale Up animation
//		TransitionCompat.setAnimDuration(300);// default
//		TransitionCompat.setAnimStartDelay(0);// default
//		TransitionCompat.setTimeInterpolator(new AccelerateDecelerateInterpolator());// default
		TransitionCompat.setAnimDuration(300);
		// 这段代码必须放在ActivityOptionsCompat各种设置之后
		TransitionCompat.startTransition(this, R.layout.activity_target);
	}
	
	
	
	@Override
	public void onBackPressed() {
		//super.onBackPressed();
		//TransitionCompat.setExitTransition(new SceneFade(this, true));
		//TransitionCompat.setAnimStartDelay(0);// default
		//TransitionCompat.setAnimDuration(300);// default
		//TransitionCompat.setTimeInterpolator(new AccelerateDecelerateInterpolator());// default
		//TransitionCompat.finishAfterTransition(activity, enterAnim, exitAnim);// custom animation
		// 这段代码必须放在ActivityOptionsCompat各种设置之后
		TransitionCompat.finishAfterTransition(this);
		
	}
}
