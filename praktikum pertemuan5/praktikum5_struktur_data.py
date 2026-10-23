"""
Praktikum 5 - Struktur Data Dasar
Nama  : ...
NIM   : ...
Kelas : ...
"""

nilai = [78, 85, 90, 85]
mahasiswa = {"nama": "Nadia", "kelas": "IF-A"}
koordinat = (5, 8)
angka = {2, 4, 4, 6, 8}

print("1. Nilai pertama list   :", nilai[0])

nilai.append(95)
print("2. List terbaru         :", nilai)

print("3. Nama mahasiswa       :", mahasiswa["nama"])
print("4. Koordinat pertama    :", koordinat[0])
print("5. Angka unik (sorted)  :", sorted(angka))
print("   Isi set asli         :", angka)