/**
 * Sesi 3 — constructor berdelegasi, anggota statis, dan konstanta.
 *
 * Invariant:
 * 1. saldo tidak pernah negatif
 * 2. nomor rekening tidak berubah setelah objek dibuat
 * 3. setoran dan penarikan selalu bernilai positif
 */
public class RekeningBank {

    // TODO 1: ganti tiga angka ajaib berikut menjadi konstanta bernama
    // (public static final). Setelah itu, tidak boleh ada lagi
    // angka literal di dalam badan method.
    // - bunga tahunan : 0.025
    // - biaya administrasi : 5000
    // - batas penarikan sekali : 5000000

    public static final double bunga_tahunan = 0.025;
    public static final double Biaya_adm = 5000;
    public static final double batas_penarikan_sekali = 5000000;

    // TODO 2: deklarasikan field statis penghitung jumlah rekening.
    // Perhatikan: static, privat, dan bernilai awal 0.

    private static int JumlahRekening = 0;

    private final String nomor;
    private final String pemilik;
    private double saldo;

    /**
     * Constructor ringkas.
     * TODO 3: DELEGASIKAN ke constructor lengkap dengan this(...).
     * Jangan menyalin validasi ke sini.
     */
    public RekeningBank(String nomor, String pemilik) {
        // TODO 3 — ganti baris di bawah dengan delegasi
        this(nomor, pemilik, 0);
    }

    /** Constructor lengkap — SATU-SATUNYA tempat validasi berada. */
    public RekeningBank(String nomor, String pemilik, double saldoAwal) {
        // TODO 4: tolak nomor kosong dan saldo awal negatif.

        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldoAwal;

        // TODO 5: naikkan penghitung jumlah rekening DI SINI SAJA.
        // Pikirkan mengapa bukan di kedua constructor.

        JumlahRekening++;
    }

    public void setor(double jumlah) {
        // TODO 6: tolak jumlah <= 0, lalu tambahkan ke saldo.

        if (jumlah <= 0) {
            throw new IllegalArgumentException("jumlah setoran haruf positif");
        }
        saldo += jumlah;
    }

    public void tarik(double jumlah) {
        // TODO 7: tolak jumlah <= 0, tolak jika melebihi saldo,
        // dan tolak jika melebihi batas penarikan sekali transaksi.

        if (jumlah <= 0) {
            throw new IllegalArgumentException("jumlah penarikan harus positif");
        }
        if (jumlah > saldo) {
            throw new IllegalArgumentException("saldo tidak cukup");
        }
        if (jumlah > batas_penarikan_sekali) {
            throw new IllegalArgumentException("melebihi batas penarikan sekali");
        }
        saldo -= jumlah;
    }

    /**
     * TODO 8: kurangi saldo sebesar biaya administrasi, tetapi jangan sampai
     * negatif.
     */
    public void potongBiayaAdmin() {
        saldo = Math.max(0, saldo - Biaya_adm);
    }

    /** TODO 9: method statis — kembalikan jumlah rekening yang pernah dibuat. */
    public static int getJumlahRekening() {
        return JumlahRekening;
    }

    /**
     * TODO 10: method statis utilitas — hitung bunga setahun dari pokok.
     * Perhatikan: method ini tidak membaca keadaan objek mana pun.
     * Itulah alasan ia pantas menjadi static.
     */
    public static double bungaSetahun(double pokok) {
        return pokok * bunga_tahunan;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomor() {
        return nomor;
    }

    @Override
    public String toString() {
        return String.format("Rekening[%s] %-14s Rp%,.2f", nomor, pemilik, saldo);
    }
}
