package com.example.login_idnp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String accountEntityString = getIntent().getStringExtra("ACCOUNT");
        if (accountEntityString != null) {
            Gson gson = new Gson();
            AccountEntity accountEntity = gson.fromJson(accountEntityString, AccountEntity.class);

            TextView welcomeText = findViewById(R.id.texto1);
            welcomeText.setText("Bienvenido " + accountEntity.getFirstname());

            TextView detailsText = findViewById(R.id.detailsText);
            detailsText.setText("Nombre: " + accountEntity.getFirstname() + " " + accountEntity.getLastname() + "\n" +
                    "Correo: " + accountEntity.getEmail() + "\n" +
                    "Teléfono: " + accountEntity.getPhone() + "\n" +
                    "Usuario: " + accountEntity.getUsername() + "\n" +
                    "Contraseña: " + accountEntity.getPassword());
        } else {
            Log.d("HomeActivity", "No ACCOUNT data found");
        }
    }
}
