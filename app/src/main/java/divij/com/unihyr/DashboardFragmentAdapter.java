package divij.com.unihyr;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DashboardFragmentAdapter extends FragmentPagerAdapter {
    public DashboardFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new DashboardAnalyticsFragment();
            case 1: return new DashboardReportsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
