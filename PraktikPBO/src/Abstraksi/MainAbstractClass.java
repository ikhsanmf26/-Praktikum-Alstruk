package abstraksi;

public class MainAbstractClass {
    public static void main(String[] args) {
        // Kendaraan k = new Kendaraan("X", 4);  // ERROR: abstract, tidak bisa di-instansiasi

        Kendaraan k1 = new MobilBensin("Avanza");
        Kendaraan k2 = new SepedaMotor("Vario");

        k1.tampilkanInfo();
        k1.bergerak();
        System.out.println("Biaya 120 km: Rp" + k1.hitungBiayaBBM(120));
        System.out.println("----------------------------");
        k2.tampilkanInfo();
        k2.bergerak();
        System.out.println("Biaya 120 km: Rp" + k2.hitungBiayaBBM(120));
    }
}
