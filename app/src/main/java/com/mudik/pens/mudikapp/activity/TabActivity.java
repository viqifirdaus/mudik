package com.mudik.pens.mudikapp.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


import com.mudik.pens.mudikapp.R;
import com.mudik.pens.mudikapp.fragment.AboutFragment;
import com.mudik.pens.mudikapp.fragment.CompassFragment;
import com.mudik.pens.mudikapp.fragment.EntertainFragment;
import com.mudik.pens.mudikapp.fragment.InfoFragment;
import com.mudik.pens.mudikapp.fragment.PrayScheduleFragment;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by Rimawanti Fauzyah on 5/26/2016.
 */
public class TabActivity extends ActionBarActivity implements MaterialTabListener {
    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    MaterialTabHost tabHost;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = this.getResources();


        tabHost = (MaterialTabHost) this.findViewById(R.id.materialTabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        // init view pager
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });

       // for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(res.getDrawable(R.drawable.ic_marker))
                            .setTabListener(this)

            );
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(res.getDrawable(R.drawable.ic_sholat))
                            .setTabListener(this)

            );
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(res.getDrawable(R.drawable.ic_compass))
                            .setTabListener(this)

            );
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(res.getDrawable(R.drawable.ic_hiburan))
                            .setTabListener(this)

            );
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(res.getDrawable(R.drawable.ic_help))
                            .setTabListener(this)

            );

       // }
    }
    @Override
    public void onTabSelected(MaterialTab tab) {

        pager.setCurrentItem(tab.getPosition());
        /*Toast.makeText(this, "TAB: "+(String.valueOf(tab.getPosition())),
                Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public Fragment getItem(int num) {
            Fragment frag = null;
            switch (num){
                case 0:
                    return frag = new InfoFragment();
                case 1:
                    return frag = new PrayScheduleFragment();
                case 2:
                    return frag = new CompassFragment();
                case 3:
                    return frag = new EntertainFragment();
                case 4:
                    return frag = new AboutFragment();

            }
            return frag;
        }
        @Override
        public int getCount() {
            return 5;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "tab";
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();
        System.exit(0);
    }
}