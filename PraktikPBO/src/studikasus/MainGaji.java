package studikasus;

import java.util.ArrayList;
import java.util.List;

public class MainGaji {
    public static void main(String[] args) {
        List<Karyawan> daftar = new ArrayList<>();   // polimorfisme
        daftar.add(new KaryawanTetap("K001", "Rina", 8000000, 1500000));
        daftar.add(new KaryawanKontrak("K002", "Doni", 50000, 160));
        daftar.add(new KaryawanTetap("K003", "Maya", 9000000, 2000000));

        double total = 0;
        System.out.println("=== SLIP GAJI BULAN INI ===");
        for (Karyawan k : daftar) {
            k.cetakSlip();
            total += k.hitungGaji();
        }
        System.out.printf("Total pengeluaran gaji: Rp%,.0f%n", total);
    }
}