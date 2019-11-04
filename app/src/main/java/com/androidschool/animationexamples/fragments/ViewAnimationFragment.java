package com.androidschool.animationexamples.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.androidschool.animationexamples.R;

public class ViewAnimationFragment extends Fragment {
    private View mView;

    public ViewAnimationFragment() {
        super(R.layout.fragment_view_animation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        mView = root.findViewById(R.id.imageView);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mView.startAnimation(animateProgrammatically());

    }

    @Override
    public void onStop() {
        super.onStop();
        mView.clearAnimation();
    }


    private AnimationSet animateProgrammatically() {
        // create scale animation
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setDuration(1000);

        // create alpha animation
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1f);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setDuration(1000);

        //create translate animation
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.5f
        );
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        translateAnimation.setDuration(1000);

        // add animations to AnimationSet
        AnimationSet animations = new AnimationSet(false);
        animations.addAnimation(scaleAnimation);
        animations.addAnimation(alphaAnimation);
        animations.addAnimation(translateAnimation);

        return animations;
    }

}
