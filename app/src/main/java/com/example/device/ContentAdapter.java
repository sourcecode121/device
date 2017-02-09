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
        else if (position == 1) {
            return new CpuFragment();
        }
        else {
            return new MemoryFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return DeviceFragment.TITLE;
        }
        else if (position == 1) {
            return CpuFragment.TITLE;
        }
        else {
            return MemoryFragment.TITLE;
        }
    }
}
