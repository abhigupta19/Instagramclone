package com.example.user.instas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class Main3Activity extends AppCompatActivity {
ImageView i5,imag,i9;
Button b9;


    Intent cameraIntent,i6,i7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        
        cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        i5=(ImageView)findViewById(R.id.imageView5);
        i9=(ImageView)findViewById(R.id.imageView9);
        imag=(ImageView)findViewById(R.id.imageView7);

        i6=new Intent(this,MainActivity.class);


        i7=new Intent(this,Main4Activity.class);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(cameraIntent, 0);
            }
        });
        imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i7);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.log:
                newGame();
                return true;
                default:
                    return true;

        }
    }
    private void newGame()
    {
        startActivity(i6);
    }

}
