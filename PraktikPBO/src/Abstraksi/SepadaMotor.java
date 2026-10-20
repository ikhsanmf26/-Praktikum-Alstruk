package abstraksi;

public class SepedaMotor extends Kendaraan {

    public SepedaMotor(String nama) {
        super(nama, 2);
    }

    @Override
    public void bergerak() {
        System.out.println(nama + " melaju lincah di antara kemacetan.");
    }

    @Override
    public double hitungBiayaBBM(double jarakKm) {
        double literPerKm = 1.0 / 40;        // 40 km per liter
        return jarakKm * literPerKm * 10000;
    }
}