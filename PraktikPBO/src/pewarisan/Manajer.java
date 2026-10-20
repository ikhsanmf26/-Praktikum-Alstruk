package pewarisan;

public class Manajer extends Pegawai {
    private double tunjanganJabatan;

    public Manajer(String nama, double gajiPokok, double tunjanganJabatan) {
        super(nama, gajiPokok);          // memanggil constructor induk
        this.tunjanganJabatan = tunjanganJabatan;
    }

    @Override
    public double hitungGaji() {
        return super.hitungGaji() + tunjanganJabatan;
    }

    public void pimpinRapat() {          // method khusus Manajer
        System.out.println(nama + " sedang memimpin rapat.");
    }
}