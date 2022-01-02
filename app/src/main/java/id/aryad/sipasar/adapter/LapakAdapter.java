package id.aryad.sipasar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.aryad.sipasar.R;
import id.aryad.sipasar.data.KategoriLapakData;
import id.aryad.sipasar.model.Lapak;

public class LapakAdapter extends RecyclerView.Adapter<LapakAdapter.ViewHolder> {
    private final ArrayList<Lapak> listLapak;
    private final Context context;

    //Constructor
    public LapakAdapter(Context context, ArrayList<Lapak> listLapak) {
        this.listLapak = listLapak;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(context, listLapak.get(position));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lapak_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listLapak.size();
    }


    //View Holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivLapak;
        private final TextView tvNamaLapak;
        private final TextView tvKategori;
        private final TextView tvLokasiLapak;
        private final TextView tvPemilik;
        private final CardView cvLapak;

        public ViewHolder(@NonNull View v) {
            super(v);
            ivLapak = v.findViewById(R.id.ivLapak);
            tvNamaLapak = v.findViewById(R.id.tvNamaLapak);
            tvKategori = v.findViewById(R.id.tvKategori);
            tvLokasiLapak = v.findViewById(R.id.tvLokasiLapak);
            tvPemilik = v.findViewById(R.id.tvPemilik);
            cvLapak = v.findViewById(R.id.cvLapak);
        }

        public void bindView(Context context, Lapak lapak) {
            Glide.with(context)
                    .load(lapak.getFoto_pemilik())
                    .centerCrop()
                    .placeholder(R.drawable.icon_troli)
                    .into(ivLapak);

            tvNamaLapak.setText(lapak.getNama_lapak());
            tvKategori.setText(KategoriLapakData.getKategoriLapakByID(lapak.getId_kategori_lapak()).getNama_kategori());
            tvLokasiLapak.setText(lapak.getPosisi_lapak());
            tvPemilik.setText(lapak.getNama_pemilik());

            cvLapak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "balala yang di klik id : " + lapak.getId_lapak(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
