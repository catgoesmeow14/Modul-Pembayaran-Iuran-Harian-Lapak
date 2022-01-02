package id.aryad.sipasar.model;

public class KategoriIuran {
    private int id_kategori_iuran;
    private String nama_kategori_iuran;
    private int nilai;
    private int status;

    public KategoriIuran(int id_kategori_iuran, String nama_kategori_iuran, int nilai, int status) {
        this.id_kategori_iuran = id_kategori_iuran;
        this.nama_kategori_iuran = nama_kategori_iuran;
        this.nilai = nilai;
        this.status = status;
    }

    public int getId_kategori_iuran() {
        return id_kategori_iuran;
    }

    public void setId_kategori_iuran(int id_kategori_iuran) {
        this.id_kategori_iuran = id_kategori_iuran;
    }

    public String getNama_kategori_iuran() {
        return nama_kategori_iuran;
    }

    public void setNama_kategori_iuran(String nama_kategori_iuran) {
        this.nama_kategori_iuran = nama_kategori_iuran;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nama_kategori_iuran;
    }
}
