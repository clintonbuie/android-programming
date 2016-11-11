package bignerdranch.android.photogallery;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by clintonbuie on 11/10/16.
 */
public class PicassoBigCache {

    private Picasso PICASSO_INSTANCE;

    public PicassoBigCache(Context context) {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        PICASSO_INSTANCE = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(client))
                .build();
    }

}
