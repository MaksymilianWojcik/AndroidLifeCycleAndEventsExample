package com.example.maks.lifecycleexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    RelativeLayout relativeLayout1;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        relativeLayout1 = (RelativeLayout) findViewById(R.id.relativeLayout1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        relativeLayout1.setOnTouchListener(new RelativeLayout.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("Example", "onTouch");
                handleTouch(event);
                return true;
            }
        });


        Log.i("Example", "onCreate");


    }


    private void handleTouch(MotionEvent m){
        int pointerCount = m.getPointerCount();

        for(int i = 0; i <pointerCount; i++){
            int x = (int) m.getX();
            int y = (int) m.getY();
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;

            switch (action){
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                default:
                    actionString = "";
            }

            String status = "Action: " + actionString + ", Index: " + actionIndex + ", ID: " + id + ", x: " + x + ", y: " + y;

            if(id==0){
                textView1.setText(status + "|" + m.getY() + ", "  + m.getX());
            } else {
                textView2.setText(status  + "|" + m.getY() + ", "  + m.getX());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Example", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Example", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Example", "onDestroy");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Example", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Example", "onRestoreInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Example", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Example", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Example", "onRestart");
    }
}
