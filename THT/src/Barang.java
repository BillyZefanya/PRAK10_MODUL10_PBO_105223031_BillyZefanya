public class Barang {

    // Data barang
    String idBarang;
    String namaBarang;
    String kategori;
    int stok;

    // Constructor
    public Barang(String idBarang, String namaBarang,
                  String kategori, int stok) {

        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.stok = stok;
    }
}