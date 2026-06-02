public class Main {

    public static void main(String[] args) {

        // Membuat objek sistem gudang
        SistemGudang sistemGudang =
                new SistemGudang();

        // Menambahkan 3 barang baru
        sistemGudang.tambahBarangBaru(
                "B01",
                "Laptop",
                "Elektronik",
                10);

        sistemGudang.tambahBarangBaru(
                "B02",
                "Mouse",
                "Elektronik",
                20);

        sistemGudang.tambahBarangBaru(
                "B03",
                "Meja Belajar",
                "Furniture",
                5);

        // Tambah stok berhasil
        sistemGudang.tambahStok(
                "B01",
                5);

        // Kurangi stok berhasil
        sistemGudang.kurangiStok(
                "B02",
                10);

        // Kurangi stok gagal
        sistemGudang.kurangiStok(
                "B03",
                20);

        // Cetak laporan akhir
        sistemGudang.cetakLaporan();
    }
}