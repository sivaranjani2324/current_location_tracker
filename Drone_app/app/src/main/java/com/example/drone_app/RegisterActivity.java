package com.example.drone_app;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
/*import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;*/

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextRegisterFullName,editTextRegisterEmail,editTextRegisterDob,editTextRegisterMobile,
            editTextRegisterpwd,editTextRegisterconfirmpswd;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private Button button_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        getSupportActionBar().setTitle("Register");

        Toast.makeText(RegisterActivity.this,"you can register now",Toast.LENGTH_LONG).show();

        editTextRegisterFullName = findViewById(R.id.editText_register_full_name);
        editTextRegisterEmail = findViewById(R.id.editText_register_email);
        editTextRegisterDob = findViewById(R.id.editText_register_dob);
        editTextRegisterMobile = findViewById(R.id.editText_register_mobile);
        editTextRegisterpwd = findViewById(R.id.editText_register_password);
        editTextRegisterconfirmpswd = findViewById(R.id.editText_register_confirm_password);

        radioGroupRegisterGender = findViewById(R.id.radio_group_register_gender);
        radioGroupRegisterGender.clearCheck();

        Button buttonRegister =findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                String textFullName = editTextRegisterFullName.getText().toString();
                String textEmail = editTextRegisterEmail.getText().toString();
                String textDob = editTextRegisterDob.getText().toString();
                String textMobile = editTextRegisterMobile.getText().toString();
                String textpwd = editTextRegisterconfirmpswd.getText().toString();
                String textconfirmpswd = editTextRegisterconfirmpswd.getText().toString();
                String textGender;

                if (TextUtils.isEmpty(textFullName)){
                    Toast.makeText(RegisterActivity.this,"Please enter your email",Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError(("email is required"));
                    editTextRegisterEmail.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                    Toast.makeText(RegisterActivity.this,"Please re-enter your email",Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError(("Valid email is required"));
                    editTextRegisterEmail.requestFocus();
                }else if(TextUtils.isEmpty(textDob)){
                    Toast.makeText(RegisterActivity.this,"please enter your  Date of your Birth",Toast.LENGTH_LONG).show();
                    editTextRegisterDob.setError("Date of Birth is required");
                    editTextRegisterDob.requestFocus();
                }else if (radioGroupRegisterGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(RegisterActivity.this,"please select your gender",Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Gender is required");
                    radioGroupRegisterGender.requestFocus();
                }else if (TextUtils.isEmpty(textMobile)) {
                    Toast.makeText(RegisterActivity.this,"please enter your  Date of your Birth",Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile no is required");
                    editTextRegisterMobile.requestFocus();
                }else if (textMobile.length() !=10){
                    Toast.makeText(RegisterActivity.this,"please enter your  Date of your Birth",Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile no should be 10 digits");
                    editTextRegisterMobile.requestFocus();

                }else if (TextUtils.isEmpty(textpwd)){
                    Toast.makeText(RegisterActivity.this,"please enter your Password",Toast.LENGTH_LONG).show();
                    editTextRegisterpwd.setError("Password is required");
                    editTextRegisterpwd.requestFocus();
                }else if(textpwd.length() < 6){
                    Toast.makeText(RegisterActivity.this,"password should be 6 digits",Toast.LENGTH_LONG).show();
                    editTextRegisterpwd.setError("password too weak");
                    editTextRegisterpwd.requestFocus();
                }else if (TextUtils.isEmpty(textconfirmpswd)){
                    Toast.makeText(RegisterActivity.this,"please confirm your password",Toast.LENGTH_LONG).show();
                    editTextRegisterconfirmpswd.setError("password confirmation is required");
                    editTextRegisterconfirmpswd.requestFocus();
                }else if (!textpwd.equals(textconfirmpswd)){
                    Toast.makeText(RegisterActivity.this,"Please type same password",Toast.LENGTH_LONG).show();
                    editTextRegisterpwd.setError("password confirmation is required");
                    editTextRegisterpwd.requestFocus();

                    editTextRegisterpwd.clearComposingText();
                    editTextRegisterconfirmpswd.clearComposingText();
                }else {
                    textGender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    /*(textFullName,textEmail,textDob,textGender,textMobile,textpwd);*/



                }
            }
        });

    }

    /*private void registerUser(String textFullName, String textEmail, String textDob, String textGender, String textMobile, String textpwd) {
        FirebaseAuth  auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(textEmail,textpwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "user registered succesfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    /* firebaseUser.sendEmailVerification();
                    Intent intent=new Intent(RegisterActivity.this,userProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }
            }
        });*/
}
