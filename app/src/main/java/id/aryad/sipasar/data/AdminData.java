package id.aryad.sipasar.data;

import java.util.ArrayList;
import java.util.List;

import id.aryad.sipasar.model.Admin;

public class AdminData {
    public static ArrayList<Admin> listAdmin = new ArrayList<>(List.of(
            new Admin(1, 1, "aryapegawai", "pass123", "PEGAWAI", 1),
            new Admin(2, 2, "aryaadmin", "pass123", "ADMIN", 1),
            new Admin(3, 3, "aryamanager", "pass123", "MANAGER", 1),
            new Admin(4, 4, "vidyachan", "12345", "PEGAWAI", 0),
            new Admin(5, 5, "vidya14", "12345", "PEGAWAI", 1)
    ));

    public static Admin getAdminById(int idAdmin) {
        for (Admin admin : listAdmin) {
            if (admin.getId_admin() == idAdmin) {
                return admin;
            }
        }
        return null;
    }
}