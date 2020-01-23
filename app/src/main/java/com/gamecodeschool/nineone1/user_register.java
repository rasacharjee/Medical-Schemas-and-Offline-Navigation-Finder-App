package com.gamecodeschool.nineone1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_register extends AppCompatActivity {
    EditText etName,etEmail,etPhn,etPassword,etcPassword;
    Button btnRegister;
    public FirebaseAuth mAuth;
    public DatabaseReference databasePatients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        etName=findViewById(R.id.etUname);//uses the diseases information
        etEmail=findViewById(R.id.etULemail);
        etPhn=findViewById(R.id.etUphn);
        etPassword=findViewById(R.id.etUpass);
        etcPassword=findViewById(R.id.etUcpassword);
        btnRegister=findViewById(R.id.btnUregister);
        databasePatients= FirebaseDatabase.getInstance().getReference("Patient_credentials");
        mAuth=FirebaseAuth.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name,Email,Phn,Password,cPassword;
                Name=etName.getText().toString().trim();
                Email=etEmail.getText().toString().trim();//uses the diseases information to pass to database
                Phn=etPhn.getText().toString().trim();
                Password=etPassword.getText().toString().trim();
                cPassword=etcPassword.getText().toString().trim();

                if(Name.isEmpty()||Email.isEmpty()||Phn.isEmpty()||(Phn.length()<10)||Password.isEmpty()||cPassword.isEmpty()||(!Password.equals(cPassword))){
                    Toast.makeText(getApplicationContext(),"Please enter all fields and make sure phone number is accurate",Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              addCredentials();
                          }else{
                              Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                          }
                        }
                    });


                }
            }
        });
    }
    private void addCredentials(){
        String dvid= databasePatients.push().getKey();
        String dvEmail,dvPhn,dvName,dUid = new String();
        dvEmail=etEmail.getText().toString().trim();
        dvPhn=etPhn.getText().toString().trim();
        dvName=etName.getText().toString().trim();//diseases
        String duid=FirebaseAuth.getInstance().getCurrentUser().getUid();
        patient_credentials pCredentials= new patient_credentials(dvid,dvEmail,dvPhn,dvName,duid);
        databasePatients.child(dvid).setValue(pCredentials);
    }
}
