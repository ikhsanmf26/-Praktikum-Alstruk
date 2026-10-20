package abstraksi;

public class Bebek implements Terbang, Berenang {

    @Override
    public void terbang() {
        System.out.println("Bebek terbang rendah di atas sawah.");
    }

    @Override
    public void berenang() {
        System.out.println("Bebek berenang di kolam.");
    }
}