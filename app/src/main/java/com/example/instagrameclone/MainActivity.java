package com.example.instagrameclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private ImageView iconImage;
    private LinearLayout linearLayout;
    private Button signUp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconImage = (ImageView) findViewById(R.id.icon);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        signUp = (Button) findViewById(R.id.signUp);
        login = (Button) findViewById(R.id.login);
        //make the linear layout invisible
        linearLayout.animate().alpha(0f).setDuration(1);
        //the animation
        TranslateAnimation animation = new TranslateAnimation(0,0,0,-1200);
        animation.setDuration(650);
        animation.setFillAfter(false);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iconImage.clearAnimation();
                iconImage.setVisibility(View.INVISIBLE);
                linearLayout.animate().alpha(1f).setDuration(650);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iconImage.setAnimation(animation);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

   @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
            finish();
        }
    }
}