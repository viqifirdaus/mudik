package com.mudik.pens.mudikapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mudik.pens.mudikapp.R;

/**
 * Created by Rimawanti Fauzyah on 13-Jul-16.
 */
public class AboutFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vResult = inflater.inflate(R.layout.about_fragment, container, false);
       /* TextView text = new TextView(container.getContext());
        text.setText("Fragment content");
        text.setGravity(Gravity.CENTER);*/

        return vResult;
    }
}