package id.aryad.sipasar.data;

import java.util.ArrayList;
import java.util.List;

import id.aryad.sipasar.model.Pegawai;

public class PegawaiData {
    public static ArrayList<Pegawai> listPegawai = new ArrayList<>(List.of(
            new Pegawai(1, "Arya Dharmaadi", "Denpasar", "https://i.pinimg.com/564x/db/ba/25/dbba251e2a49bf1870210922f009ec5c.jpg"),
            new Pegawai(2, "Arya Admin", "Baturiti", "https://i.pinimg.com/564x/db/ba/25/dbba251e2a49bf1870210922f009ec5c.jpg"),
            new Pegawai(3, "Arya Manager", "Kediri", "https://i.pinimg.com/564x/db/ba/25/dbba251e2a49bf1870210922f009ec5c.jpg"),
            new Pegawai(4, "Vidya Not Active", "Tabanan", "https://i.pinimg.com/564x/db/ba/25/dbba251e2a49bf1870210922f009ec5c.jpg"),
            new Pegawai(5, "Vidya Chandradev", "Sanggulan, Tabanan","https://i.pinimg.com/564x/db/ba/25/dbba251e2a49bf1870210922f009ec5c.jpg")
    ));

    public static Pegawai getPegawaiById(int idPegawai) {
        for (Pegawai dataPegawai : listPegawai) {
            if (dataPegawai.getId_pegawai() == idPegawai) {
                return dataPegawai;
            }
        }
        return null;
    }
}
