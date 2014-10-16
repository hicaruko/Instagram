package com.jakapong.instagram;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;


public class MyActivity extends ActionBarActivity implements View.OnClickListener {
    Button btn_save;
    String type = "image/*";
    String filename = "/temp2.jpg";
    String mediaPath = Environment.getExternalStorageDirectory() + filename;
    String captionText = "testtest";
    DisplayImageOptions options;

    ImageLoader imageLoader ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        btn_save = (Button) findViewById(R.id.button);
        btn_save.setOnClickListener(this);
        File paths = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Log.e("ExternalStorage", "-> paths=" + paths);

        imageLoader.getInstance().loadImage("http://popsud.com/70-large_default/monroe-crimson-maxi-dress.jpg", new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                // Do whatever you want with Bitmap
                Log.e("ImageManager", "Error: " + imageUri);

                try {
                    createInstagramIntent(type, getImageUri(getApplicationContext(),loadedImage) , captionText);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

            }
        });

//        MyAsnyc ss = new MyAsnyc();
//        ss.onPostExecute();
    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Instagram", null);
        return Uri.parse(path);
    }
    @Override
    public void onClick(View v) {
        if (v == btn_save){
            try {
                Uri uri = Uri.parse("http://popsud.com/70-large_default/monroe-crimson-maxi-dress.jpg");
                createInstagramIntent(type, uri, captionText);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return;
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



        // Create the URI from the media
//        File media = new File(mediaPath);
//        Uri uri = Uri.fromFile(media);

        //URI uri = new URI("http://popsud.com/70-large_default/monroe-crimson-maxi-dress.jpg");
        // Add the URI and the caption to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.putExtra(Intent.EXTRA_TEXT, caption);

        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));
        
    }

    public class MyAsnyc extends AsyncTask<Void, Void, Void> {
        public  File file;
        InputStream is;

        protected void doInBackground() throws IOException {


            File path = Environment.getExternalStorageDirectory();
            file = new File(path, "DemoPicture.jpg");
            try {
                // Make sure the Pictures directory exists.
                path.mkdirs();
                URL url = new URL("http://popsud.com/70-large_default/monroe-crimson-maxi-dress.jpg");
            /* Open a connection to that URL. */
                URLConnection ucon = url.openConnection();

            /*
             * Define InputStreams to read from the URLConnection.
             */
                is = ucon.getInputStream();

                OutputStream os = new FileOutputStream(file);
                byte[] data = new byte[is.available()];
                is.read(data);
                os.write(data);
                is.close();
                os.close();

            } catch (IOException e) {
                Log.d("ImageManager", "Error: " + e);
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            try {
                doInBackground();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute() {
            // Tell the media scanner about the new file so that it is
            // immediately available to the user.
//            MediaScannerConnection.scanFile(null,
//                    new String[]{file.toString()}, null,
//                    new MediaScannerConnection.OnScanCompletedListener() {
//                        public void onScanCompleted(String path, Uri uri) {
//                            Log.i("ExternalStorage", "Scanned " + path + ":");
//                            Log.i("ExternalStorage", "-> uri=" + uri);
//
//
////                            try {
////                                createInstagramIntent(type, path, captionText);
////                            } catch (URISyntaxException e) {
////                                e.printStackTrace();
////                            }
//
//                        }
//                    });

        }
    }

}
