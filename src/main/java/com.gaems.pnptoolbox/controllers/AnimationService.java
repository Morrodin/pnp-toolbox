package com.gaems.pnptoolbox.controllers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;

/**
 * Controller class to manage different animation types.
 *
 * @author Kenton Watson (kwatson@nerdery.com)
 */
public class AnimationService {

    public void doSlideDown(ViewGroup view, Context ctx){
//        RelativeLayout myView = (RelativeLayout) mActivity.findViewById(R.id.my_view);


        setLayoutAnim_slidedown(view, ctx);
        view.startLayoutAnimation();
    }

    public void doSlideUp(ViewGroup view, Context ctx){
//        RelativeLayout myView = (RelativeLayout) mActivity.findViewById(R.id.combat_ac);
        setLayoutAnim_slideup(view, ctx);
        view.startLayoutAnimation();
    }

    public void setLayoutAnim_slidedown(final ViewGroup panel, Context ctx) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(800);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                panel.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                // TODO Auto-generated method stub

            }
        });
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.25f);
        panel.setLayoutAnimation(controller);

    }

    public void setLayoutAnim_slideup(final ViewGroup panel, Context ctx) {

        AnimationSet set = new AnimationSet(true);

		/*
		 * Animation animation = new AlphaAnimation(1.0f, 0.0f);
		 * animation.setDuration(200); set.addAnimation(animation);
		 */

        Animation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f);
        animation.setDuration(800);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                panel.setVisibility(View.INVISIBLE);
                // TODO Auto-generated method stub

            }
        });
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.25f);
        panel.setLayoutAnimation(controller);

    }

}
