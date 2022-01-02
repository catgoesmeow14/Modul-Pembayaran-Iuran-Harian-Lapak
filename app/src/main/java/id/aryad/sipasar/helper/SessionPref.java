package id.aryad.sipasar.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionPref {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor sharedEditor;

    public SessionPref(Context context) {
        sharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();
        sharedEditor.apply();
    }

    public void setBoolean(String key, Boolean value) {
        sharedEditor.putBoolean(key, value);
        sharedEditor.apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);

    }

    public void setInt(String key, int value) {
        sharedEditor.putInt(key, value);
        sharedEditor.apply();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void setString(String key, String value) {
        sharedEditor.putString(key, value);
        sharedEditor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void setSessionLogin(int idAdmin, String namaPegawai, String role) {
        setBoolean("logged_in", true);
        setInt("id_admin", idAdmin);
        setString("nama_pegawai", namaPegawai);
        setString("role", role);
    }

    public Boolean isLoggined() {
        return this.getBoolean("logged_in");
    }

    public void clearSession() {
        sharedEditor.clear();
        sharedEditor.apply();
    }
}
