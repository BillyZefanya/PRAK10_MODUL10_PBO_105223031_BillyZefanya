import java.util.*;

// Class Buku digunakan untuk menyimpan data buku
class Buku {

    String isbn;
    String judul;

    // Constructor buku
    public Buku(String isbn, String judul) {

        this.isbn = isbn;
        this.judul = judul;
    }

    // Method tampil buku
    public void tampilkanBuku() {

        System.out.println("ISBN  : " + isbn);
        System.out.println("Judul : " + judul);
    }
}

// Class Anggota digunakan untuk menyimpan data anggota
class Anggota {

    String idAnggota;
    String nama;
    String tipe;

    // Constructor anggota
    public Anggota(
            String idAnggota,
            String nama,
            String tipe
    ) {

        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    // Override equals agar object dengan id sama dianggap sama
    @Override
    public boolean equals(Object objectLain) {

        if (this == objectLain) {

            return true;
        }

        if (objectLain == null
                || getClass()
                != objectLain.getClass()) {

            return false;
        }

        Anggota anggota =
                (Anggota) objectLain;

        return idAnggota.equals(
                anggota.idAnggota
        );
    }

    // Override hashCode
    @Override
    public int hashCode() {

        return Objects.hash(idAnggota);
    }

    // Method tampil anggota
    public void tampilkanAnggota() {

        System.out.println(
                idAnggota
                        + " - "
                        + nama
                        + " - "
                        + tipe
        );
    }
}

// Class utama
public class LatihanCollection {

    public static void main(String[] args) {

        // Soal 1

        System.out.println("SOAL 1");

        // HashMap digunakan untuk pencarian cepat berdasarkan ISBN
        HashMap<String, Buku> katalogBuku =
                new HashMap<>();

        // Membuat objek buku
        Buku buku1 =
                new Buku("BK001", "Java Dasar");

        Buku buku2 =
                new Buku("BK002", "PBO Java CS 23");

        Buku buku3 =
                new Buku("BK003", "Struktur Data");

        // Memasukkan buku ke HashMap
        katalogBuku.put(buku1.isbn, buku1);
        katalogBuku.put(buku2.isbn, buku2);
        katalogBuku.put(buku3.isbn, buku3);

        // Cari buku berdasarkan ISBN
        Buku hasilCari =
                katalogBuku.get("BK002");

        // Menampilkan hasil pencarian
        hasilCari.tampilkanBuku();

        // Soal 2

        System.out.println("\nSOAL 2");

        // HashSet digunakan agar tidak ada data duplikat
        HashSet<Anggota> daftarAnggota =
                new HashSet<>();

        // Membuat anggota
        Anggota anggota1 =
                new Anggota(
                        "AG001",
                        "Yosafat",
                        "Mahasiswa"
                );

        Anggota anggota2 =
                new Anggota(
                        "AG002",
                        "Billy",
                        "Dosen"
                );

        Anggota anggota3 =
                new Anggota(
                        "AG003",
                        "Hardy",
                        "Mahasiswa"
                );

        // Anggota duplikat
        Anggota anggota4 =
                new Anggota(
                        "AG001",
                        "Arvin",
                        "Dosen"
                );

        // Menambahkan anggota ke HashSet
        daftarAnggota.add(anggota1);
        daftarAnggota.add(anggota2);
        daftarAnggota.add(anggota3);

        // Akan otomatis ditolak
        daftarAnggota.add(anggota4);

        // Menampilkan anggota
        for (Anggota anggota : daftarAnggota) {

            anggota.tampilkanAnggota();
        }

        // Soal 3

        System.out.println("\nSOAL 3");

        // Deque digunakan agar bisa tambah depan dan belakang
        Deque<String> antreanPeminjaman =
                new LinkedList<>();

        // Mahasiswa masuk belakang
        antreanPeminjaman.addLast(
                "AG001#BK001"
        );

        // Dosen masuk depan
        antreanPeminjaman.addFirst(
                "AG002#BK002"
        );

        // Mahasiswa masuk belakang
        antreanPeminjaman.addLast(
                "AG003#BK003"
        );

        // Dosen masuk depan
        antreanPeminjaman.addFirst(
                "AG002#BK001"
        );

        // Menampilkan antrean
        System.out.println(
                "Antrean Peminjaman"
        );

        for (String antrean
                : antreanPeminjaman) {

            System.out.println(antrean);
        }

        // Soal 4

        System.out.println("\nSOAL 4");

        // HashSet digunakan untuk menyimpan buku yang sedang dipinjam
        HashSet<String> bukuSedangDipinjam =
                new HashSet<>();

        // Memproses antrean dari depan sampai habis
        while (!antreanPeminjaman.isEmpty()) {

            // Mengambil antrean paling depan
            String dataAntrean =
                    antreanPeminjaman.pollFirst();

            // Memecah string berdasarkan #
            String[] hasilSplit =
                    dataAntrean.split("#");

            String idAnggota =
                    hasilSplit[0];

            String isbn =
                    hasilSplit[1];

            boolean anggotaDitemukan = false;

            // Mengecek apakah anggota ada
            for (Anggota anggota : daftarAnggota) {

                if (
                        anggota.idAnggota.equals(
                                idAnggota
                        )
                ) {

                    anggotaDitemukan = true;
                    break;
                }
            }

            // Mengecek apakah buku ada
            boolean bukuDitemukan =
                    katalogBuku.containsKey(isbn);

            // Mengecek apakah buku sedang dipinjam
            boolean bukuSudahDipinjam =
                    bukuSedangDipinjam.contains(isbn);

            // Validasi peminjaman
            if (!anggotaDitemukan) {

                System.out.println(
                        "Peminjaman ditolak karena anggota tidak terdaftar : "
                                + idAnggota
                );
            }

            else if (!bukuDitemukan) {

                System.out.println(
                        "Peminjaman ditolak karena ISBN tidak ditemukan : "
                                + isbn
                );
            }

            else if (bukuSudahDipinjam) {

                System.out.println(
                        "Peminjaman ditolak karena buku sedang dipinjam : "
                                + isbn
                );
            }

            else {

                // Menambahkan buku ke daftar sedang dipinjam
                bukuSedangDipinjam.add(isbn);

                System.out.println(
                        "Peminjaman berhasil : "
                                + idAnggota
                                + " meminjam "
                                + isbn
                );
            }
        }

        // Menampilkan buku yang sedang dipinjam
        System.out.println(
                "\nDaftar Buku Sedang Dipinjam"
        );

        for (String isbn
                : bukuSedangDipinjam) {

            System.out.println(isbn);
        }
    }
}