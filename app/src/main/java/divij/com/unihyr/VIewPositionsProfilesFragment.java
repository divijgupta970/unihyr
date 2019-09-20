package divij.com.unihyr;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import divij.com.unihyr.Adapters.ViewPositionsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class VIewPositionsProfilesFragment extends Fragment {
    ViewPositionsAdapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    public VIewPositionsProfilesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_view_positions_profiles, container, false);
        adapter=new ViewPositionsAdapter(getChildFragmentManager());
        tabLayout=v.findViewById(R.id.tabLayoutViewPositionsProfile);
        viewPager=v.findViewById(R.id.viewPagerViewPositionsProfile);
        setUpViewPager();
        return v;
    }
    public void setUpViewPager(){
        VPPActiveProfilesFragment vppActiveProfilesFragment=new VPPActiveProfilesFragment();
        VPPCareerPageFramgment vppCareerPageFramgment= new VPPCareerPageFramgment();
        VPPInHouseTeamFragment vppInHouseTeamFragment=new VPPInHouseTeamFragment();
        VPPRecommendedFragment vppRecommendedFragment= new VPPRecommendedFragment();
        VPPReferralFragment vppReferralFragment= new VPPReferralFragment();
        adapter.addFragment(vppActiveProfilesFragment,"Active Profiles");
        adapter.addFragment(vppInHouseTeamFragment,null);
        adapter.addFragment(vppCareerPageFramgment,null);
        adapter.addFragment(vppReferralFragment,null);
        adapter.addFragment(vppRecommendedFragment,null);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).setIcon(R.drawable.inhouse_team_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.career_page_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.referral_icon);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_drives);
    }

}
