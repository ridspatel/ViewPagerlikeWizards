package com.slidingimages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MoviesFragment extends Fragment implements Animation.AnimationListener {

    private RelativeLayout relTop;
    private TextView txtLogin, txtRegister;

    private Animation animToptoDown, animFadeIn, animFadeOut;

    /* for check view is get or not */
    private boolean isViewShown = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_movies, container,
                false);

        relTop = (RelativeLayout) rootView.findViewById(R.id.relTop);
        txtLogin = (TextView) rootView.findViewById(R.id.txtLogin);
        txtRegister = (TextView) rootView.findViewById(R.id.txtRegister);

        animToptoDown = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slide_top_to_down);
        animFadeIn = AnimationUtils.loadAnimation(getActivity(),
                R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getActivity(),
                R.anim.fade_out);


        // set animation listener
//        animToptoDown.setAnimationListener(this);

//        animation();

        return rootView;
    }

    private void animation() {
        relTop.setVisibility(View.VISIBLE);
        relTop.startAnimation(animToptoDown);
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // check for fade in animation
        if (animation == animToptoDown) {
            txtLogin.setVisibility(View.VISIBLE);
            txtRegister.setVisibility(View.VISIBLE);
            txtLogin.startAnimation(animFadeIn);
            txtRegister.startAnimation(animFadeIn);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        System.out
                .println("===================FriendFragment:::setUserVisibleHint===============");

        if (getView() != null) {
            isViewShown = true;

            if (isVisibleToUser) {
                relTop.setVisibility(View.GONE);
                txtLogin.setVisibility(View.GONE);
                txtRegister.setVisibility(View.GONE);
                // set animation listener
                animToptoDown.setAnimationListener(this);
                animation();
            }
        } else {
            isViewShown = false;
        }
    }
}
