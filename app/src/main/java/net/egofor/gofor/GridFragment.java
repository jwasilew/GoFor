package net.egofor.gofor;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.commons.net.io.Util;

import cz.msebera.android.httpclient.Header;


public class GridFragment extends Fragment {


    AsyncHttpClient client;
    GridView gridview;
    ResponseBushings responseObj;
    GVAdapterMaterial adapter;
    Gson gson;

    private final String BUSHINGS = "bushings.txt";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        parseJson();
        Log.d("BUILT_URL", builtURL());

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        gridview = (GridView) rootView.findViewById(R.id.gridview_forecast);


        return rootView;
    }


    // This method is used within the parseJson();
    // Passes the built URL in for GSON library
    public String builtURL() {

        String MATERIAL_BASE_URL = "https://api.backendless.com/5FDD3FE0-9CDD-C6C4-FFD8-87B570EA4500/v1/files/Categories+JSON";

        Uri.Builder builtUri = Uri.parse(MATERIAL_BASE_URL).buildUpon().appendPath(BUSHINGS);
        // This is the built url for when the app calls on the server for the grid of movies
        return builtUri.toString();

    }


    public void parseJson() {

        client = new AsyncHttpClient();
        client.get(getActivity(), builtURL(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String responseStr = new String(responseBody);
                gson = new Gson();
                responseObj = gson.fromJson(responseStr, ResponseBushings.class);
                adapter = new GVAdapterMaterial(getActivity(), responseObj.getResults());
                gridview.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }


}
