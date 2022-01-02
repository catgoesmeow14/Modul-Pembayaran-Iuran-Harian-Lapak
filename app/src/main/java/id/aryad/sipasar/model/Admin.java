package id.aryad.sipasar.model;

public class Admin {
    private int id_admin;
    private int id_pegawai;
    private String username;
    private String password;
    private String role;
    private int status;

    public Admin(int id_admin, int id_pegawai, String username, String password, String role, int status) {
        this.id_admin = id_admin;
        this.id_pegawai = id_pegawai;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
