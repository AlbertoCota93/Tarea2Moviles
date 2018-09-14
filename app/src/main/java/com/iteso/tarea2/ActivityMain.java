package com.iteso.tarea2;

import android.os.PersistableBundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ActivityMain extends AppCompatActivity {

    private final static String Button_State="";
    Button m;
    Button s;
    Button l;
    Button xl;
    ImageButton like;
    Button cart;
    String cartString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m =findViewById(R.id.mediumButton);
        s =findViewById(R.id.smallButton);
        l=findViewById(R.id.largeButton);
        xl=findViewById(R.id.ExtraLargeButton);
        like=findViewById(R.id.activity_main_like_button);
        cart=findViewById(R.id.activity_main_cart);
       final CoordinatorLayout coordinatorLayout= findViewById(R.id.activity_main_coordinator);


        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast liked;
                liked = Toast.makeText(ActivityMain.this, getString(R.string.likePressed), Toast.LENGTH_LONG);
                liked.setGravity(Gravity.CENTER,0,0);
                liked.show();
            }
        });

            if (cartString.equals(R.string.cartButtonPressed)){
                cart.setText(R.string.cartButtonPressed);
                Snackbar.make(coordinatorLayout, getString(R.string.cartButtonPressed), Snackbar.LENGTH_INDEFINITE).
                        setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                cart.setText(R.string.cartButton);
                            }
                        }).show();
            }else {
                cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cart.getText().toString().equals(R.string.cartButtonPressed)) {
                            Toast toast = Toast.makeText(ActivityMain.this, getString(R.string.cartButtonPressed_again), Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        } else {
                            cart.setText(R.string.cartButtonPressed);
                            Snackbar.make(coordinatorLayout, getString(R.string.cartButtonPressed), Snackbar.LENGTH_INDEFINITE).
                                    setAction("UNDO", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            cart.setText(R.string.cartButton);
                                        }
                                    }).show();
                        }
                    }
                });
            }
       }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(Button_State,cart.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cartString = savedInstanceState.getString(Button_State);
        cart.setText(cartString);
    }
}
