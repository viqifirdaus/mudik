package com.mudik.pens.mudikapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.mudik.pens.mudikapp.R;
import com.mudik.pens.mudikapp.adapter.CategoryAdapter;
import com.mudik.pens.mudikapp.adapter.PlaceAdapter;
import com.mudik.pens.mudikapp.model.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rimawanti Fauzyah on 5/26/2016.
 */
public class InfoFragment extends android.support.v4.app.Fragment {
    private List<Place> listPlace = null;
    private PlaceAdapter listAdaptorPlace= null;

    // stores the image database icons
    private static Integer[] catIcon = { R.drawable.kosong,R.drawable.ic_masjid,
            R.drawable.ic_pom, R.drawable.ic_home, R.drawable.ic_cek,
            R.drawable.ic_home };

    // stores the image database names
    private String[] catName = { "--- Pilih Kategori ---","Masjid terdekat", "Pom Bensin terdekat","ATM Terdekat", "Rumah sakit terdekat", "Restoran terdekat"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vResult    = inflater.inflate(R.layout.info_fragment, container, false);

        return  vResult;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //list place CONTOH
        listPlace = new ArrayList<>();
        listPlace.add(new Place("ATM Mandiri","1.084 km dari tempat anda",R.drawable.ic_home));
        listPlace.add(new Place("ATM BNI SYARIAH","1.085 km dari tempat anda",R.drawable.ic_home));
        listPlace.add(new Place("ATM Bank Danamon","1.084 km dari tempat anda",R.drawable.ic_home));

        ListView l = (ListView) view.findViewById(R.id.placelistView);
        listAdaptorPlace = new PlaceAdapter(getActivity(),
                R.layout.place_list_view, listPlace);
        l.setAdapter(listAdaptorPlace);


        //kategori
        Spinner spinner = (Spinner) view.findViewById(R.id.cat);

        CategoryAdapter adapter = new CategoryAdapter(getActivity(), R.layout.category_list_view, catName, catIcon);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
    }


}