public class Main {
    public static void main(String[] args) {
        RekeningBank rekening = new RekeningBank(
            "123456789",
            "Saka",
            100000
        );

        System.out.println("=== DATA AWAL ===");
        rekening.tampilkanInfo();

        System.out.println("\n=== SETOR Rp50.000 ===");
        rekening.setor(50000);
        rekening.tampilkanInfo();

        System.out.println("\n=== COBA TARIK Rp200.000 ===");
        try {
            rekening.tarik(200000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ditolak: " + e.getMessage());
        }

        System.out.println("\n=== COBA SETOR -Rp50.000 ===");
        try {
            rekening.setor(-50000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ditolak: " + e.getMessage());
        }

        System.out.println("\n=== DATA AKHIR ===");
        rekening.tampilkanInfo();
    }

    static class RekeningBank {
        private String nomorRekening;
        private String namaPemilik;
        private double saldo;

        public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
            this.nomorRekening = nomorRekening;
            this.namaPemilik = namaPemilik;
            this.saldo = saldo;
        }

        public void setor(double jumlah) {
            if (jumlah <= 0) {
                throw new IllegalArgumentException("Jumlah setor harus lebih dari 0.");
            }
            saldo += jumlah;
        }

        public void tarik(double jumlah) {
            if (jumlah <= 0) {
                throw new IllegalArgumentException("Jumlah tarik harus lebih dari 0.");
            }
            if (jumlah > saldo) {
                throw new IllegalArgumentException("Saldo tidak mencukupi.");
            }
            saldo -= jumlah;
        }

        public void tampilkanInfo() {
            System.out.println("Nomor Rekening: " + nomorRekening);
            System.out.println("Nama Pemilik: " + namaPemilik);
            System.out.println("Saldo: Rp" + saldo);
        }
    }
}