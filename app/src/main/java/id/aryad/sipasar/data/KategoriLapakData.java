package id.aryad.sipasar.data;

import java.util.ArrayList;
import java.util.List;

import id.aryad.sipasar.model.KategoriLapak;

public class KategoriLapakData {
    public static ArrayList<KategoriLapak> listKategoriLapak = new ArrayList<>(List.of(
            new KategoriLapak(1, "Makanan"),
            new KategoriLapak(2, "Minuman"),
            new KategoriLapak(3, "Banten"),
            new KategoriLapak(4, "Pakaian"),
            new KategoriLapak(5, "Peralatan Rumah Tangga")
    ));

    public static KategoriLapak getKategoriLapakByID(int id_kategori_lapak) {
        for (KategoriLapak dataKategoriLapak : listKategoriLapak) {
            if (dataKategoriLapak.getId_kategori_lapak() == id_kategori_lapak) {
                return dataKategoriLapak;
            }
        }
        return null;
    }
}
