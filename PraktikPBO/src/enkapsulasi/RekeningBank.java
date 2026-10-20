package enkapsulasi;

public class RekeningBank {
    // atribut disembunyikan (private)
    private String nomorRekening;
    private String pemilik;
    private double saldo;

    // constructor
    public RekeningBank(String nomorRekening, String pemilik, double saldoAwal) {
        this.nomorRekening = nomorRekening;
        this.pemilik = pemilik;
        setSaldoAwal(saldoAwal);
    }

    // getter
    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getPemilik() {
        return pemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    // setter dengan validasi
    public void setPemilik(String pemilik) {
        if (pemilik != null && !pemilik.trim().isEmpty()) {
            this.pemilik = pemilik;
        } else {
            System.out.println("Nama pemilik tidak boleh kosong!");
        }
    }

    private void setSaldoAwal(double saldoAwal) {
        this.saldo = (saldoAwal >= 0) ? saldoAwal : 0;
    }

    // perilaku (method) yang mengontrol perubahan saldo
    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setor Rp" + jumlah + " berhasil.");
        } else {
            System.out.println("Jumlah setor harus lebih dari 0.");
        }
    }

    public void tarik(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah tarik tidak valid.");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik Rp" + jumlah + " berhasil.");
        }
    }
}