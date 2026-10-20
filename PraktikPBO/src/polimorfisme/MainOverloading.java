package polimorfisme;

public class MainOverloading {
    public static void main(String[] args) {
        Kalkulator k = new Kalkulator();

        System.out.println("2 + 3       = " + k.tambah(2, 3));
        System.out.println("2 + 3 + 4   = " + k.tambah(2, 3, 4));
        System.out.println("2.5 + 3.5   = " + k.tambah(2.5, 3.5));
        System.out.println("Teks        = " + k.tambah("Halo", "Dunia"));
    }
}
