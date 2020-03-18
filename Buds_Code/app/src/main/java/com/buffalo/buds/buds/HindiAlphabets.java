package com.buffalo.buds.buds;

import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.media.MediaPlayer;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HindiAlphabets extends AppCompatActivity {

    static MediaPlayer mp;
    static int[] imgHindiAlphaList;
    static  int[] soundHindiAlphaList;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hindi_alphabets);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


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
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_hindi_alphabets, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            ImageView hindiAlphaDisplay = rootView.findViewById(R.id.hindiAlphabetDisplay);
            Button playHindiAlpha = rootView.findViewById(R.id.playHindiAlphabet);

            imgHindiAlphaList = new int[]{R.drawable.aa,R.drawable.aaaa,R.drawable.ee,R.drawable.eeee,
                    R.drawable.oo,R.drawable.oooo,R.drawable.ri,R.drawable.ae,R.drawable.aiee,
                    R.drawable.ao,R.drawable.aaou,R.drawable.anga,R.drawable.ahhh,R.drawable.ka,
                    R.drawable.kha,R.drawable.ga,R.drawable.gha,R.drawable.angah,R.drawable.cha,
                    R.drawable.chah,R.drawable.ja,R.drawable.jha,R.drawable.eeyan,R.drawable.ta,
                    R.drawable.dah,R.drawable.dha,R.drawable.tdha,R.drawable.dna,R.drawable.tta,
                    R.drawable.tha,R.drawable.da,R.drawable.ddha,R.drawable.na,R.drawable.pa,
                    R.drawable.fa,R.drawable.ba,R.drawable.bha,R.drawable.ma,R.drawable.ya,R.drawable.ra,
                    R.drawable.la,R.drawable.va,R.drawable.sha,R.drawable.ssha,R.drawable.sa,R.drawable.ha,
                    R.drawable.ksha,R.drawable.tra,R.drawable.gya};

            soundHindiAlphaList= new int[]{R.raw.aa,R.raw.aaaa,R.raw.ee,R.raw.eeee,
                    R.raw.oo,R.raw.oooo,R.raw.ri,R.raw.ae,R.raw.aiee,
                    R.raw.ao,R.raw.aaou,R.raw.anga,R.raw.ahhh,R.raw.ka,
                    R.raw.kha,R.raw.ga,R.raw.gha,R.raw.angah,R.raw.cha,
                    R.raw.chah,R.raw.ja,R.raw.jha,R.raw.eeyan,R.raw.ta,
                    R.raw.dah,R.raw.dha,R.raw.tdha,R.raw.dna,R.raw.tta,
                    R.raw.tha,R.raw.da,R.raw.ddha,R.raw.na,R.raw.pa,
                    R.raw.fa,R.raw.ba,R.raw.bha,R.raw.ma,R.raw.ya,R.raw.ra,
                    R.raw.la,R.raw.va,R.raw.sha,R.raw.ssha,R.raw.sa,R.raw.ha,
                    R.raw.ksha,R.raw.tra,R.raw.gya};

            hindiAlphaDisplay.setImageResource(imgHindiAlphaList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
            playHindiAlpha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mp != null)
                        mp.reset();
                    mp = MediaPlayer.create(getActivity(),soundHindiAlphaList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
                    mp.start();
                }
            });
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
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 49 total pages.
            return 49;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mp!=null)
        mp.reset();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}
