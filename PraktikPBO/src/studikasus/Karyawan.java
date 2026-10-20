package studikasus;

public abstract class Karyawan {
    private String nama;          // enkapsulasi
    private String id;

    public Karyawan(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getNama() { return nama; }
    public String getId()   { return id; }

    public abstract double hitungGaji();   // abstraksi

    public void cetakSlip() {
        System.out.printf("%-6s %-12s Rp%,.0f%n", id, nama, hitungGaji());
    }
}
