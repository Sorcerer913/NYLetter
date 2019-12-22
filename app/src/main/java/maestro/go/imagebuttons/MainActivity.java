package maestro.go.imagebuttons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {   //TODO: passwords for groups

    private Button button_send;
    private Button button_letters_for_you;
    private Button button_music;

    private CheckBox isAnonim;
    private Spinner spinner;
    private EditText port;
    private EditText pass;

//    private FirebaseAuth mAuth;
//
//    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//    public void getInstance(){
//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();

        button_music = (Button) findViewById(R.id.button_music);
        button_send = (Button) findViewById(R.id.button_send);
        button_letters_for_you = (Button) findViewById(R.id.button_letters_for_you);
        //button_send.setId(View.generateViewId());
        //TODO: FireBase
        isAnonim = (CheckBox) findViewById(R.id.checkBox);
        spinner = (Spinner) findViewById(R.id.spinner);
        port = (EditText) findViewById(R.id.edit_text_port);
        pass = (EditText) findViewById(R.id.edit_text_pass);

        button_music.setOnClickListener(button_musicClickListener);
        button_send.setOnClickListener(button_sendClickListener);
        button_letters_for_you.setOnClickListener(button_lettersClickListener);

        //if(letCheck.isLetterGot())button_letters_for_you.setVisibility(View.VISIBLE);

    }

//    public void updateUI(FirebaseUser currentUser){ //TODO: auntification
//        if(user.isEmailVerified()){
//            //...
//        }else{
//            Toast.makeText(this, "Your email is not verified", Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(MainActivity.this, EmailPasswordActivity.class);
//            startActivity(intent);
//        }
//    }

    View.OnClickListener button_lettersClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LettersActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener button_sendClickListener = new View.OnClickListener() {    //TODO: шифрование , подключение FireBase
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.super.getApplicationContext(), "Letter has sent", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener button_musicClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MusicActivity.class);
            startActivity(intent);
        }
    };

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /*private void getCurrentUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }
    }*/

}
