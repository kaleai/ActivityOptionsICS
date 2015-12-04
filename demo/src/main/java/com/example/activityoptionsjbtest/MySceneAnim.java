package com.example.activityoptionsjbtest;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.kale.activityoptions.transition.TransitionAnims;


public class MySceneAnim extends TransitionAnims{

	public MySceneAnim(Activity activity) {
		super(activity);
		// TODO 自动生成的构造函数存根
		getActivity();//得到要启动动画的activity
		getAnimsDuration();//得到通过transitionCompatICS设置的动画持续时间
		getAnimsInterpolator();//得到通过transitionCompatICS设置的动画效果
		getBackground();//得到当前activity默认的背景图片，这个是开源项目中默认设置的，是一个#eeeeee的drawable。仅仅用于收尾操作
		getAnimsStartDelay();////得到通过transitionCompatICS设置的动画延迟时间
		getSceneRoot();//重要：执行动画的view对象。
	}

	@Override
	public void playScreenEnterAnims() {
		// TODO 自动生成的方法存根
	}

	@Override
	public void playScreenExitAnims() {
		// TODO 自动生成的方法存根
		View sceneRoot = getSceneRoot();
		Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_bottom_out);
		animation.setDuration(1000);
		animation.setAnimationListener(new TransitionAnimsListener() {
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO 自动生成的方法存根
				super.onAnimationEnd(animation);
				exitAnimsEnd();// you must use this method
			}
		});
		sceneRoot.startAnimation(animation);
	}

}
