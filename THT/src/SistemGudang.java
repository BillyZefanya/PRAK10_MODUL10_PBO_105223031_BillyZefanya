import java.util.*;

public class SistemGudang {

    // Database utama barang
    private Map<String, Barang> databaseBarang;

    // Menyimpan kategori unik
    private Set<String> kategoriUnik;

    // Menyimpan riwayat aktivitas
    private List<String> riwayatAktivitas;

    // Constructor
    public SistemGudang() {

        databaseBarang = new HashMap<>();
        kategoriUnik = new HashSet<>();
        riwayatAktivitas = new ArrayList<>();
    }

    // Menambah barang baru ke gudang
    public void tambahBarangBaru(String idBarang,
                                 String namaBarang,
                                 String kategori,
                                 int stok) {

        Barang barangBaru =
                new Barang(idBarang,
                           namaBarang,
                           kategori,
                           stok);

        databaseBarang.put(idBarang, barangBaru);

        kategoriUnik.add(kategori);

        riwayatAktivitas.add(
                "Barang Baru : "
                        + idBarang
                        + " - "
                        + namaBarang
                        + " ditambahkan dengan stok "
                        + stok);
    }

    // Menambah stok barang
    public void tambahStok(String idBarang,
                           int jumlahTambahanStok) {

        if (databaseBarang.containsKey(idBarang)) {

            Barang barang =
                    databaseBarang.get(idBarang);

            barang.stok =
                    barang.stok + jumlahTambahanStok;

            riwayatAktivitas.add(
                    "Barang Masuk : "
                            + idBarang
                            + " ditambah "
                            + jumlahTambahanStok
                            + " unit");
        } else {

            System.out.println(
                    "ID Barang tidak ditemukan.");
        }
    }

    // Mengurangi stok barang
    public void kurangiStok(String idBarang,
                            int jumlahPenguranganStok) {

        if (databaseBarang.containsKey(idBarang)) {

            Barang barang =
                    databaseBarang.get(idBarang);

            if (barang.stok >= jumlahPenguranganStok) {

                barang.stok =
                        barang.stok
                                - jumlahPenguranganStok;

                riwayatAktivitas.add(
                        "Barang Keluar : "
                                + idBarang
                                + " dikurangi "
                                + jumlahPenguranganStok
                                + " unit");

            } else {

                System.out.println(
                        "Stok tidak mencukupi.");

                riwayatAktivitas.add(
                        "Gagal Mengurangi Stok : "
                                + idBarang
                                + " karena stok tidak mencukupi");
            }

        } else {

            System.out.println(
                    "ID Barang tidak ditemukan.");

            riwayatAktivitas.add(
                    "Gagal Mengurangi Stok : "
                            + idBarang
                            + " karena ID tidak ditemukan");
        }
    }

    // Menampilkan laporan akhir
    public void cetakLaporan() {

        System.out.println();
        System.out.println("LAPORAN GUDANG");

        System.out.println();
        System.out.println("Daftar Kategori:");

        for (String kategori : kategoriUnik) {

            System.out.println("- " + kategori);
        }

        System.out.println();
        System.out.println("Data Barang:");

        for (Barang barang : databaseBarang.values()) {

            System.out.println(
                    "ID : " + barang.idBarang
                            + " | Nama : " + barang.namaBarang
                            + " | Kategori : " + barang.kategori
                            + " | Stok : " + barang.stok);
        }

        System.out.println();
        System.out.println("Riwayat Aktivitas:");

        for (String aktivitas : riwayatAktivitas) {

            System.out.println(aktivitas);
        }
    }
}