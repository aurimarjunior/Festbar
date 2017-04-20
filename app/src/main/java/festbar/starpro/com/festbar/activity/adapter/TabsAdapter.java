package festbar.starpro.com.festbar.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import festbar.starpro.com.festbar.activity.fragments.FragmentBares;
import festbar.starpro.com.festbar.activity.fragments.FragmentFestas;


public class TabsAdapter extends FragmentStatePagerAdapter {

    private String[] mTabTitles;

    public TabsAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentFestas();
            case 1:
                return new FragmentBares();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }

    @Override
    public int getCount() {
        return mTabTitles.length;
    }
}
