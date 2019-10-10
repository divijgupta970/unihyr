package divij.com.unihyr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import divij.com.unihyr.Adapters.NonScrollableVP;
import divij.com.unihyr.Adapters.ViewPositionsAdapter;

public class ViewPositions extends AppCompatActivity {
    private Toolbar toolbar;
    private NonScrollableVP viewPager;
    private TabLayout tabLayout;
    private JSONObject jsonObject;//old json
    public static String postId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_positions);
        toolbar=findViewById(R.id.viewPositionsToolbar);
        viewPager=findViewById(R.id.viewPAgerViewPositions);
        tabLayout=findViewById(R.id.tabLayoutViewPositions);
        Intent intent=getIntent();
        String json=intent.getStringExtra("json object");
        try {
            jsonObject=new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            toolbar.setTitle(jsonObject.getString("title"));
            postId=jsonObject.getString("postId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUpViewPager();
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public void setUpViewPager(){
        VIewPositionsProfilesFragment vIewPositionsProfilesFragment=new VIewPositionsProfilesFragment();
        ViewPositionsToDoFragment viewPositionsToDoFragment=new ViewPositionsToDoFragment();
        ViewPositionsTeamFragment viewPositionsTeamFragment=new ViewPositionsTeamFragment();
        ViewPositionsDrivesFragment viewPositionsDrivesFragment=new ViewPositionsDrivesFragment();
        ViewPositionsAdapter viewPositionsAdapter=new ViewPositionsAdapter(getSupportFragmentManager());
        viewPositionsAdapter.addFragment(vIewPositionsProfilesFragment,"Profiles");
        viewPositionsAdapter.addFragment(viewPositionsToDoFragment,"To do's");
        viewPositionsAdapter.addFragment(viewPositionsTeamFragment,"Team");
        viewPositionsAdapter.addFragment(viewPositionsDrivesFragment,"Drives");
        viewPager.setAdapter(viewPositionsAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_positions_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_moreinfo){
            //TODO: Add more info code here
        }
        else if(item.getItemId()==R.id.action_edit){
            //TODO: Add edit code here
        }
        return super.onOptionsItemSelected(item);
    }
}
