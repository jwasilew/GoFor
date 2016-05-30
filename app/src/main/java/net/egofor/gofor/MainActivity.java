package net.egofor.gofor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MaterialFragment.MaterialInterface {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    public Toolbar toolbar;
    private final String DETAILFRAGMENT_TAG = "DFTAG";
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mTwoPane = findViewById(R.id.detail_container) != null;

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        DecideLayout();


        //  TODO  Move this code to gradle.properties to hide from java code let Android handle it secretly
//        String APP_ID = "5FDD3FE0-9CDD-C6C4-FFD8-87B570EA4500";
//        String SECRET_KEY = "10C95C8A-BED6-3238-FF26-7C3CF5AA2F00";
//        String appVersion = "v1";
//
//        //  Before the Java/Android client uses any of the APIs, the code must initialize the
//        //  Backendless Application using the following call
//        Backendless.initApp(this, APP_ID, SECRET_KEY, appVersion);


    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DecideLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DecideLayout();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        DecideLayout();
    }


    public void DecideLayout() {


        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new MaterialFragment()).commitAllowingStateLoss();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);

        //  Return true to display menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMaterialDetail(Intent intent) {

        if (mTwoPane) {

            //  If we're in two pane mode start the new instance of MovieDetailFragment with the
            // passed in Intent
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_container,
                    MaterialDetailFragment.newInstance(intent), DETAILFRAGMENT_TAG).commit();


        } else {

            startActivity(intent);
        }
    }
}
