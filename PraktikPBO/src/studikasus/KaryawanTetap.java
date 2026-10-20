package studikasus;

public class KaryawanTetap extends Karyawan {     // pewarisan
    private double gajiPokok;
    private double tunjangan;

    public KaryawanTetap(String id, String nama, double gajiPokok, double tunjangan) {
        super(id, nama);
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok + tunjangan;
    }
}
