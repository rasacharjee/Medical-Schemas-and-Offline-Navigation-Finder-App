package com.gamecodeschool.nineone1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class user_login extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button btnLogin,btnRegister;
    FirebaseAuth fAuth;
   // ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        etEmail=findViewById(R.id.etULemail);
        etPassword=findViewById(R.id.etULpassword);
        btnLogin=findViewById(R.id.btnUlogin);
        btnRegister=findViewById(R.id.btnRegister);
        fAuth=FirebaseAuth.getInstance();

     //   progressDialog=new ProgressDialog(getApplicationContext());
       // progressDialog.setTitle("WELCOME");
        //progressDialog.setMessage("Please wait while logging in");
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //progressDialog.setProgress(0);
        //progressDialog.setCanceledOnTouchOutside(false);
        //progressDialog.setCancelable(false);

        if (fAuth.getCurrentUser()!=null)
        {
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email,password;
                email=etEmail.getText().toString().trim();
                password=etPassword.getText().toString().trim();

                if(email.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"valid email and password required",Toast.LENGTH_SHORT).show();
                }else{
                   // progressDialog.show();
                    btnLogin.setEnabled(false);
                   fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                     //         progressDialog.dismiss();
                              startActivity(new Intent(getApplicationContext(),MainActivity.class));
                          }else{
                              Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                       //       progressDialog.dismiss();
                              btnLogin.setEnabled(true);
                          }
                       }
                   });
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),user_register.class));
            }
        });
    }
}
