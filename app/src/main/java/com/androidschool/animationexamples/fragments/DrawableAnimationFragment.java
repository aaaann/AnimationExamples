package com.androidschool.animationexamples.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.androidschool.animationexamples.R;

public class DrawableAnimationFragment extends Fragment {

    private AnimationDrawable mDrawable;

    public DrawableAnimationFragment() {
        super(R.layout.fragment_animation_drawable);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        ImageView horseImageView = root.findViewById(R.id.iv_horse);
        mDrawable = (AnimationDrawable) horseImageView.getDrawable();
        horseImageView.post(() -> mDrawable.start());
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mDrawable.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mDrawable.stop();
    }
}
