package com.example.user.instas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class MainActivity extends AppCompatActivity {
  Button b1;
  TextView t1;
  EditText e1,e2;
    Intent i;
    FirebaseAuth mAuth;
    Intent i20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        t1=(TextView) findViewById(R.id.textView2);
        e1=(EditText) findViewById(R.id.editText2);
        e2=(EditText) findViewById(R.id.editText3);
        i20= new Intent(this,Main3Activity.class);

        mAuth=FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.button);
      i=  new Intent(this,Main2Activity.class);
      t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(i);
            }
        });
      b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              reso();
          }
      });



    }
    private void reso()
    {
        String email=e1.getText().toString().trim();
        String password=e2.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if (!task.isSuccessful())
                                {

                                    try
                                    {

                                        throw task.getException();

                                    }
                                    // if user enters wrong email.
                                    catch (FirebaseAuthInvalidUserException invalidEmail)
                                    {
                                        Log.i("hii", "onComplete: invalid_email");
                                        Toast.makeText(MainActivity.this,"wrong password or mail",Toast.LENGTH_SHORT).show();

                                        // TODO: take your actions!
                                    }
                                    // if user enters wrong password.
                                    catch (FirebaseAuthInvalidCredentialsException wrongPassword)
                                    {
                                        Log.i("hii", "onComplete: wrong_password");
                                        Toast.makeText(MainActivity.this,"wrong password ",Toast.LENGTH_SHORT).show();

                                        // TODO: Take your action
                                    }
                                    catch (Exception e)
                                    {
                                        Log.i("hii", "onComplete: " + e.getMessage());
                                        Toast.makeText(MainActivity.this,"wrong password or mail",Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else {
                                    Toast.makeText(MainActivity.this,"Welcome user",Toast.LENGTH_SHORT).show();
                                  startActivity(i20);

                                }

                            }
                        }
                );
    }
}
