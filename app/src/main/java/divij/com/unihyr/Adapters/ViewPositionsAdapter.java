package divij.com.unihyr.Adapters;

import android.util.Log;
import android.view.MotionEvent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPositionsAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragments = new ArrayList<>();
    List<String> mFragmentsTitle = new ArrayList<>();
    public ViewPositionsAdapter(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment f, String s) {
        mFragments.add(f);
        mFragmentsTitle.add(s);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentsTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
