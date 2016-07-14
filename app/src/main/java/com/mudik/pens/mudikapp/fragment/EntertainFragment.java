package com.mudik.pens.mudikapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mudik.pens.mudikapp.R;
import com.mudik.pens.mudikapp.adapter.MediaAdapter;
import com.mudik.pens.mudikapp.adapter.PlaceAdapter;
import com.mudik.pens.mudikapp.model.Media;
import com.mudik.pens.mudikapp.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rimawanti Fauzyah on 7/5/2016.
 */
public class EntertainFragment extends android.support.v4.app.Fragment {
    private List<Media> listMedia = null;
    private MediaAdapter listAdaptorMedia= null;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vResult    = inflater.inflate(R.layout.entertain_fragment, container, false);

        return  vResult;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //list place CONTOH
        listMedia = new ArrayList<>();
        listMedia.add(new Media("Video 1","https:/www.carlyshare.com/mudik/assets/tmp/Wtf is going on -9GAG.mp4"));
        /*listMedia.add(new Media("Video 2","https://www.youtube.com/watch?v=LYpmybdzBmk"));
        listMedia.add(new Media("Video 3","https://www.youtube.com/watch?v=LYpmybdzBmk"));*/

        ListView m = (ListView) view.findViewById(R.id.medialistView);
        listAdaptorMedia = new MediaAdapter(getActivity(),
                R.layout.media_list_view, listMedia);
        m.setAdapter(listAdaptorMedia);
    }
}
