package abstraksi;

public class MobilBensin extends Kendaraan {

    public MobilBensin(String nama) {
        super(nama, 4);
    }
    @Override
    public void bergerak() {
        System.out.println(nama + " melaju dengan mesin bensin.");
    }

    @Override
    public double hitungBiayaBBM(double jarakKm) {
        double literPerKm = 1.0 / 12;        // 12 km per liter
        return jarakKm * literPerKm * 10000;  // Rp10.000 per liter
    }
}
