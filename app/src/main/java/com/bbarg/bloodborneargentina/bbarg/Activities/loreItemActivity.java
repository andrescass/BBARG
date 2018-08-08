package com.bbarg.bloodborneargentina.bbarg.Activities;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbarg.bloodborneargentina.bbarg.Models.LoreBodies;
import com.bbarg.bloodborneargentina.bbarg.Models.LoreModel;
import com.bbarg.bloodborneargentina.bbarg.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class loreItemActivity extends AppCompatActivity {

    int finalWidth;
    int imageWidth;
    int imageHeight;
    File image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lore_item);

        ImageView loreImage = findViewById(R.id.lore_act_image);
        TextView loreTitle = findViewById(R.id.lore_act_title);
        TextView loreBody = findViewById(R.id.lore_act_body);

        List<LoreModel> lores;
        lores = new ArrayList<LoreModel>();

        LoreBodies lorBod = new LoreBodies();

        LoreModel lore1 = new LoreModel(0, "Byrgemwerth", lorBod.getLore_1(), R.drawable.byrgenwerth);
        LoreModel lore2 = new LoreModel(1, "Iglesia de la Sanación", lorBod.getLore_2(), R.drawable.iglesia);

        lore1.setImageUri(resourceToUri(this, lore1.getImageRes()).getPath());
        lore2.setImageUri(resourceToUri(this, lore2.getImageRes()).getPath());

        lores.add(lore1);
        lores.add(lore2);

        Bundle loreBind = getIntent().getExtras();

        int loreIdx = loreBind.getInt("loreID");

        //loreImage.setImageResource(lores.get(loreIdx).getImageRes());
        loreTitle.setText(lores.get(loreIdx).getTitle());
        loreBody.setText(lores.get(loreIdx).getLoreBody());

        final BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(this.getResources() ,lores.get(loreIdx).getImageRes(), opt);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        imageWidth = opt.outWidth;
        imageHeight = opt.outHeight;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            finalWidth = size.x;
        } else {
            finalWidth = size.y;
        }
        int finalHeight = Math.round((float)finalWidth/imageWidth*imageHeight);
        loreImage.getLayoutParams().height = finalHeight;
        if(lores.get(loreIdx).getImageUri() != null) {
            image = new File(lores.get(loreIdx).getImageUri());
            Picasso.with(this).load(lores.get(loreIdx).getImageRes()).resize(finalWidth, finalHeight).centerCrop().into(loreImage);
        }
    }

    public static Uri resourceToUri(Context context, int resID) {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                context.getResources().getResourcePackageName(resID) + '/' +
                context.getResources().getResourceTypeName(resID) + '/' +
                context.getResources().getResourceEntryName(resID) );
    }
}
