package id.aryad.sipasar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.aryad.sipasar.adapter.RVLapakAdapter;
import id.aryad.sipasar.controller.AuthController;
import id.aryad.sipasar.data.LapakData;
import id.aryad.sipasar.helper.SessionPref;
import id.aryad.sipasar.model.Lapak;

public class PembayaranIuranActivity extends AppCompatActivity {

    private EditText svLapak;
    private TextView tvNamaPegawai, tvRole;
    private ImageView ivLogout;
    private RecyclerView rvLapak;

    private RVLapakAdapter rvLapakAdapter;
    private ArrayList<Lapak> listLapak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_iuran);

        svLapak = findViewById(R.id.svLapak);
        rvLapak = findViewById(R.id.rvLapak);
        tvNamaPegawai = findViewById(R.id.tvNamaPegawai);
        tvRole = findViewById(R.id.tvRole);
        ivLogout = findViewById(R.id.ivLogout);

        SessionPref sessionPref = new SessionPref(this);
        tvNamaPegawai.setText(sessionPref.getString("nama_pegawai"));
        tvRole.setText(sessionPref.getString("role"));

        rvLapak.setHasFixedSize(true);
        rvLapak.setLayoutManager(new LinearLayoutManager(this));

        listLapak.addAll(LapakData.listLapak);

        rvLapakAdapter = new RVLapakAdapter(listLapak, this);

        rvLapak.setAdapter(rvLapakAdapter);

        svLapak.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s.toString().trim())) {
                    rvLapakAdapter.updateList(LapakData.searchLapak(s.toString()));
                } else {
                    rvLapakAdapter.updateList(listLapak);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialog();
            }
        });
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AuthController.logout(getApplicationContext());
                    }
                })
                .setNegativeButton("Tidak", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}