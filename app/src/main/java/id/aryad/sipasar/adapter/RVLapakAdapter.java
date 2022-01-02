package id.aryad.sipasar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.aryad.sipasar.FormPembayaranActivity;
import id.aryad.sipasar.R;
import id.aryad.sipasar.data.KategoriLapakData;
import id.aryad.sipasar.model.Lapak;

public class RVLapakAdapter extends RecyclerView.Adapter<RVLapakAdapter.ViewHolder> {
    private ArrayList<Lapak> listLapak;
    private final Context context;

    public RVLapakAdapter(ArrayList<Lapak> listLapak, Context context) {
        this.listLapak = listLapak;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivLapak;
        private final TextView tvNamaLapak, tvKategori, tvLokasiLapak, tvPemilik;
        private final CardView cvLapak;

        public ViewHolder(View v) {
            super(v);
            ivLapak = v.findViewById(R.id.ivLapak);
            tvNamaLapak = v.findViewById(R.id.tvNamaLapak);
            tvKategori = v.findViewById(R.id.tvKategori);
            tvLokasiLapak = v.findViewById(R.id.tvLokasiLapak);
            tvPemilik = v.findViewById(R.id.tvPemilik);
            cvLapak = v.findViewById(R.id.cvLapak);
        }

        public void bindView(Lapak lapak) {
            Glide.with(context)
                    .load(lapak.getFoto_pemilik())
                    .centerCrop()
                    .placeholder(R.drawable.icon_troli)
                    .into(ivLapak);

            tvNamaLapak.setText(lapak.getNama_lapak());
            tvKategori.setText(KategoriLapakData.getKategoriLapakByID(lapak.getId_kategori_lapak()).getNama_kategori());
            tvLokasiLapak.setText(lapak.getPosisi_lapak());
            tvPemilik.setText(lapak.getNama_pemilik());
            cvLapak.setOnClickListener(v -> {
                Intent toFormPembayaranIntent = new Intent(context, FormPembayaranActivity.class);
                toFormPembayaranIntent.putExtra("lapak", lapak);
                context.startActivity(toFormPembayaranIntent);
            });
        }
    }

    @NonNull
    @Override
    public RVLapakAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lapak_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(listLapak.get(position));
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return listLapak.size();
    }

    public void updateList(ArrayList<Lapak> listLapak) {
        this.listLapak = listLapak;
        notifyDataSetChanged();
    }
}
