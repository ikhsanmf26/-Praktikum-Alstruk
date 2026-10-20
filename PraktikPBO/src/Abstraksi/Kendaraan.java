package abstraksi;

public abstract class Kendaraan {
    protected String nama;
    protected int jumlahRoda;

    public Kendaraan(String nama, int jumlahRoda) {
        this.nama = nama;
        this.jumlahRoda = jumlahRoda;
    }

    // method abstrak: hanya kerangka, tanpa isi
    public abstract void bergerak();
    public abstract double hitungBiayaBBM(double jarakKm);

    // method biasa: sudah memiliki implementasi
    public void tampilkanInfo() {
        System.out.println("Kendaraan  : " + nama);
        System.out.println("Jumlah roda: " + jumlahRoda);
    }
}
