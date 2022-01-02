package id.aryad.sipasar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import id.aryad.sipasar.data.AdminData;
import id.aryad.sipasar.data.KategoriIuranData;
import id.aryad.sipasar.data.KategoriLapakData;
import id.aryad.sipasar.data.PegawaiData;
import id.aryad.sipasar.data.PembayaranIuranData;
import id.aryad.sipasar.helper.SessionPref;
import id.aryad.sipasar.model.Admin;
import id.aryad.sipasar.model.KategoriIuran;
import id.aryad.sipasar.model.Lapak;
import id.aryad.sipasar.model.Pegawai;
import id.aryad.sipasar.model.PembayaranIuran;

public class FormPembayaranActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Lapak lapak;
    private Admin admin;
    private Pegawai pegawai;
    private TextView tvDate, tvNamaLapak, tvKategori, tvLokasiLapak, tvPemilik, tvTotal;
    private ImageView ivLapak, ivDatePicker;
    private Button btnBayarIuran;
    private Spinner spJenisIuran;
    private EditText edtPeriode;

    private int day, month, year, periodeBayar, totalBayar;
    private String tanggalIuran;
    private ArrayList<KategoriIuran> kategoriIurans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pembayaran);

        SessionPref sessionPref = new SessionPref(this);
        admin = AdminData.getAdminById(sessionPref.getInt("id_admin"));
        pegawai = PegawaiData.getPegawaiById(admin.getId_pegawai());

        Intent intent = getIntent();
        lapak = intent.getParcelableExtra("lapak");

        ivDatePicker = findViewById(R.id.ivDatePicker);
        btnBayarIuran = findViewById(R.id.btnBayarIuran);
        ivLapak = findViewById(R.id.ivLapak);
        tvDate = findViewById(R.id.tvDate);
        tvNamaLapak = findViewById(R.id.tvNamaLapak);
        tvKategori = findViewById(R.id.tvKategori);
        tvLokasiLapak = findViewById(R.id.tvLokasiLapak);
        tvPemilik = findViewById(R.id.tvPemilik);
        tvTotal = findViewById(R.id.tvTotal);
        spJenisIuran = findViewById(R.id.spJenisIuran);
        edtPeriode = findViewById(R.id.edtPeriode);

        Glide.with(this)
                .load(lapak.getFoto_pemilik())
                .centerCrop()
                .placeholder(R.drawable.icon_troli)
                .into(ivLapak);

        tvNamaLapak.setText(lapak.getNama_lapak());
        tvKategori.setText(KategoriLapakData.getKategoriLapakByID(lapak.getId_kategori_lapak()).getNama_kategori());
        tvLokasiLapak.setText(lapak.getPosisi_lapak());
        tvPemilik.setText(lapak.getNama_pemilik());

        kategoriIurans = new ArrayList<>(KategoriIuranData.listKategoriIuran);

        ArrayAdapter<KategoriIuran> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, kategoriIurans);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spJenisIuran.setAdapter(adapter);

        ivDatePicker.setOnClickListener(v -> showDatePickerDialog());

        edtPeriode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            private String formatRupiah(int number) {
                Locale localeID = new Locale("in", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                return formatRupiah.format(number);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().equals("")) {
                    periodeBayar = Integer.parseInt(s.toString());
                    totalBayar = kategoriIurans.get(spJenisIuran.getSelectedItemPosition()).getNilai() * periodeBayar;

                    tvTotal.setText(formatRupiah(totalBayar));
                } else {
                    tvTotal.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnBayarIuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((periodeBayar <= 0) || tanggalIuran.isEmpty()) {
                    Toast.makeText(FormPembayaranActivity.this, "Perhatikan kembali Inputan Anda", Toast.LENGTH_SHORT).show();
                } else {
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    String dateNow = formatDate.format(new Date());
                    int idKategoriIuran = kategoriIurans.get(spJenisIuran.getSelectedItemPosition()).getId_kategori_iuran();

                    PembayaranIuranData.listPembayaranIuran.add(new PembayaranIuran(
                            PembayaranIuranData.listPembayaranIuran.size() + 1,
                            lapak.getId_lapak(),
                            dateNow,
                            tanggalIuran,
                            periodeBayar,
                            idKategoriIuran,
                            totalBayar,
                            pegawai.getId_pegawai(),
                            0, //diisi oleh modul penyerahan
                            "" //diisi oleh modul penyerahan
                    ));

                    Toast.makeText(FormPembayaranActivity.this, "Pembayaran sudah berhasil, terima kasih", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(() -> {
                        Intent toMainActivity = new Intent(FormPembayaranActivity.this, PembayaranIuranActivity.class);
                        startActivity(toMainActivity);
                        finish();
                    }, 1500);
                }

            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month + 1;
        this.day = dayOfMonth;

        tanggalIuran = this.year + " - " + this.month + " - " + this.day;
        tvDate.setText(tanggalIuran);
    }
}