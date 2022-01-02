package id.aryad.sipasar.data;

import java.util.ArrayList;
import java.util.List;

import id.aryad.sipasar.model.KategoriIuran;

public class KategoriIuranData {
    public static ArrayList<KategoriIuran> listKategoriIuran = new ArrayList<>(List.of(
            new KategoriIuran(1, "IURAN SAMPAH", 3000, 1),
            new KategoriIuran(2, "IURAN AIR", 10000, 1),
            new KategoriIuran(3, "IURAN LISTRIK", 6000, 1)
    ));

    public static KategoriIuran getKategoriIuranById(int idKategoriIuran) {
        for (KategoriIuran kategoriIuran : listKategoriIuran) {
            if (kategoriIuran.getId_kategori_iuran() == idKategoriIuran) {
                return kategoriIuran;
            }
        }
        return null;
    }
}
