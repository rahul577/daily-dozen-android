package org.slavick.dailydozen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.slavick.dailydozen.Common;
import org.slavick.dailydozen.fragment.DateFragment;

import java.util.Locale;

import hirondelle.date4j.DateTime;

public class DatePagerAdapter extends FragmentStatePagerAdapter {
    public DatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DateFragment.newInstance(getDateByOffsetFromEpoch(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getDateByOffsetFromEpoch(position).format("WWW, MMM D", Locale.getDefault());
    }

    @Override
    public int getCount() {
        return Common.getDaysSinceEpoch();
    }

    private DateTime getDateByOffsetFromEpoch(int position) {
        return Common.getEpoch().plusDays(position);
    }
}
