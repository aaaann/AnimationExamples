package com.androidschool.animationexamples;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidschool.animationexamples.fragments.CustomViewAnimationFragment;
import com.androidschool.animationexamples.fragments.DrawableAnimationFragment;
import com.androidschool.animationexamples.fragments.ObjectAnimationFragment;
import com.androidschool.animationexamples.fragments.StubFragment;
import com.androidschool.animationexamples.fragments.ValueAnimationFragment;
import com.androidschool.animationexamples.fragments.ViewAnimationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_animation, new StubFragment())
                    .commit();
        }

        onClickDisplay(R.id.btn_anim_drawable, new DrawableAnimationFragment());
        onClickDisplay(R.id.btn_anim_view, new ViewAnimationFragment());
        onClickDisplay(R.id.btn_anim_value, new ValueAnimationFragment());
        onClickDisplay(R.id.btn_anim_object, new ObjectAnimationFragment());
        onClickDisplay(R.id.btn_anim_custom_view, new CustomViewAnimationFragment());

    }

    private void onClickDisplay(@IdRes int viewId, @NonNull Fragment animFragment) {
        findViewById(viewId).setOnClickListener((v) -> {
            getSupportFragmentManager()
                .beginTransaction()
                    .replace(R.id.fragment_animation, animFragment)
                    .commit();
                }
        );
    }
}
