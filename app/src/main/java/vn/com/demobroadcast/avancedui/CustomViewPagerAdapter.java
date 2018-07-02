package vn.com.demobroadcast.avancedui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomViewPagerAdapter extends FragmentPagerAdapter {
    Fragment fragment;
    String title;
    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment= FragmentA.newInstance();
                break;

            case 1:
                fragment=FragmentB.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                title ="FragmentA";
                break;

            case 1:
                title="Fragment B";
                break;
        }
        return title;
    }
}
