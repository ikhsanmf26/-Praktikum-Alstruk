package pewarisan;

public class MainPewarisan {
    public static void main(String[] args) {
        Manajer m = new Manajer("Siti Aminah", 10000000, 5000000);
        Programmer p = new Programmer("Andi Pratama", 7000000, 3);

        m.tampilkanData();     // method warisan dari Pegawai
        m.pimpinRapat();       // method milik sendiri
        System.out.println("-----------------------------");
        p.tampilkanData();
        p.menulisKode();
    }
}