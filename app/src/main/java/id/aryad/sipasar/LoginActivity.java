package id.aryad.sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.aryad.sipasar.controller.AuthController;
import id.aryad.sipasar.helper.SessionPref;

public class LoginActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SessionPref sessionPref = new SessionPref(this);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);

        if (sessionPref.isLoggined()) {
            toMainActivity();
        }

        btnLogin.setOnClickListener(v -> {

            String username = editUsername.getText().toString();
            String password = editPassword.getText().toString();

            String hasilLogin = AuthController.login(this, username, password);

            if (hasilLogin.equals("sukses")) {
                Toast.makeText(this, "Anda berhasil masuk", Toast.LENGTH_SHORT).show();
                toMainActivity();
            } else {
                Toast.makeText(this, hasilLogin, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void toMainActivity() {
        Intent toMainActivity = new Intent(LoginActivity.this, PembayaranIuranActivity.class);
        startActivity(toMainActivity);
        finish();
    }
}