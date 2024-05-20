package com.example.login_idnp;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

/*        TextView welcomeText = findViewById(R.id.welcomeText);
        String username = getIntent().getStringExtra("username");

        // Utilizar el recurso de cadena con el marcador de posición
        String welcomeMessage = "Bienvenido {username}";
        welcomeText.setText(welcomeMessage);*/

        String accountEntity=getIntent().getStringExtra("ACCOUNT");

        Log.d("HomeActivity", "ACCOUNT");
    }
}
















