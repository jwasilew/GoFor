package net.egofor.gofor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private final String DETAILFRAGMENT_TAG = "DFTAG";
    private boolean mTwoPane = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Here is where the initial view is set
        setContentView(R.layout.activity_main);

        // The detail container view will be present only in the large-screen layouts
        // (res/layout-sw600dp)
        //  If a large screen layout is present, then the activity should be in two-pane mode
        if (findViewById(R.id.item_detail_container) != null) {

            mTwoPane = true;

            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.item_detail_container, new GridFragment(), DETAILFRAGMENT_TAG)
                        .commit();
            }
        } else {
            mTwoPane = false;
            getSupportActionBar().setElevation(0f);
        }


    }
}
