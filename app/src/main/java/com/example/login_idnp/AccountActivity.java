package com.example.login_idnp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class AccountActivity extends AppCompatActivity {
    public final static String ACCOUNT_RECORD = "ACCOUNT_RECORD";
    public final static Integer ACCOUNT_ACEPTAR = 100;
    public final static Integer ACCOUNT_CANCELAR = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtFirstname = findViewById(R.id.editFirstname);
        EditText edtLastname = findViewById(R.id.editLastname);
        EditText edtEmail = findViewById(R.id.editEmailAddress);
        EditText edtPhone = findViewById(R.id.editPhone);
        EditText edtUsername = findViewById(R.id.editUsername);
        EditText edtPassword = findViewById(R.id.editPassword);
        Button btnAceptar = findViewById(R.id.buttonRegister2);
        Button btnCancelar = findViewById(R.id.buttonCancel);

        //btnAceptar.setOnClickListener(v -> {
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setFirstname(edtFirstname.getText().toString());
                accountEntity.setLastname(edtLastname.getText().toString());
                accountEntity.setEmail(edtEmail.getText().toString());
                accountEntity.setPhone(edtPhone.getText().toString());
                accountEntity.setUsername(edtUsername.getText().toString());
                accountEntity.setPassword(edtPassword.getText().toString());

               /* Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                intent.putExtra("accountEntity", accountEntity);
                startActivity(intent);*/
                Gson gson = new Gson();
                String accountJson = gson.toJson(accountEntity);

                Intent data = new Intent();
                data.putExtra(ACCOUNT_RECORD,accountJson);

                setResult(ACCOUNT_ACEPTAR, data);
                finish();

            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(ACCOUNT_CANCELAR);
                finish();
            }
        });
    }
}













