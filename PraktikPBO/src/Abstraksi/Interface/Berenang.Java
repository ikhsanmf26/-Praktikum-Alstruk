package abstraksi;

public interface Berenang {
    void berenang();

    default void selam() {       // default method (Java 8+)
        System.out.println("Menyelam di bawah air...");
    }
}
Beb
