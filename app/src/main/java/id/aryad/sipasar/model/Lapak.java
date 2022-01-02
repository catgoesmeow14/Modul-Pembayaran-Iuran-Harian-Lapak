package id.aryad.sipasar.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Lapak implements Parcelable {
    private int id_lapak;
    private String nama_lapak;
    private int id_kategori_lapak;
    private String nama_pemilik;
    private String alamat_pemilik;
    private String foto_pemilik;
    private String posisi_lapak;
    private int status;
    private String tanggal_pendaftaran;
    private String tanggal_akhir_kontrak;
    private int id_admin;

    public Lapak(int id_lapak, String nama_lapak, int id_kategori_lapak, String nama_pemilik,
                 String alamat_pemilik, String foto_pemilik, String posisi_lapak, int status,
                 String tanggal_pendaftaran, String tanggal_akhir_kontrak, int id_admin) {
        this.id_lapak = id_lapak;
        this.nama_lapak = nama_lapak;
        this.id_kategori_lapak = id_kategori_lapak;
        this.nama_pemilik = nama_pemilik;
        this.alamat_pemilik = alamat_pemilik;
        this.foto_pemilik = foto_pemilik;
        this.posisi_lapak = posisi_lapak;
        this.status = status;
        this.tanggal_pendaftaran = tanggal_pendaftaran;
        this.tanggal_akhir_kontrak = tanggal_akhir_kontrak;
        this.id_admin = id_admin;
    }

    protected Lapak(Parcel in) {
        id_lapak = in.readInt();
        nama_lapak = in.readString();
        id_kategori_lapak = in.readInt();
        nama_pemilik = in.readString();
        alamat_pemilik = in.readString();
        foto_pemilik = in.readString();
        posisi_lapak = in.readString();
        status = in.readInt();
        tanggal_pendaftaran = in.readString();
        tanggal_akhir_kontrak = in.readString();
        id_admin = in.readInt();
    }

    public static final Creator<Lapak> CREATOR = new Creator<Lapak>() {
        @Override
        public Lapak createFromParcel(Parcel in) {
            return new Lapak(in);
        }

        @Override
        public Lapak[] newArray(int size) {
            return new Lapak[size];
        }
    };

    public int getId_lapak() {
        return id_lapak;
    }

    public void setId_lapak(int id_lapak) {
        this.id_lapak = id_lapak;
    }

    public String getNama_lapak() {
        return nama_lapak;
    }

    public void setNama_lapak(String nama_lapak) {
        this.nama_lapak = nama_lapak;
    }

    public int getId_kategori_lapak() {
        return id_kategori_lapak;
    }

    public void setId_kategori_lapak(int id_kategori_lapak) {
        this.id_kategori_lapak = id_kategori_lapak;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getAlamat_pemilik() {
        return alamat_pemilik;
    }

    public void setAlamat_pemilik(String alamat_pemilik) {
        this.alamat_pemilik = alamat_pemilik;
    }

    public String getFoto_pemilik() {
        return foto_pemilik;
    }

    public void setFoto_pemilik(String foto_pemilik) {
        this.foto_pemilik = foto_pemilik;
    }

    public String getPosisi_lapak() {
        return posisi_lapak;
    }

    public void setPosisi_lapak(String posisi_lapak) {
        this.posisi_lapak = posisi_lapak;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTanggal_pendaftaran() {
        return tanggal_pendaftaran;
    }

    public void setTanggal_pendaftaran(String tanggal_pendaftaran) {
        this.tanggal_pendaftaran = tanggal_pendaftaran;
    }

    public String getTanggal_akhir_kontrak() {
        return tanggal_akhir_kontrak;
    }

    public void setTanggal_akhir_kontrak(String tanggal_akhir_kontrak) {
        this.tanggal_akhir_kontrak = tanggal_akhir_kontrak;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_lapak);
        dest.writeString(nama_lapak);
        dest.writeInt(id_kategori_lapak);
        dest.writeString(nama_pemilik);
        dest.writeString(alamat_pemilik);
        dest.writeString(foto_pemilik);
        dest.writeString(posisi_lapak);
        dest.writeInt(status);
        dest.writeString(tanggal_pendaftaran);
        dest.writeString(tanggal_akhir_kontrak);
        dest.writeInt(id_admin);
    }
}
