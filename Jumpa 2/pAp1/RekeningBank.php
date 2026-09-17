<?php

class RekeningBank
{
    private string $nomorRekening;
    private string $namaPemilik;
    private float $saldo;

    public function __construct(
        string $nomorRekening,
        string $namaPemilik,
        float $saldo
    ) {
        if (empty($nomorRekening)) {
            throw new InvalidArgumentException(
                "Nomor rekening tidak boleh kosong."
            );
        }

        if ($saldo < 0) {
            throw new InvalidArgumentException(
                "Saldo tidak boleh kurang dari 0."
            );
        }

        $this->nomorRekening = $nomorRekening;
        $this->namaPemilik = $namaPemilik;
        $this->saldo = $saldo;
    }

    public function tampilkanInfo(): void
    {
        echo "Nomor Rekening : " . $this->nomorRekening . PHP_EOL;
        echo "Nama Pemilik   : " . $this->namaPemilik . PHP_EOL;
        echo "Saldo          : Rp" . $this->saldo . PHP_EOL;
    }

    public function setor(float $jumlah): void
    {
        if ($jumlah <= 0) {
            throw new InvalidArgumentException(
                "Jumlah setor harus lebih dari 0."
            );
        }

        $this->saldo += $jumlah;
    }

    public function tarik(float $jumlah): void
    {
        if ($jumlah <= 0) {
            throw new InvalidArgumentException(
                "Jumlah penarikan harus lebih dari 0."
            );
        }

        if ($jumlah > $this->saldo) {
            throw new InvalidArgumentException(
                "Saldo tidak mencukupi."
            );
        }

        $this->saldo -= $jumlah;
    }
}