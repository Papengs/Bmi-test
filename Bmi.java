package model;

public abstract class Bmi {

    private final String nama;
    private final double beratKg;
    private final double tinggiCm;

    public Bmi(String nama, double beratKg, double tinggiCm) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama wajib diisi.");
        }

        if (!(beratKg > 0)) {
            throw new IllegalArgumentException("Berat badan harus lebih dari nol.");
        }

        if (!(tinggiCm > 0)) {
            throw new IllegalArgumentException("Tinggi badan harus lebih dari nol.");
        }

        this.nama = nama.trim();
        this.beratKg = beratKg;
        this.tinggiCm = tinggiCm;
    }

    public String getNama() {
        return nama;
    }

    public double getBeratKg() {
        return beratKg;
    }

    public double getTinggiCm() {
        return tinggiCm;
    }

    // Rumus sama untuk semua standar: berat / (tinggi dalam meter)^2
    public double hitungBmi() {
        double tinggiM = tinggiCm / 100.0;
        return beratKg / (tinggiM * tinggiM);
    }

    // Beda tiap standar -> dibuat abstract (polimorfisme)
    public abstract String getKategori();
}
