package id.aryad.sipasar.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import java.util.ArrayList;

import id.aryad.sipasar.LoginActivity;
import id.aryad.sipasar.data.AdminData;
import id.aryad.sipasar.data.PegawaiData;
import id.aryad.sipasar.helper.SessionPref;
import id.aryad.sipasar.model.Admin;
import id.aryad.sipasar.model.Pegawai;

public class AuthController {

    public static void logout(Context context) {
        SessionPref sessionPref = new SessionPref(context);
        sessionPref.clearSession();

        Intent toLogout = new Intent(context, LoginActivity.class);
        toLogout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(toLogout);
    }

    public static String login(Context context, String username, String password) {
        SessionPref sessionPref = new SessionPref(context);

        ArrayList<Admin> listAdmin = new ArrayList<>(AdminData.listAdmin);

        if (!(username.trim().isEmpty() && !password.trim().isEmpty())) {
            for (Admin admin : listAdmin) {
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    if (admin.getStatus() == 1 && admin.getRole().equals("PEGAWAI")) {
                        Pegawai pegawai = PegawaiData.getPegawaiById(admin.getId_pegawai());

                        sessionPref.setSessionLogin(admin.getId_admin(), pegawai.getNama_pegawai(), admin.getRole());
                        return "sukses";
                    } else {
                        return "Anda tidak memiliki akses";
                    }
                }
            }
            return "Mohon periksa kembali Input Anda";
        } else {
            return "Input not valid";

        }
    }
}
