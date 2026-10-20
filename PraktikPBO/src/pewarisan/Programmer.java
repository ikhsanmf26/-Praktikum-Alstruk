package pewarisan;

public class Programmer extends Pegawai {
    private int jumlahProyek;

    public Programmer(String nama, double gajiPokok, int jumlahProyek) {
        super(nama, gajiPokok);
        this.jumlahProyek = jumlahProyek;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji() + (jumlahProyek * 1500000);
    }

    public void menulisKode() {          // method khusus Programmer
        System.out.println(nama + " sedang menulis kode.");
    }
}