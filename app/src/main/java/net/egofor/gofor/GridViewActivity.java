package net.egofor.gofor;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class GridViewActivity extends Fragment {
    private static final String TAG = GridViewActivity.class.getSimpleName();
    private GridView mGridView;
    private ProgressBar mProgressBar;
    //    private GridViewAdapter mGridAdapter;
    private ArrayList<GridItem> mGridData;
    AsyncHttpClient client;
    GridView gridview;
    ResponseBushings responseObj;
    GVAdapterMaterial adapter;
    Gson gson;
    String MATERIAL_BASE_URL = "https://api.myjson.com/bins/3nqyk";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.gridview_forecast);
        mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

        mGridData = new ArrayList<>();


        client = new AsyncHttpClient();
        mProgressBar.setVisibility(View.VISIBLE);
        client.get(getActivity(), builtURL(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                mProgressBar.setVisibility(View.GONE);
                String responseStr = new String(responseBody);
                parseResult(responseStr);
                Log.d("LOG_TAG", responseStr);

                gson = new Gson();
                responseObj = gson.fromJson(responseStr, ResponseBushings.class);


                adapter = new GVAdapterMaterial(getActivity(), responseObj.getResults());
                mGridView.setAdapter(adapter);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Toast.makeText(getActivity(), "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }


    /**
     * Parsing the feed results and get the list
     *
     * @param result
     */
    private void parseResult(String result) {


        GridItem item;
        item = new GridItem();
        mGridData.add(item);

    }

    public String builtURL() {

        String MATERIAL_BASE_URL = "https://api.myjson.com/bins/3nqyk";


        return MATERIAL_BASE_URL;

    }


}


//package net.egofor.gofor;
//
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.GridView;
//
//import com.google.gson.Gson;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//
//import cz.msebera.android.httpclient.Header;
//import com.loopj.android.http.*;
//
//
//public class GridFragment extends Fragment {
//
//
//    AsyncHttpClient client;
//    GridView gridview;
//    ResponseBushings responseObj;
//    GVAdapterMaterial adapter;
//    Gson gson;
//
//    private final String BUSHINGS = "bushings.json";
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        parseJson();
//        Log.d("BUILT_URL", builtURL());
//
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//
//        gridview = (GridView) rootView.findViewById(R.id.gridview_forecast);
//
//
//        return rootView;
//    }
//
//
//    // This method is used within the parseJson();
//    // Passes the built URL in for GSON library
//    public String builtURL() {
//
//        String MATERIAL_BASE_URL = "https://api.myjson.com/bins/3nqyk";
//
////        Uri.Builder builtUri = Uri.parse(MATERIAL_BASE_URL).buildUpon().appendPath(BUSHINGS);
//        // This is the built url for when the app calls on the server for the grid of movies
//
//        return MATERIAL_BASE_URL;
//
//    }
//
//
//
//
//
//    public void parseJson() {
//
//        client = new AsyncHttpClient();
//        client.get(getActivity(), builtURL(), new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//                String responseStr = new String(responseBody);
//
//                Log.d("Response String", responseStr);
//                gson = new Gson();
//                responseObj = gson.fromJson(responseStr, ResponseBushings.class);
//                adapter = new GVAdapterMaterial(getActivity(), responseObj.getResults());
//                gridview.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });
//
//    }
//
//
//}
