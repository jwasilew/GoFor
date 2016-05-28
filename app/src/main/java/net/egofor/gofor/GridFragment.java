package net.egofor.gofor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class GridFragment extends Fragment {

    private ListView mListView;
    private int mPosition = ListView.INVALID_POSITION;
    private boolean mUseTodayLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }


    //  TODO  This is what we need to use to set the layout
//    public void setUseTodayLayout(boolean useTodayLayout) {
//        mUseTodayLayout = useTodayLayout;
//        if (mForecastAdapter != null) {
//            mForecastAdapter.setUseTodayLayout(mUseTodayLayout);
//        }
//    }
}
