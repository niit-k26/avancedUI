package vn.com.demobroadcast.avancedui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShowMenu;
    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment fragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.hello_blank_fragment,
                R.string.app_name);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragment = MainFragment.newInstance(fragmentManager);
        fragmentManager.beginTransaction().replace(R.id.main_container,fragment).commit();

        NavigationView navView = (NavigationView)findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.id_tab:
                        fragment = MainFragment.newInstance(fragmentManager);
                        break;

                    case R.id.id_about:
                        fragment=FragmentAbout.newInstance();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.main_container,fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

//popup Menu
    void showPopUpMenu(View v){
        PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
        // getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
        popupMenu.inflate(R.menu.menu_main);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                menuItem.getItemId();
                return false;
            }
        });
    }

    //option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_share:
                Toast.makeText(getBaseContext(),"Share",Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_add:
                Toast.makeText(getBaseContext(),"Add",Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_rename:
                Toast.makeText(getBaseContext(),"Rename",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_share:
                Toast.makeText(getBaseContext(),"Share",Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_add:
                Toast.makeText(getBaseContext(),"Add",Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_rename:
                Toast.makeText(getBaseContext(),"Rename",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}
