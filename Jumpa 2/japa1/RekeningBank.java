public class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        if (nomorRekening == null || nomorRekening.isEmpty()) {
            throw new IllegalArgumentException("Nomor rekening tidak boleh kosong.");
        }

        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo tidak boleh kurang dari 0.");
        }

        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik   : " + namaPemilik);
        System.out.println("Saldo          : Rp" + saldo);
    }

    public void setor(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException(
                "Jumlah setor harus lebih dari 0."
            );
        }

        saldo += jumlah;
    }

    public void tarik(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException(
                "Jumlah penarikan harus lebih dari 0."
            );
        }

        if (jumlah > saldo) {
            throw new IllegalArgumentException(
                "Saldo tidak mencukupi."
            );
        }

        saldo -= jumlah;
    }
}