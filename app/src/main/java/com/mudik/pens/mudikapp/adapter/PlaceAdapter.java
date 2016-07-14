package com.mudik.pens.mudikapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mudik.pens.mudikapp.R;
import com.mudik.pens.mudikapp.fragment.InfoFragment;
import com.mudik.pens.mudikapp.model.Media;
import com.mudik.pens.mudikapp.model.Place;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rimawanti Fauzyah on 5/18/2016.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {
    private static List<Place> placeList = null;
    private List<Media> mediaList = null;
    private Context context;
   // private PackageManager packageManager;

    public static Comparator<Place> StringAscComparator = new Comparator<Place>() {

        @Override
        public int compare(Place lhs, Place rhs) {
            String str1 = lhs.p_detail;
            String str2 = rhs.p_detail;
            return str1.compareToIgnoreCase(str2);
        }

        @Override
        public boolean equals(Object object) {
            return false;
        }
    };
    public PlaceAdapter(Context context, int textViewResourceId,
                        List<Place> placeList) {
        super(context, textViewResourceId, placeList);
        this.context = context;
        this.placeList = placeList;
      //  packageManager = context.getPackageManager();
    }



    @Override
    public int getCount() {
        return ((null != placeList) ? placeList.size() : 0);
    }

    @Override
    public Place getItem(int position) {
        return ((null != placeList) ? placeList.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == view) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.place_list_view, null);
        }

        Place data = placeList.get(position);
        //Media data1 = mediaList.get(position);
        if (null != data) {
            TextView pNama = (TextView) view.findViewById(R.id.buttonlist_label_nama);
            TextView pDetail = (TextView) view.findViewById(R.id.buttonlist_label_detail);
            ImageView iconview = (ImageView) view.findViewById(R.id.buttonlist_img_icon);

            pNama.setText(data.p_name);
            pDetail.setText(data.p_detail);
            iconview.setImageResource(data.img);
            Collections.sort(placeList,StringAscComparator);

        }

        return view;
    }
}
