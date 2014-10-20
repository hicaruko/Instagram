package com.jakapong.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.jakapong.instagram.Entries.Event;
import com.jakapong.instagram.Entries.ProductEntry;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class MyActivity extends Activity implements ModelStatusListener {
    Button btn_save;
    String type = "image/*";
    String filename = "/temp2.jpg";
    String mediaPath = Environment.getExternalStorageDirectory() + filename;
    String captionText = " #womenfashion #fashion #clothing #fashiontrend #bangkok #thailand #fashionintrend #thaistagram";
    DisplayImageOptions options;
    ImageLoader imageLoader;
    protected GridView gridView;

    private ProductLoader productLoader;
    private EventLoader eventLoader;

    private ArrayList<ProductEntry> arrItems = new ArrayList<ProductEntry>();

    private ArrayList<Event> arrEvent = new ArrayList<Event>();


    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

//        productLoader = new ProductLoader(MyActivity.this);
//        productLoader.setModelStatusListener(this);
//        productLoader.load();


        eventLoader = new EventLoader(MyActivity.this);
        eventLoader.setModelStatusListener(this);
        eventLoader.load();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Instagram", null);
        return Uri.parse(path);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void createInstagramIntent(String type,Uri uri, String caption) throws URISyntaxException {

        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);

        // Set the MIME type
        share.setType(type);
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.putExtra(Intent.EXTRA_TEXT, caption);

        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));

    }

    @Override
    public void onLoadDataSuccess(String key, Object ts) {

        arrEvent.addAll((ArrayList<Event>) ts);

        Log.e("arrItems",""+arrEvent.size());
        Log.e("arrItems",""+arrEvent.get(0).getName().toString());
        Log.e("arrItems",""+arrEvent.get(0).getGeography().getName());
        Log.e("arrItems",""+arrEvent.get(0).getUser().getEmail());




//        arrItems.addAll((ArrayList<ProductEntry>) ts);
 //        gridView = (GridView) findViewById(R.id.gridView);
//         gridView.setAdapter(new ImagesAdapter(getApplicationContext(),arrItems));
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, final int position, long id) {
//
//                imageLoader.getInstance().loadImage(arrItems.get(position).getImage(), new SimpleImageLoadingListener() {
//                    @Override
//                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                        // Do whatever you want with Bitmap
//                        try {
//                            createInstagramIntent(type, getImageUri(getApplicationContext(),loadedImage) , "Name:\n"+arrItems.get(position).getName()+"\n"+"Detail:\n"+arrItems.get(position).getDescription()+"\nPrice:\n"+arrItems.get(position).getPrice()+" ฿"+"\n\n"+"Popsud.com : #popsud "+ arrItems.get(position).getTag()+" "+arrItems.get(position).getMytag());
//                        } catch (URISyntaxException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                Log.e("onLoadDataSuccess", "onLoadDataSuccess: " + arrItems.get(position).getImage());
//            }
//        });
//        Log.e("onLoadDataSuccess", "onLoadDataSuccess: " + ts);
//        Log.e("onLoadDataSuccess", "onLoadDataSuccess: " + key);
    }

    @Override
    public void onLoadDataFailed(String key) {
        Log.e("onLoadDataFailed", "onLoadDataFailed: " + key);

    }


}
