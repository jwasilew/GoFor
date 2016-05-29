package net.egofor.gofor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.backendless.Backendless;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private final String DETAILFRAGMENT_TAG = "DFTAG";
    private boolean mTwoPane = true;

    private final String IMAGE_BASE_PATH = "https://api.backendless.com/5FDD3FE0-9CDD-C6C4-FFD8-87B570EA4500/v1/files/media/";
    private final String IMAGE_JPEG_EXT = ".jpg";

    public Toolbar toolbar;

    @Override
    protected void onDestroy() {
        ImageLoader.getInstance().destroy();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
//                .cacheInMemory(true)
//                .cacheOnDisk(true).build();
//
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
//                .defaultDisplayImageOptions(defaultOptions)
//                .build();
//        ImageLoader.getInstance().init(config);


        //  Here is where the initial view is set
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //  TODO  Move this code to gradle.properties to hide from java code let Android handle it secretly
        String APP_ID = "5FDD3FE0-9CDD-C6C4-FFD8-87B570EA4500";
        String SECRET_KEY = "10C95C8A-BED6-3238-FF26-7C3CF5AA2F00";
        String appVersion = "v1";

        //  Before the Java/Android client uses any of the APIs, the code must initialize the
        //  Backendless Application using the following call
        Backendless.initApp(this, APP_ID, SECRET_KEY, appVersion);


        //  This is basic user login functionality for backendless.com
//        BackendlessUser user = new BackendlessUser();
//        user.setEmail("chrisparis82@gmail.com");
//        user.setPassword("Hotshot02");
//
//        Backendless.UserService.register(user, new BackendlessCallback<BackendlessUser>() {
//            @Override
//            public void handleResponse(BackendlessUser response) {
//                Log.i("Registration", response.getEmail() + " successfully registered");
//            }
//        });

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
                        .replace(R.id.item_detail_container, new DetailFragment(), DETAILFRAGMENT_TAG)
                        .commit();
            }
        } else {
            mTwoPane = false;
            getSupportActionBar().setElevation(0f);
        }




    }
}
