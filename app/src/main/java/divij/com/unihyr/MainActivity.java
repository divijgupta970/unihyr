package divij.com.unihyr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.mainToolbar);
        toolbar.setTitle("Dashboard");
        drawer = findViewById(R.id.drawerLayout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashboardFragment()).commit();
                toolbar.setTitle("Dashboard");
                break;
            case R.id.nav_positions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PositionsFragment()).commit();
                toolbar.setTitle("Positions");
                break;
            case R.id.nav_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CalendarFragment()).commit();
                toolbar.setTitle("Calendar");
                break;
            case R.id.nav_database:
                toolbar.setTitle("Database");
                break;
            case R.id.nav_offer:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new offer_fragment_nik()).commit();
                toolbar.setTitle("Offer Management");
                break;
            case R.id.nav_drive:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DrivesFragment()).commit();
                toolbar.setTitle("Drive Management");
                break;
            case R.id.nav_users:
                toolbar.setTitle("Users");
                break;
            case R.id.nav_logout:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
