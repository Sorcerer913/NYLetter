package maestro.go.imagebuttons;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class RegisterActivity extends AppCompatActivity /*extends MainActivity*/ {

    private Button button_register;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText edit_text_passwordConfirm;
    private EditText edit_text_name;

    private boolean isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        isCorrect = false;

        button_register = (Button) findViewById(R.id.button_register);
        editTextEmail = (EditText) findViewById(R.id.edit_text_email);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);
        edit_text_passwordConfirm = (EditText) findViewById(R.id.edit_text_passwordConfirm);
        edit_text_name = (EditText) findViewById(R.id.edit_text_name);

        button_register.setOnClickListener(button_registerClickListener);

        editTextEmail.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);
        edit_text_passwordConfirm.addTextChangedListener(textWatcher);
    }

    public void checkCorrect(){
        if(true){   //TODO: integrate checker mechanism
            isCorrect = true;
        }else{
            isCorrect = false;
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String password = editTextPassword.getText().toString();

            if(password.equals(edit_text_passwordConfirm)) {
                String name = edit_text_name.getText().toString();
                String email = editTextEmail.getText().toString();

                checkCorrect();
                if (isCorrect) {
                    button_register.setEnabled(true);
                } else {
                    button_register.setEnabled(false);
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    View.OnClickListener button_registerClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = editTextPassword.getText().toString();
            String password = editTextPassword.getText().toString();

//            createAccount(email, password);
            Toast.makeText(RegisterActivity.this.getApplicationContext(), "sent", Toast.LENGTH_SHORT).show();

            //TODO: Waiting for answer from server
        }
    };

    /*private void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void getCurrentUser(){
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

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        Intent intent = new Intent(RegisterActivity.this , EmailPasswordActivity.class);
        startActivity(intent);
    }

}
