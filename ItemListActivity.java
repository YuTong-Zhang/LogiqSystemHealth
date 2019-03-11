package com.example.ultrasound;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.ultrasound.items.ItemFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    private static final String[] SUMMARY_ITEMS = {"Immediate Action", "Action Suggested",
            "No Issues Found"};
    private static final String[] DISK_ITEMS = {"C: Drive", "E: Drive",
            "D: Drive", "V: Drive", "Z: Drive"};
    private static final String[] SYSTEM_ITEMS = {"Hardware Configuration", "Temperature",
            "Battery Status", "Voltage", "Bootup Issues", "Alert Logs", "USB Devices"};
    private static final String[] TITLES = {"SUMMARY", "SYSTEM STATUS", "DISK USAGE"};
    private static HashMap<String,String[]> TITLE_LIST_MAP = new HashMap<>();

    private static ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initialize_map();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        viewPager = findViewById(R.id.viewpager);
//        viewPager.setAdapter(new ItemFragmentPagerAdapter(getSupportFragmentManager()));
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Implementing tab selected listener over tablayout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());//setting current selected item over viewpager
                switch (tab.getPosition()) {
                    case 0:
                        Log.e("TAG","TAB1");
                        break;
                    case 1:
                        Log.e("TAG","TAB2");
                        break;
                    case 2:
                        Log.e("TAG","TAB3");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void initialize_map(){
        TITLE_LIST_MAP.put("SUMMARY", SUMMARY_ITEMS);
        TITLE_LIST_MAP.put("SYSTEM STATUS", SYSTEM_ITEMS);
        TITLE_LIST_MAP.put("DISK USAGE", DISK_ITEMS);
    }

    private void setupViewPager(ViewPager viewPager) {
        ItemFragmentPagerAdapter adapter = new ItemFragmentPagerAdapter(getSupportFragmentManager());
        for(String title:TITLES){
            adapter.addFragment(ItemListFragment.newInstance(TITLE_LIST_MAP.get(title)), title);
        }
        viewPager.setAdapter(adapter);
    }

}
