"""
Tantangan Terintegrasi - Program Rekap Nilai
Nama  : Ikhsan Muharam Fadil
NIM   : 10225039
Kelas : IF III C
"""

def rekap(nama, nilai_tugas, nilai_ujian):
    rata_rata = (nilai_tugas + nilai_ujian) / 2
    lulus = rata_rata >= 75
    print("Nama mahasiswa :", nama)
    print("Nilai tugas    :", nilai_tugas)
    print("Nilai ujian    :", nilai_ujian)
    print("Rata-rata      :", rata_rata)
    print("Status lulus   :", lulus)


print("=== Pengujian 1 ===")
rekap("Nadia", 80, 78)

print("\n=== Pengujian 2 ===")
rekap("Fajar", 70, 72)

print("\n=== Pengujian 3 (batas) ===")
rekap("Alya", 75, 75)