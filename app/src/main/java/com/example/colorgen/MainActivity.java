package com.example.colorgen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    Button button;
    ViewGroup backgroundGroup;
    TextView titleColorText;
    TextView bodyColorText;

    MemoryPolicy memoryPolicy;
    NetworkPolicy networkPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View titleView = getWindow().findViewById(android.R.id.title);
        if (titleView != null) {
            ViewParent parent = titleView.getParent();
            if (parent != null && (parent instanceof View)) {
                View parentView = (View)parent;
                parentView.setBackgroundColor(Color.RED);
            }
        }



        button = findViewById(R.id.button);

        final ImageView imageView =
                (ImageView) findViewById(R.id.main_image);

        backgroundGroup =
                (ViewGroup) findViewById(R.id.main_background);


       titleColorText =
                (TextView) findViewById(R.id.main_title_text);

        bodyColorText =
                (TextView) findViewById(R.id.main_body_text);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Picasso.get().load("https://source.unsplash.com/random".toString()) .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                        .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE).into(imageView,
                        PicassoPalette.with("https://source.unsplash.com/random".toString(), imageView)
                                .use(PicassoPalette.Profile.MUTED_DARK)
                                .intoBackground(backgroundGroup, PicassoPalette.Swatch.RGB)
                                .use(PicassoPalette.Profile.MUTED_DARK)
                                .intoBackground(backgroundGroup, PicassoPalette.Swatch.RGB)
                                .intoTextColor(bodyColorText, PicassoPalette.Swatch.BODY_TEXT_COLOR)
                                .intoTextColor(titleColorText, PicassoPalette.Swatch.TITLE_TEXT_COLOR)

                );
            }
        });
    }
}



