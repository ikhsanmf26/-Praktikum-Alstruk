"""
Praktikum 3 - Operator Perbandingan dan Logika
Nama  : ...
NIM   : ...
Kelas : ...
"""

def cek(nilai, kehadiran):
    syarat_nilai = nilai >= 75
    syarat_hadir = kehadiran >= 80
    lulus_and = syarat_nilai and syarat_hadir
    lulus_or = syarat_nilai or syarat_hadir
    print(f"Nilai = {nilai}, Kehadiran = {kehadiran}")
    print("  Nilai >= 75      :", syarat_nilai)
    print("  Kehadiran >= 80  :", syarat_hadir)
    print("  Lulus (and)      :", lulus_and)
    print("  Lulus (or)       :", lulus_or)


print("=== Data awal ===")
cek(82, 90)

print("\n=== Nilai diubah menjadi 70 ===")
cek(70, 90)