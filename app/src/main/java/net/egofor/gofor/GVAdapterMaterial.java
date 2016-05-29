package net.egofor.gofor;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cz.msebera.android.httpclient.client.methods.RequestBuilder;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by T510 Owner on 5/27/2016.
 */
public class GVAdapterMaterial extends BaseAdapter {

    private List<ResponseBushings.ResultsEntity> mMaterialitem;
    private Context mContext;



    public GVAdapterMaterial(Context mContext, List<ResponseBushings.ResultsEntity> mMaterialitem) {
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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.material_item, parent, false);
        ResponseBushings.ResultsEntity item = (ResponseBushings.ResultsEntity) getItem(position);

        final ImageView thumbnail = (ImageView) rowView.findViewById(R.id.material_image);
        thumbnail.getMaxHeight();
        thumbnail.getMaxWidth();

        final String url = item.get_thumbnail();

        final File cacheDir = StorageUtils.getCacheDirectory(rowView.getContext());

        final ImageLoader imageLoader = ImageLoader.getInstance();

        if (!imageLoader.isInited()) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(rowView.getContext()));
        }


        final ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(rowView.getContext())
                .memoryCacheSize(41943040)
                .threadPoolSize(10)
                .writeDebugLogs()
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .build();

        imageLoader.init(config);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.noimage)
//                .cacheInMemory()
//                .cacheOnDisk(true)
                .displayer(new FadeInBitmapDisplayer(200))
                .build();

        MemoryCacheUtils.findCachedBitmapsForImageUri(url, ImageLoader.getInstance().getMemoryCache());


imageLoader.displayImage(url, thumbnail, defaultOptions, new ImageLoadingListener() {
    @Override
    public void onLoadingStarted(String imageUri, View view) {

    }

    @Override
    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

    }

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

    }

    @Override
    public void onLoadingCancelled(String imageUri, View view) {

    }
});




//        Picasso.Builder picassoBuilder = new Picasso.Builder(mContext);
//
//        picassoBuilder.downloader(new OkHttpDownloader(UnsafeOkHttpClient.getUnsafeOkHttpClient()));
//
//        Picasso picasso = picassoBuilder.build();
//        picasso.setIndicatorsEnabled(true);
//
//
//        picasso
//                .load(url).resize(185, 185).into(thumbnail);






//  This is the standard method for caching images decided to go with bitmaps sell below Glide Method call
//        Glide.with(mContext)
//                .load(url)
//                .override(185, 185)
//                .diskCacheStrategy( DiskCacheStrategy.ALL )
//                .centerCrop()
//                .placeholder(R.drawable.noimage)
//                .crossFade()
//                .into(thumbnail);





//        Picasso
//                .with(mContext)
//                .setIndicatorsEnabled(true);
//        Picasso
//                .with(mContext)
//                .load(url)
//                .centerCrop()
//                .placeholder(R.drawable.noimage)
//                .fit()
//                .into(thumbnail);


        return rowView;
    }


}
