package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int images[] = new int[]{
            R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image2
    };



    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer timer = new Timer();
                ChangeWallpaper changeWallpaper = new ChangeWallpaper();

                if(!changeWallpaper.hasRunStarted()){
//                  ------ not required in exam can run this 'timer.sch...' outside 'if' condition ------
                    timer.schedule(changeWallpaper, 0, 1000);
                    Toast.makeText(MainActivity.this, "started", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    class ChangeWallpaper extends TimerTask{



//        ----- this function is continuosly called in the schedules time interval -----
        @Override
        public void run() {

            hasStarted = true;

            if(i==9){
                i=0;
            }
            i++;

            WallpaperManager  wallpaperManager = WallpaperManager.getInstance(getBaseContext());
            try {
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), images[i]));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        ------ not required this part in exam ------
        private boolean hasStarted = false;

        public boolean hasRunStarted(){
            return hasStarted;
        }

    }
}