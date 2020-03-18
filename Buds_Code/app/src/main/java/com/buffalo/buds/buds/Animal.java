package com.buffalo.buds.buds;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.media.MediaPlayer;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Animal extends Activity {

    static MediaPlayer mp,playSound;
    static int soundAnimalList[];
    static int imgAnimalList[];
    static int animalSoundList[];

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
        setContentView(R.layout.activity_animal);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal, menu);
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
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_animal, container, false);

            ImageView animalView = rootView.findViewById(R.id.AnimalDisplay);
            Button playAnimalpronounciation = rootView.findViewById(R.id.playAnimal);

            imgAnimalList = new int[]{R.drawable.cat,R.drawable.cow,R.drawable.dog,R.drawable.elephant,R.drawable.horse,
                    R.drawable.kangroo,R.drawable.lion,R.drawable.monkey,R.drawable.panda,R.drawable.rabbit,R.drawable.tiger,
                    R.drawable.zebra};

            soundAnimalList = new int[]{R.raw.cat,R.raw.cow,R.raw.dog,R.raw.elephant,R.raw.horse,
                    R.raw.kangaroo,R.raw.lion,R.raw.monkey,R.raw.panda,R.raw.rabbit,R.raw.tiger,
                    R.raw.zebra};

            animalSoundList = new int[]{R.raw.cat_sound,R.raw.cow_sound,R.raw.dog_sound,R.raw.elephant_sound,R.raw.horse_sound,
                    R.raw.kangaroo_sound,R.raw.lion_sound,R.raw.monkey_sound,R.raw.panda_sound,R.raw.rabbit_sound,R.raw.tiger_sound,
                    R.raw.zebra_sound};

            animalView.setImageResource(imgAnimalList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);

            playAnimalpronounciation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mp!= null)
                        mp.reset();
                    if(playSound!=null )
                        playSound.reset();
                    mp = MediaPlayer.create(getActivity(),soundAnimalList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
                    mp.start();
                }
            });

            animalView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(playSound!=null )
                        playSound.reset();
                    if(mp!= null)
                        mp.reset();
                    playSound = MediaPlayer.create(getActivity(),animalSoundList[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
                    playSound.start();

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
            // Show 12 total pages.
            return 12;
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
        if(playSound!=null )
            playSound.reset();
        if(mp!= null)
            mp.reset();

    }
}