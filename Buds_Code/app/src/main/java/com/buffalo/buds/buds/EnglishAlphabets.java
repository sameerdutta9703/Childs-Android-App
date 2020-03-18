package com.buffalo.buds.buds;


import android.app.Activity;

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

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public class EnglishAlphabets extends AppCompatActivity {

    static MediaPlayer mp;
    static int[] soundList;
    static int[] imgList;

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
        setContentView(R.layout.activity_english_alphabets);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mp = new MediaPlayer();
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
            View rootView = inflater.inflate(R.layout.fragment_english_alphabets, container, false);
            ImageView alphabetView= rootView.findViewById(R.id.EnglishAlphabetDisplay);
            Button playSound= rootView.findViewById(R.id.playAlphabet);

            imgList = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                    R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,
                    R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,
                    R.drawable.x,R.drawable.y,R.drawable.z};
            soundList = new int[]{R.raw.a,R.raw.b,R.raw.c,R.raw.d,R.raw.e,R.raw.f,R.raw.g,
                    R.raw.h,R.raw.i,R.raw.j,R.raw.k,R.raw.l,R.raw.m,R.raw.n,R.raw.o,
                    R.raw.p,R.raw.q,R.raw.r,R.raw.s,R.raw.t,R.raw.u,R.raw.v,R.raw.w,
                    R.raw.x,R.raw.y,R.raw.z};

            alphabetView.setImageResource(imgList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);

            playSound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(EnglishAlphabets.mp != null) {
                        EnglishAlphabets.mp.reset();
                        EnglishAlphabets.mp.release();
                    }
                    try {
                        EnglishAlphabets.mp = MediaPlayer.create(getActivity(), soundList[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
                        EnglishAlphabets.mp.prepare();
                        EnglishAlphabets.mp.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
            // Show 26 total pages.
            return 26;
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
        if (mp!= null)
            mp.reset();
    }
}