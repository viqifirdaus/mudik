package com.mudik.pens.mudikapp.model;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Rimawanti Fauzyah on 5/19/2016.
 */
public class Place {
    public String p_name, p_detail;
    public int img;
    public Place(String nama, String detil, int gambar){
        this.p_name = nama;
        this.p_detail= detil;
        this.img = gambar;
    }


}
