package com.bbarg.bloodborneargentina.bbarg.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bbarg.bloodborneargentina.bbarg.Fragments.WeaponStatFragment;
import com.bbarg.bloodborneargentina.bbarg.Fragments.basicStatFragment;

public class PJPageAdapter extends FragmentStatePagerAdapter{


    public PJPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new basicStatFragment();
            case 1:
                Bundle args = new Bundle();
                args.putBoolean("isLeft", true);
                WeaponStatFragment wFragment = new WeaponStatFragment();
                wFragment.setArguments(args);
                return wFragment;
            case 2:
                Bundle rArgs = new Bundle();
                rArgs.putBoolean("isLeft", false);
                WeaponStatFragment RWFragment = new WeaponStatFragment();
                RWFragment.setArguments(rArgs);
                return RWFragment;
            default:
                return new basicStatFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
