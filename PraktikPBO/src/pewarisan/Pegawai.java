package pewarisan;

public class Pegawai {
    protected String nama;
    protected double gajiPokok;

    public Pegawai(String nama, double gajiPokok) {
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    public double hitungGaji() {
        return gajiPokok;
    }

    public void tampilkanData() {
        System.out.println("Nama       : " + nama);
        System.out.println("Gaji Total : Rp" + hitungGaji());
    }
}