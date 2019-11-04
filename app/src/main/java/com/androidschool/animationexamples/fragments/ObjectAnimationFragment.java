package com.androidschool.animationexamples.fragments;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidschool.animationexamples.R;

public class ObjectAnimationFragment extends Fragment {

    private View mView;
    private ObjectAnimator mAnimator;

    public ObjectAnimationFragment() {
        super(R.layout.fragment_object_animation);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        mView = root.findViewById(R.id.imageView);
        mAnimator = (ObjectAnimator) AnimatorInflaterCompat.loadAnimator(requireContext(), R.animator.object_animator);
        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
        mAnimator.setTarget(mView);
        mAnimator.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAnimator.end();
    }
}
