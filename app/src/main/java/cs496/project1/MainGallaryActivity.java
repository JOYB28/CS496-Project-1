package cs496.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import static cs496.project1.R.id.container;

public class MainGallaryActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_gallary);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add( R.id.fragment_place, fragment );
        fragmentTransaction.commit();
        */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_gallary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_gallary, container, false);

            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            return rootView;
        }

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
            // Return a PlaceholderFragment (defined as a static inner class below).
            //아래 코드 주석 처리
            //return PlaceholderFragment.newInstance(position + 1);

            //below with the page number as its lone argument
            Fragment fragment = null;
            Bundle args = null;
            switch (position){
                case 0:
                    fragment = new SectionsFragment1();
                    args = new Bundle();
                    break;
                case 1:
                    fragment = new SectionsFragment2();
                    args = new Bundle();
                    break;
                case 2:
                    fragment = new SectionsFragment3();
                    args = new Bundle();

            }
            return fragment;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "NA & SA";
                case 1:
                    return "EU & AF";
                case 2:
                    return "AS & OC";
            }
            return null;
        }
    }

    public static class SectionsFragment1 extends Fragment {

        public SectionsFragment1() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.frag_1_na_sa, container, false);

            ImageButton button1 = (ImageButton) rootView.findViewById(R.id.button_na);

            button1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getActivity(), Activity_gallary_na.class);
                    startActivity(intent);
                }
            });

            ImageButton button2 = (ImageButton) rootView.findViewById(R.id.button_sa);

            button2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent2 = new Intent(getActivity(), Activity_gallary_sa.class);
                    startActivity(intent2);
                }
            });

            return rootView;
        }
    }

    public static class SectionsFragment2 extends Fragment {

        public SectionsFragment2() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_2_eu_af, container, false);

            ImageButton button3 = (ImageButton) rootView.findViewById(R.id.button_eu);

            button3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getActivity(), Activity_gallary_eu.class);
                    startActivity(intent);
                }
            });

            ImageButton button4 = (ImageButton) rootView.findViewById(R.id.button_af);

            button4.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getActivity(), Activity_gallary_af.class);
                    startActivity(intent);
                }
            });

            return rootView;
        }
    }
    public static class SectionsFragment3 extends Fragment {

        public SectionsFragment3() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frag_3_as_oc, container, false);

            ImageButton button5 = (ImageButton) rootView.findViewById(R.id.button_as);

            button5.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getActivity(), Activity_gallary_as.class);
                    startActivity(intent);
                }
            });

            ImageButton button6 = (ImageButton) rootView.findViewById(R.id.button_oc);

            button6.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getActivity(), Activity_gallary_oc.class);
                    startActivity(intent);
                }
            });

            return rootView;
        }
    }/*
    public static class SectionsFragment_na extends Fragment {

        public SectionsFragment_na() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_gallary, container, false);

            GridView gridView;
            CityAdapter citiesAdapter;

            citiesAdapter = new CityAdapter();     // this.cities

            gridView = (GridView) rootView.findViewById(R.id.gridview);
            gridView.setAdapter(citiesAdapter);

            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.amsterdam), "AMSTERDAM");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.beijing), "BEIJING");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.istanbul), "ISTANBUL");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.london), "LONDON");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.newyork), "NEW YORK");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.paris), "PARIS");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.praha), "PRAHA");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.rome), "ROME");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.seoul), "SEOUL");
            citiesAdapter.addItem(ContextCompat.getDrawable(rootView.getContext(), R.drawable.tokyo), "TOKYO");

            return rootView;
        }
    }
    */


}
