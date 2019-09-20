package divij.com.unihyr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import divij.com.unihyr.Adapters.ViewPositionsAdapter;

public class ViewPositions extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_positions);
        toolbar=findViewById(R.id.viewPositionsToolbar);
        viewPager=findViewById(R.id.viewPAgerViewPositions);
        tabLayout=findViewById(R.id.tabLayoutViewPositions);
        viewPager.setAdapter(new ViewPositionsAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tabLayout.getTabAt(0).setText("profiles");
        tabLayout.getTabAt(1).setText("to do's");
        tabLayout.getTabAt(2).setText("team");
        tabLayout.getTabAt(3).setText("drives");
    }
}
