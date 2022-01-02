package id.aryad.sipasar.model;

public class KategoriLapak {
    private int id_kategori_lapak;
    private String nama_kategori;

    public KategoriLapak(int id_kategori_lapak, String nama_kategori) {
        this.id_kategori_lapak = id_kategori_lapak;
        this.nama_kategori = nama_kategori;
    }

    public int getId_kategori_lapak() {
        return id_kategori_lapak;
    }

    public void setId_kategori_lapak(int id_kategori_lapak) {
        this.id_kategori_lapak = id_kategori_lapak;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
}
