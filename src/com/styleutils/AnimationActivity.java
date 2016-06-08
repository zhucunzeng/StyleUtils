package com.styleutils;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;


public class AnimationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
    }
    
    // 以下是View视图动画，存放于anim
    public void onFadeIn(View view) {
    	//AlphaAnimation
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
    }
    
    public void onFadeOut(View view) {
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out));
    }
    
    public void onZoomIn(View view) {
    	//ScaleAnimation
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
    }
    
    public void onZoomOut(View view) {
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.zoom_out));
    }
    
    public void onMoveLeft2Right(View view) {
    	//TranslateAnimation
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.move_left_to_right));
    }
    
    public void onMoveInFromBottom(View view) {
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.move_in_from_bottom));
    }
    
    public void onRotate(View view) {
    	//RotateAnimation
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_one));
    }
    
    public void onMoveAndScale(View view) {
    	view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.move_and_scale));
    }
    
    // 以下是Property属性动画，存放于animator
    public void onValueAnimator(final View view) {
        // 获取屏幕宽度
        final int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator mEvaluator = new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                // 当前动画值，即为当前宽度比例值
                int currentValue = (Integer) animator.getAnimatedValue();
                // 根据比例更改目标view的宽度
                view.getLayoutParams().width = maxWidth * currentValue / 100;
                view.requestLayout();
            }
        });
        valueAnimator.start();
    }
    
    public void onObjectAnimator(View view) {
        // 获取屏幕宽度
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator);
        objectAnimator.setTarget(wrapper);
        objectAnimator.start();
    }
    
    public void onAnimatorSet(View view) {
        // 获取屏幕宽度
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animator_set);
        animatorSet.setTarget(wrapper);
        animatorSet.start();
    }
    
    private static class ViewWrapper {
        private View target;
        private int maxWidth;

        public ViewWrapper(View target, int maxWidth) {
            this.target = target;
            this.maxWidth = maxWidth;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int widthValue) {
            target.getLayoutParams().width = maxWidth * widthValue / 100;
            target.requestLayout();
        }

        public void setMarginTop(int margin) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) target.getLayoutParams();
            layoutParams.setMargins(0, margin, 0, 0);
            target.setLayoutParams(layoutParams);
        }
    }
}
