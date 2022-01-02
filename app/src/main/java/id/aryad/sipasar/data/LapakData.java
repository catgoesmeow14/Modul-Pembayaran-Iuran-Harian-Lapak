package id.aryad.sipasar.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.aryad.sipasar.model.Lapak;

public class LapakData {
    public static ArrayList<Lapak> listLapak = new ArrayList<>(List.of(
            new Lapak(1, "Warung Bakso Pak Sedap", 1,
                    "Sedap Sejahtera", "Kediri", "https://i.pinimg.com/originals/8a/07/a5/8a07a546c975c48cd7f4c3eff3293998.jpg",
                    "A1", 1, "23 Januari 2021",
                    "23 Januari 2022", 1),
            new Lapak(2, "Banten Bu Dayu", 3,
                    "Ida Ayu Rahayu", "Baturiti", "https://i.pinimg.com/originals/5a/00/01/5a0001c8028c2502e4fd60a2f6c422ab.png",
                    "A2", 1, "15 Januari 2021",
                    "15 Januari 2022", 1),
            new Lapak(3, "Softdrink Rembulan", 2,
                    "Arka Ferdy", "Tabanan", "https://i.pinimg.com/originals/e5/6c/1e/e56c1efe162d62488ce80bfeb86e4c33.jpg",
                    "A3", 1, "20 Februari 2021",
                    "20 Februari 2022", 1),
            new Lapak(4, "Mekarsari Baju Adat", 4,
                    "Irene Saraswati", "Slemadeg", "https://i.pinimg.com/originals/1d/ed/09/1ded094948f2d50df34b743f0ef59409.jpg",
                    "A4", 1, "7 April 2021",
                    "7 April 2022", 1),
            new Lapak(5, "Arirang Grosir", 5,
                    "Yulia Jayanti", "Mengwi", "https://i.pinimg.com/originals/96/cb/32/96cb32649148360f0e586035a7dfa588.jpg",
                    "A5", 1, "7 April 2021",
                    "7 April 2022", 1)
    ));

    public static ArrayList<Lapak> searchLapak(String keyword) {
        ArrayList<Lapak> dataLapak = new ArrayList<>();
        for (Lapak lapak : listLapak) {
            if (lapak.getNama_lapak().toLowerCase().trim().contains(keyword.toLowerCase().trim())) {
                Log.d("test lapak", lapak.getNama_lapak());
                dataLapak.add(lapak);
            }
        }
        return dataLapak;
    }
}