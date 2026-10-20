public class Mobil {
    // atribut
    String merk;
    int kecepatan;

    // method
    void tambahKecepatan(int nilai) {
        kecepatan += nilai;
    }

    void tampilkanInfo() {
        System.out.println(merk + " melaju " + kecepatan + " km/jam");
    }

    public static void main(String[] args) {
        Mobil m1 = new Mobil();   // membuat object
        m1.merk = "Toyota";
        m1.tambahKecepatan(60);
        m1.tampilkanInfo();
    }
}
