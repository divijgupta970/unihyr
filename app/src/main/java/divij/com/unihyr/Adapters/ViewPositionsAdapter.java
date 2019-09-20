package divij.com.unihyr.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import divij.com.unihyr.VIewPositionsProfilesFragment;
import divij.com.unihyr.ViewPositionsDrivesFragment;
import divij.com.unihyr.ViewPositionsTeamFragment;
import divij.com.unihyr.ViewPositionsToDoFragment;

public class ViewPositionsAdapter extends FragmentPagerAdapter {
    public ViewPositionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new VIewPositionsProfilesFragment();
            case 1: return new ViewPositionsToDoFragment();
            case 2: return new ViewPositionsTeamFragment();
            case 3: return new ViewPositionsDrivesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
