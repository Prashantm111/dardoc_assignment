package com.example.dardocassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        DataInfoFragment dataInfoFragment=new DataInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("anydata", "Any data we can pass with using bundle");
        dataInfoFragment.setArguments(bundle);
        return dataInfoFragment;
    }

    @Override
    public int getCount() {
        // Fixed 100 as of now
        return 100;
    }
}
