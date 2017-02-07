package com.example.device;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Anand on 07/02/2017.
 */

public class ContentAdapter extends FragmentPagerAdapter {

    public ContentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DeviceFragment();
        }
        else {
            return new CpuFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return DeviceFragment.TITLE;
        }
        else {
            return CpuFragment.TITLE;
        }
    }
}
