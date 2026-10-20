package polimorfisme;

public class Kalkulator {

    public int tambah(int a, int b) {
        return a + b;
    }

    public int tambah(int a, int b, int c) {      // jumlah parameter berbeda
        return a + b + c;
    }

    public double tambah(double a, double b) {    // tipe parameter berbeda
        return a + b;
    }

    public String tambah(String a, String b) {    // tipe String
        return a + " " + b;
    }
}
