package com.androidschool.animationexamples.fragments;


import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidschool.animationexamples.R;

public class ValueAnimationFragment extends Fragment {

    private static final String SCALE = "scale";
    private static final String ROTATION = "rotation";
    private static final String TRANSLATION = "translationY";
    private static final String COLOR = "color";
    private ValueAnimator mAnimator;
    private View mView;

    public ValueAnimationFragment() {
        super(R.layout.fragment_value_animation);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        mView = root.findViewById(R.id.imageView);
        PropertyValuesHolder scaleHolder = PropertyValuesHolder.ofFloat(SCALE, 0.3f, 1.5f);
        PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt(COLOR, Color.RED, Color.YELLOW);
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat(ROTATION, 0f, 360f);
        PropertyValuesHolder translationHolder = PropertyValuesHolder.ofFloat(TRANSLATION, mView.getY(), mView.getLayoutParams().height);
        mAnimator = ValueAnimator.ofPropertyValuesHolder(scaleHolder, colorHolder, rotationHolder, translationHolder);
        configureAnimator(mAnimator);
        mAnimator.addUpdateListener(
                animation -> {
                    mView.setScaleX((Float) animation.getAnimatedValue(SCALE));
                    mView.setScaleY((Float) animation.getAnimatedValue(SCALE));
                    mView.setTranslationX((Float) animation.getAnimatedValue(TRANSLATION));
                    mView.setTranslationY((Float) animation.getAnimatedValue(TRANSLATION));
                    mView.setRotation((Float) animation.getAnimatedValue(ROTATION));
                    mView.setBackgroundColor((Integer) animation.getAnimatedValue(COLOR));
                }
        );
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAnimator.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAnimator.cancel();
    }

    private void configureAnimator(ValueAnimator animator) {
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
    }
}
