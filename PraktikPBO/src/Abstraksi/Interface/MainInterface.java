package abstraksi;

public class MainInterface {
    public static void main(String[] args) {
        Bebek bebek = new Bebek();
        Terbang elang = new Elang();   // polimorfisme lewat interface

        bebek.terbang();
        bebek.berenang();
        bebek.selam();                 // method default dari Berenang
        elang.terbang();
    }
}