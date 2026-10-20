package studikasus;

public class KaryawanKontrak extends Karyawan {
    private double upahPerJam;
    private int jamKerja;

    public KaryawanKontrak(String id, String nama, double upahPerJam, int jamKerja) {
        super(id, nama);
        this.upahPerJam = upahPerJam;
        this.jamKerja = jamKerja;
    }

    @Override
    public double hitungGaji() {
        return upahPerJam * jamKerja;
    }
}
