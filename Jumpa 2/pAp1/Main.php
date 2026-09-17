<?php

require_once "RekeningBank.php";

// Membuat objek valid
$rekening = new RekeningBank(
    "123456789",
    "Saka",
    100000
);

echo "=== DATA AWAL ===" . PHP_EOL;
$rekening->tampilkanInfo();

// Perubahan yang sah
echo PHP_EOL . "=== SETOR Rp50.000 ===" . PHP_EOL;

$rekening->setor(50000);
$rekening->tampilkanInfo();

// Operasi tidak sah 1
echo PHP_EOL . "=== COBA TARIK Rp200.000 ===" . PHP_EOL;

try {
    $rekening->tarik(200000);
} catch (InvalidArgumentException $e) {
    echo "Ditolak: " . $e->getMessage() . PHP_EOL;
}

// Operasi tidak sah 2
echo PHP_EOL . "=== COBA SETOR -Rp50.000 ===" . PHP_EOL;

try {
    $rekening->setor(-50000);
} catch (InvalidArgumentException $e) {
    echo "Ditolak: " . $e->getMessage() . PHP_EOL;
}

// Data akhir
echo PHP_EOL . "=== DATA AKHIR ===" . PHP_EOL;
$rekening->tampilkanInfo();