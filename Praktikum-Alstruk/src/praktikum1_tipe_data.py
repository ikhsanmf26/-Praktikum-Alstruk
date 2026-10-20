nama = "Fajar"
umur = 19
berat = 54.5
terdaftar = True

# 1. Tampilkan semua nilai variabel
print("=== Nilai Variabel ===")
print("Nama      :", nama)
print("Umur      :", umur)
print("Berat     :", berat)
print("Terdaftar :", terdaftar)

# 2. Tampilkan tipe data tiap variabel
print("\n=== Tipe Data ===")
print("Tipe nama      :", type(nama))
print("Tipe umur      :", type(umur))
print("Tipe berat     :", type(berat))
print("Tipe terdaftar :", type(terdaftar))

# 3. Ubah umur jadi 20
umur = 20
print("\n=== Setelah umur diubah jadi 20 ===")
print("Umur      :", umur)
print("Tipe umur :", type(umur))

# 4. Beda "19" dan 19
print("\n=== Beda \"19\" dan 19 ===")
print(type("19"))   # str (teks)
print(type(19))     # int (angka)
print("19" + "19")  # teks disambung -> 1919
print(19 + 19)      # angka dijumlah -> 38