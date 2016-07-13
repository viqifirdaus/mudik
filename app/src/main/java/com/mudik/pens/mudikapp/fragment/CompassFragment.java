package com.mudik.pens.mudikapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mudik.pens.mudikapp.R;
import com.mudik.pens.mudikapp.model.Compass;

/**
 * Created by Rimawanti Fauzyah on 7/5/2016.
 */
public class CompassFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "CompassActivity";

    private Compass compass;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vResult = inflater.inflate(R.layout.compass_fragment, container, false);

        return vResult;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        compass = new Compass(getActivity());
        compass.arrowView = (ImageView) view.findViewById(R.id.main_image_hands);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "start compass");
        compass.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        compass.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        compass.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "stop compass");
        compass.stop();
    }

}