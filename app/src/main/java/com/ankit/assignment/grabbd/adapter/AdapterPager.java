package com.ankit.assignment.grabbd.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ankit.assignment.grabbd.fragments.FragmentExplore;
import com.ankit.assignment.grabbd.fragments.FragmentSearch;

public class AdapterPager extends FragmentStatePagerAdapter{

    FragmentManager mManager;
    int  NO_OF_TABS = 2;

    public AdapterPager(FragmentManager manager){
        super(manager);
        this.mManager = manager;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :return new FragmentExplore();

            case 1 : return new FragmentSearch();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return NO_OF_TABS;
    }
}
