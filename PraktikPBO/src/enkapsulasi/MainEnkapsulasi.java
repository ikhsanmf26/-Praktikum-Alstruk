package enkapsulasi;

public class MainEnkapsulasi {
    public static void main(String[] args) {
        RekeningBank rek = new RekeningBank("1234567890", "Ikhsan Muharam Fadil", 500000);

        System.out.println("Pemilik : " + rek.getPemilik());
        System.out.println("Saldo   : Rp" + rek.getSaldo());

        rek.setor(250000);
        rek.tarik(1000000);   // ditolak: saldo tidak cukup
        rek.tarik(300000);
        rek.setPemilik("");   // ditolak: nama kosong

        System.out.println("Saldo akhir: Rp" + rek.getSaldo());

        // rek.saldo = 999999999;  // ERROR: saldo has private access
    }
}
