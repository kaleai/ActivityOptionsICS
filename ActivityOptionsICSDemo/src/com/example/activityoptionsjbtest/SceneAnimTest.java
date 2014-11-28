package com.example.activityoptionsjbtest;

import android.app.Activity;

import com.kale.activityoptions.transition.TransitionAnims;


public class SceneAnimTest extends TransitionAnims{

	public SceneAnimTest(Activity activity, boolean isEntireScreenAnim) {
		super(activity, isEntireScreenAnim);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void playScreenEnterAnims() {
		// TODO 自动生成的方法存根
		getActivity();//得到要启动动画的activity
		getAnimsDuration();//得到通过transitionCompatICS设置的动画持续时间
		getAnimsInterpolator();//得到通过transitionCompatICS设置的动画效果
		getBackground();//得到当前activity默认的背景图片，这个是开源项目中默认设置的，是一个#eeeeee的drawable。仅仅用于收尾操作
		getAnimsStartDelay();////得到通过transitionCompatICS设置的动画延迟时间
		getIsEntireScreenAnim();////得到当前是否是让整个屏幕执行动画，如果不是那么就是让activity的actionbar下方的view执行动画
		getSceneRoot();//重要：执行动画的view对象。
	}

	@Override
	public void playScreenExitAnims() {
		// TODO 自动生成的方法存根
		
	}

}
