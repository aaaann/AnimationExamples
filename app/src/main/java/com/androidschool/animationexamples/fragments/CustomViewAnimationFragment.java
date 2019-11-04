package com.androidschool.animationexamples.fragments;


import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.androidschool.animationexamples.R;
import com.androidschool.animationexamples.view.FinanceProgressView;

public class CustomViewAnimationFragment extends Fragment {
    private ObjectAnimator mAnimator;

    public CustomViewAnimationFragment() {
        super(R.layout.fragment_custom_view_animation);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        FinanceProgressView financeProgressView = root.findViewById(R.id.financeProgress);
        mAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(requireContext(), R.animator.custom_view_animator);
        mAnimator.setTarget(financeProgressView);
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
        mAnimator.end();
    }
}
