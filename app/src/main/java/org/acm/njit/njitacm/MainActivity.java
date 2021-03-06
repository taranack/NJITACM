package org.acm.njit.njitacm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_tutoring:
                    return nextFragment(new TutoringFragment());
                case R.id.navigation_sigs:
                    return nextFragment(new SIGFragment());
                case R.id.navigation_home:
                    return nextFragment(new HomeFragment());
                case R.id.navigation_social_media:
                    return nextFragment(new SocialMediaFragment());
                case R.id.navigation_contact_us:
                    return nextFragment(new ContactUsFragment());
            }

            return false;
        }
    };


    private boolean nextFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // Create a new Fragment to be placed in the activity layout
        HomeFragment firstFragment = new HomeFragment();

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, firstFragment).commit();


        navigation.setSelectedItemId(R.id.navigation_home);

        final String PREFS_NAME = "Prefs";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("first_time", true)) {
            //the app is being launched for first time
            Toast toast = Toast.makeText(this, "Check out our features down here!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("first_time", false).commit();
        }


    }

}
