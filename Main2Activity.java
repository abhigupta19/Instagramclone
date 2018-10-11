package com.example.user.instas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnKeyListener {
    Button b2;
    Intent i2;
    private FirebaseAuth f;
    private EditText e1;
    private  EditText e2;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2=(Button)findViewById(R.id.button2);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText6);
        f=FirebaseAuth.getInstance();
        i2= new Intent(this,MainActivity.class);
        mAuth = FirebaseAuth.getInstance();
    e2.setOnKeyListener(this);



    }
    private void res()
    {
        String email=e1.getText().toString().trim();
        String password=e2.getText().toString().trim();

        f.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("JIO", "createUserWithEmail:success");
                            Toast.makeText(Main2Activity.this, "Authentication Sucess.",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.i("JIO", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Main2Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    @Override
    public boolean onKey(View view, int i, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                (i == KeyEvent.KEYCODE_ENTER))
        {
          jai(view);
        }
        return false;
    }
    public void jai(View view)
    {
     res();
     startActivity(i2);


    }
}
