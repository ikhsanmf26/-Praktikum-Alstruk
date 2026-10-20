package polimorfisme;

public class BangunDatar {
    protected String nama;

    public BangunDatar(String nama) {
        this.nama = nama;
    }

    public double hitungLuas() {
        return 0;
    }

    public void info() {
        System.out.println(nama + " | Luas = " + hitungLuas());
    }
}
