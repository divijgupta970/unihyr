package divij.com.unihyr;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_dashboard, container, false);
        viewPager=v.findViewById(R.id.dashBoardViewPager);
        tabLayout=v.findViewById(R.id.dashBoardTabLayout);
        viewPager.setAdapter(new DashboardFragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("ANALYTICS");
        tabLayout.getTabAt(1).setText("REPORTS");
        return v;
    }

}
