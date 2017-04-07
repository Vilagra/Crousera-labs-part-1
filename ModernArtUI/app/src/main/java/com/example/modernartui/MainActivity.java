package com.example.modernartui;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView im1;
    ImageView im2;
    ImageView im3;
    ImageView im4;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im1 = (ImageView) findViewById(R.id.im1);
        im2 = (ImageView) findViewById(R.id.im2);
        im3 = (ImageView) findViewById(R.id.im3);
        im4 = (ImageView) findViewById(R.id.im4);
        im1.setBackgroundColor(Color.argb(0xFF,0,50,100));
        im2.setBackgroundColor(Color.argb(0xFF,50,0,100));
        im3.setBackgroundColor(Color.argb(0xFF,50,100,0));
        im4.setBackgroundColor(Color.argb(0xFF,0,150,200));
        seekBar = (SeekBar) findViewById(R.id.seek);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                im1.setBackgroundColor(Color.argb(0xFF,progress,50,100));
                im2.setBackgroundColor(Color.argb(0xFF,50,progress,100));
                im3.setBackgroundColor(Color.argb(0xFF,50,100,progress));
                im4.setBackgroundColor(Color.argb(0xFF,progress,150,200));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.more:
                AlertDialog.Builder alert= new AlertDialog.Builder(this);
                alert.setMessage("Some text\n\nClick button to learn more!").
                        setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org")));
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alert.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
