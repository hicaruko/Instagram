package com.jakapong.instagram;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakapong.instagram.Entries.ProductEntry;
import com.jakapong.instagram.Entries.Training;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

/**
 * Created by Nemu on 1/17/14.
 */
public class Image2Adapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Training>  listData;
    private LayoutInflater layoutInflater;
    private DisplayImageOptions options;
    // Constructor
    public Image2Adapter(Context c, ArrayList<Training> listData){
        mContext = c;
        layoutInflater = LayoutInflater.from(c);
        this.listData = listData;
        options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(100))
                .build();
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list1_item, null);
            holder = new ViewHolder();
            holder.imageView=(ImageView)convertView.findViewById(R.id.imageView);
            holder.textView=(TextView)convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        WindowManager wm = (WindowManager)this.mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        holder.imageView.setLayoutParams(new RelativeLayout.LayoutParams((width/2), (width/2)));

//        ImageLoader.getInstance().displayImage(listData.get(position).getImage(),holder.imageView, options, new ImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String s, View view) {
//
//            }
//
//            @Override
//            public void onLoadingFailed(String s, View view, FailReason failReason) {
//
//
//            }
//
//            @Override
//            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
//
//            }
//
//            @Override
//            public void onLoadingCancelled(String s, View view) {
//
//            }
//        });



        holder.textView.setText(listData.get(position).getTitle());

        return convertView;
    }



    static class ViewHolder {

        ImageView imageView;
        TextView textView;
    }
}
