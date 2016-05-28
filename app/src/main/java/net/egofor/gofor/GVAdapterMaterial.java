package net.egofor.gofor;

import android.content.Context;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by T510 Owner on 5/27/2016.
 */
public class GVAdapterMaterial extends BaseAdapter {

    private List<ResponseBushings.materialEntity> mMaterialitem;
    private Context mContext;


    public GVAdapterMaterial(Context mContext, List<ResponseBushings.materialEntity> mMaterialitem) {
        this.mContext = mContext;
        this.mMaterialitem = mMaterialitem;
    }

    @Override
    public int getCount() {
        return mMaterialitem.size();
    }

    @Override
    public Object getItem(int position) {
        return mMaterialitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.material_item, parent, false);
        ResponseBushings.materialEntity item = (ResponseBushings.materialEntity) getItem(position);

        ImageView thumbnail = (ImageView) rowView.findViewById(R.id.material_image);

        String imageUrl = item.getFIELD18();

        Picasso.with(mContext)
                .load(imageUrl)
                .resize(185, 256)
                .centerInside()
                .placeholder(R.drawable.noimage)
                .into(thumbnail);
        return rowView;
    }
}
