package com.example.anothertodoapp;

import java.util.Locale;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import controller.*;
import com.example.anothertodoapp.*;


public class MainActivity extends FragmentActivity {
	
	
		// ViewPager + Listview
	
		// Based on: http://stackoverflow.com/questions/18413309/how-to-implement-a-viewpager-with-different-fragments-layouts
		
		//http://howrobotswork.wordpress.com/2013/06/22/how-to-use-the-pagertabstrip-and-the-pagertitlestrip/
		//http://android-java-development.blogspot.pt/2012/05/system.html
	
	
	private static final int NUM_PAGES = 3;
	private static final String[] titles = {"S H A R E", "T O D O", "A R C H I V E"};

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    static ViewPager mViewPager;
    
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
     // HIDE ACTION BAR: 
        
        final android.app.ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayUseLogoEnabled(false);
		actionBar.hide();
		
        setContentView(R.layout.activity_main);
        
        
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);
        
    }

   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
        	switch(position) {
        	
        	case 0: return ShareActivityFragment.newInstance();
            case 1: return TodoActivityFragment.newInstance();
            case 2: return ArchiveActivityFragment.newInstance();
            default: return TodoActivityFragment.newInstance();
            }
			
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Sets the title string for each Fragment
            return String.valueOf(titles[position]);
           
        }
   
    }
    
    
    
    
	
    
    	
   

}
