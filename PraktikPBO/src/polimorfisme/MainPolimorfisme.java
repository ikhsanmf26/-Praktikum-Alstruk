package polimorfisme;

public class MainPolimorfisme {
    public static void main(String[] args) {
        // satu tipe referensi (BangunDatar), banyak bentuk objek
        BangunDatar[] daftar = {
            new Persegi(5),
            new Lingkaran(7),
            new Segitiga(6, 4)
        };

        for (BangunDatar b : daftar) {
            b.info();       // method yang dijalankan sesuai objek aktual
        }
    }
}
