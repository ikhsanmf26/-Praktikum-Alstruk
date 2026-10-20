package pbo.enkapsulasi;
public class AkunBank {
    // Variabel dikunci dengan modifier private
    private String nomorRekening;
    private double saldo;
    // Constructor
    public AkunBank(String nomorRekening, double saldoAwal) {
        this.nomorRekening = nomorRekening;
        if (saldoAwal >= 0) {
            this.saldo = saldoAwal;
        } else {
            this.saldo = 0;
        }
    }

    // Getter untuk nomorRekening
    public String getNomorRekening() {
        return nomorRekening;
    }

    // Getter untuk saldo
    public double getSaldo() {
        return saldo;
    }

    // Method operasional dengan validasi logika (Setter terproteksi)
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            System.out.println("Berhasil menyetor: Rp " + jumlah);
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0!");
        }
    }
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            this.saldo -= jumlah;
            System.out.println("Berhasil menarik: Rp " + jumlah);
        } else {
            System.out.println("Penarikan gagal! Saldo tidak mencukupi atau jumlah tidak valid.");
        }
    }
}