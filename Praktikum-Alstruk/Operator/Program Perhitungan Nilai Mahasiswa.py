# Program Perhitungan Nilai Mahasiswa

# 1. Meminta input nama mahasiswa
nama_mahasiswa = input("Masukkan nama mahasiswa: ")

# 2. Meminta input nilai tugas, UTS, dan UAS
tugas = float(input("Masukkan nilai Tugas: "))
uts = float(input("Masukkan nilai UTS: "))
uas = float(input("Masukkan nilai UAS: "))

# 3. Menghitung nilai akhir dengan bobot
# Tugas 30%, UTS 30%, UAS 40%
nilai_akhir = (tugas * 0.30) + (uts * 0.30) + (uas * 0.40)

# Menentukan status kelulusan
if nilai_akhir >= 60:
    status = "Lulus"
else:
    status = "Belum Lulus"

# Menampilkan hasil
print()
print("==Perhitungan Nilai Mahasiswa==")
print()
print("Nama   :", nama_mahasiswa)
print("Nilai  :", nilai_akhir)
print("Status :", status)