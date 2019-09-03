package com.example.colorgen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    int code;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        final ImageView imageView =
                (ImageView) findViewById(R.id.main_image);

        final ViewGroup backgroundGroup =
                (ViewGroup) findViewById(R.id.main_background);


        final TextView titleColorText =
                (TextView) findViewById(R.id.main_title_text);

        final TextView bodyColorText =
                (TextView) findViewById(R.id.main_body_text);
        int i = 0;




            Picasso.get().load("https://source.unsplash.com/random").into(new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    imageView.setImageBitmap(bitmap);
                    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(@Nullable Palette palette) {
                            Palette.Swatch textSwatch = palette.getDarkMutedSwatch();
                            int i = textSwatch.getRgb();

                            backgroundGroup.setBackgroundColor(textSwatch.getRgb());
                            titleColorText.setTextColor(textSwatch.getTitleTextColor());
                            bodyColorText.setTextColor(textSwatch.getBodyTextColor());

                            getWindow().setStatusBarColor(textSwatch.getTitleTextColor());


                            Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                            Log.e("Color", "" + i);

                            i++;
                        }
                    });
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {




                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Picasso.get().load("https://source.unsplash.com/random").into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        imageView.setImageBitmap(bitmap);
                        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(@Nullable Palette palette) {
                                Palette.Swatch textSwatch = palette.getDarkMutedSwatch();
                                int i = textSwatch.getRgb();

                                backgroundGroup.setBackgroundColor(textSwatch.getRgb());
                                titleColorText.setTextColor(textSwatch.getTitleTextColor());
                                bodyColorText.setTextColor(textSwatch.getBodyTextColor());

                                getWindow().setStatusBarColor(textSwatch.getTitleTextColor());

                                Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                                Log.e("Color", "" + i);
                            }
                        });
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
            }
        });


    }


}



