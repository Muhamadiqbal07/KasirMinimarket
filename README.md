# Sistem Kasir Minimarket Berbasis Java
## Deskripsi
Sistem Kasir Minimarket merupakan aplikasi berbasis Java yang dirancang untuk mensimulasikan proses transaksi penjualan pada minimarket seperti Alfamart atau Indomaret. Sistem ini menerapkan konsep Pemrograman Berorientasi Objek (Object-Oriented Programming/OOP) dan menghasilkan struk transaksi yang dapat ditampilkan di console maupun disimpan ke dalam file `.txt`.

## Fitur
- Login kasir menggunakan username dan password.
- Menu utama sistem kasir.
- Input transaksi barang.
- Validasi kode barang 13 digit.
- Input lebih dari satu barang dalam satu transaksi.
- Perhitungan subtotal otomatis.
- Perhitungan diskon/voucher.
- Perhitungan total belanja.
- Perhitungan uang tunai dan kembalian.
- Pencetakan struk transaksi.
- Penyimpanan struk ke file `.txt`.
- Pembuatan folder struk secara otomatis.
- Pembuatan kode transaksi unik.
- Menampilkan tanggal dan waktu transaksi.

## Struktur Project
```
KasirMinimarket/
│
├── src/
│   ├── Barang.java
│   ├── Kasir.java
│   ├── KasirMember.java
│   ├── Login.java
│   ├── Transaksi.java
│   ├── Utilitas.java
│   └── Main.java
│
├── struk/
│   └── (hasil output transaksi)
│
├── docs/
│   └── Laporan Sistem Kasir.pdf
│
├── README.md
└── .gitignore
```
## Konsep OOP yang Digunakan
### 1. Class dan Object
Class yang digunakan:
   - Barang
   - Kasir
   - KasirMember
   - Login
   - Transaksi
   - Utilitas
### 2. Constructor
Contoh:
`public Barang(String kodeBarang, String namaBarang, double harga, int qty)`
### 3. Method
Contoh:
- `getSubtotal()`
- `cetakStruk()`
- `simpanStrukTxt()`
### 4. Method Overloading
Contoh:
- `cetakStruk(Kasir kasir, double bayar)`
- `cetakStruk(Kasir kasir, double bayar, double voucher)`
### 5. Inheritance
`KasirMember extends Kasir`
### 6. Polymorphism
`Kasir kasir = login.autentikasi(username, password);`
### 7. Access Modifier
- `private`
- `protected`
- `public`
### 8. Exception Handling
```java
try {
  ...
} catch(Exception e) {
  ...
}
```

## Format Login
Contoh data kasir:
| Kode Kasir | Nama Kasir | Username | Password |
| --- | --- | --- | --- |
| KS001 | Andriyawan | andri | 09876 |
| KS002 | Muhamad Iqbal | iqbal | 10293 |

## Tampilan Menu Utama
```
===== SISTEM KASIR MINIMARKET =====
1. Input transaksi dan print struk
2. Keluar
Pilih :
```
## Format Input Barang
```
Kode Barang (13 digit):
Nama Barang :
Harga :
Qty :
Ingin menginput lagi (Y/T)? :
```
## Format Struk Transaksi
```
----- STRUK TRANSAKSI -----
2026-06-24 09:30:15 / 1.0.0 / KQ-7162 / Andriyawan / KS001
------------------------------------------------------------------
NAMA BARANG   QTY   HARGA   SUBTOTAL
Indomie       2     3500      7000
Aqua          1     5000      5000
Roti          1     12000    12000
              VOUCHER/DISKON : 0
------------------------------------------------------------------
              TOTAL BELANJA : 24000
------------------------------------------------------------------
                      TUNAI : 50000
                    KEMBALI : 26000
                  ANDA HEMAT : 0
=== TERIMA KASIH TELAH BERBELANJA ===
```

## Format Nama File Struk
Nama file dibuat berdasarkan tanggal dan waktu transaksi.
Contoh:
`Struk_2026-06-24_09-30-15.txt`. Lokasi penyimpanan:
```
KasirMinimarket/
│
└── struk/
    └── Struk_2026-06-24_14-30-15.txt
```

## Pembuat
Projek ini dibuat oleh:
- Andriyawan (2025310026)
- Muhamad Iqbal Eka Ramadhan (2025310030)
