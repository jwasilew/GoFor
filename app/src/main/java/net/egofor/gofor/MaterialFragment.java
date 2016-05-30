package net.egofor.gofor;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MaterialFragment extends Fragment {
    private static final String LOG_TAG = MaterialFragment.class.getSimpleName();

    private MaterialInterface materialInterface;
    GridView gridview;
    ResponseBushings responseObj;
    MaterialGridViewAdapter adapter;
    Gson gson;
    AsyncHttpClient client;

    public interface MaterialInterface {
        //  This is where we are declaring the name of the method to be used in the interface
        void showMaterialDetail(Intent intent);

    }

    public MaterialFragment() {
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        updateMovies();

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        gridview = (GridView) rootView.findViewById(R.id.gridview_material);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //  Setting item variable to position within inner class ResultsEntity in ResponseBushings class
                //  This puts all the data at each position in one variable  to package and send and Intent
                ResponseBushings.ResultsEntity item = (ResponseBushings.ResultsEntity) adapter.getItem(position);

                String thumbnail = item.get_thumbnail();
                String description = item.get_short_description();
                String upc = item.get_upc();
                String mfg = item.get_mfg();
                String mfgPart = item.get_mfg_part_number();
                String tradeSize = item.get_trade_size();
                String application = item.get_application();
                String material = item.get_material();
                String insulated = item.get_insulated();

                Intent i = new Intent(getActivity(), MaterialDetailActivity.class);
                i.putExtra("thumbnail", String.valueOf(thumbnail));
                i.putExtra("description", String.valueOf(description));
                i.putExtra("upc", String.valueOf(upc));
                i.putExtra("mfg", String.valueOf(mfg));
                i.putExtra("mfg_part", String.valueOf(mfgPart));
                i.putExtra("trade_size", String.valueOf(tradeSize));
                i.putExtra("application", String.valueOf(application));
                i.putExtra("material", String.valueOf(material));
                i.putExtra("insulated", String.valueOf(insulated));

                //  Using an interface to determine what layout is present within MainActivity
                materialInterface.showMaterialDetail(i);

                String toast = "Thumbnail: " + thumbnail + "\n" +
                        "Description: " + description + "\n" +
                        "UPC: " + upc + "\n" +
                        "Mfg: " + mfg + "\n" +
                        "Mfg Part#: " + mfgPart + "\n" +
                        "Trade Size: " + tradeSize + "\n" +
                        "Application: " + application + "\n" +
                        "Material: " + material + "\n" +
                        "Insulated: " + insulated + "\n";

//                Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity().getIntent().getExtras() == null) return;
        updateMovies();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void updateMovies() {
        parseJson();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //  If context has a MaterialInterface
        if (context instanceof MaterialInterface) {
            //  Set member variable to MaterialInterface of the context
            materialInterface = (MaterialInterface) context;
            //  This .showMaterialDetail is defined in MainActivity

        } else {
            throw new Error("Needs to implement MovieInterface");
        }
    }


    public String builtURL() {

        String MATERIAL_BASE_URL = "https://api.myjson.com/bins/3nqyk";

        Log.d(LOG_TAG, MATERIAL_BASE_URL);
        return MATERIAL_BASE_URL;

    }

    public void parseJson() {

        client = new AsyncHttpClient();
        client.get(getActivity(), builtURL(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String responseStr = new String(responseBody);

                Log.d("Response String", responseStr);
                gson = new Gson();
                responseObj = gson.fromJson(responseStr, ResponseBushings.class);
                adapter = new MaterialGridViewAdapter(getActivity(), responseObj.getResults());
                gridview.setAdapter(adapter);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

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
