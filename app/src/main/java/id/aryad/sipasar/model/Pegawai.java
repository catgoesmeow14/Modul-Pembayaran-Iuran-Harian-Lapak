package id.aryad.sipasar.model;

public class Pegawai {
    private int id_pegawai;
    private String nama_pegawai;
    private String alamat;
    private String foto;

    public Pegawai(int id_pegawai, String nama_pegawai, String alamat, String foto) {
        this.id_pegawai = id_pegawai;
        this.nama_pegawai = nama_pegawai;
        this.alamat = alamat;
        this.foto = foto;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
