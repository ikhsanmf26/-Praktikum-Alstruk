"""
Praktikum 1 - Mengenali Tipe Data
Nama  : Ikhsan_Muharam_Fadil
NIM   : 10225039
Kelas : IF_II_C
"""

nama = "Muna"
umur = 19
berat = 54.5
terdaftar = True

# 1. Tampilkan semua nilai variabel
print("=== Nilai Variabel ===")
print("Nama      :", nama)
print("Umur      :", umur)
print("Berat     :", berat)
print("Terdaftar :", terdaftar)

# 2. Tampilkan tipe data setiap variabel
print("\n=== Tipe Data ===")
print("Tipe nama      :", type(nama))
print("Tipe umur      :", type(umur))
print("Tipe berat     :", type(berat))
print("Tipe terdaftar :", type(terdaftar))

# 3. Ubah nilai umur menjadi 20
umur = 20
print("\n=== Setelah umur diubah menjadi 20 ===")
print("Umur      :", umur)
print("Tipe umur :", type(umur))

# 4. Perbedaan "19" dan 19
print("\n=== Perbedaan \"19\" dan 19 ===")
print(type("19"))  # str
print(type(19))    # int
print("19" + "19")  # penggabungan teks -> 1919
print(19 + 19)      # penjumlahan angka -> 38