package com.nestedmango.myfirebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
// firebase auth
    private FirebaseAuth firebaseAuth;
    // view object
    private TextView textViewUserEmail;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // intialize firebase authentication
        firebaseAuth=FirebaseAuth.getInstance();

        //if user is not log in
        //that means current user will return null
        // closing this activity
        if (firebaseAuth.getCurrentUser()==null){
            finish();
            // start login activity
            startActivity(new Intent(this,LoginActivityCLass.class));
        }

        // getting cirrent user
        FirebaseUser user=firebaseAuth.getCurrentUser();
        // initialize views
        textViewUserEmail=(TextView)findViewById(R.id.textViewUserEmail);
        buttonLogout=(Button)findViewById(R.id.buttonLogout);
        // displaying log in user name
        textViewUserEmail.setText("Welcome"+user.getEmail());
        // adding lis
        buttonLogout.setOnClickListener((View.OnClickListener) this);


    }

}
