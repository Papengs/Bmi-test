package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Bmi;
import model.BmiAsiaPasifik;
import model.BmiWHO;

public class BmiController {
    @FXML private TextField namaField;
    @FXML private ComboBox<String> standarBox;
    @FXML private TextField beratField;
    @FXML private TextField tinggiField;
    @FXML private Label hasilLabel;

    @FXML
    private void initialize() {
        standarBox.getItems().addAll("WHO", "Asia-Pasifik");
        standarBox.setValue("WHO");
    }

    @FXML
    private void hitung() {
        try {
            double berat = parseDesimal(beratField.getText());
            double tinggi = parseDesimal(tinggiField.getText());
            Bmi bmi;
            if ("Asia-Pasifik".equals(standarBox.getValue())) {
                bmi = new BmiAsiaPasifik(namaField.getText(), berat, tinggi);
            } else {
                bmi = new BmiWHO(namaField.getText(), berat, tinggi);
            }
            hasilLabel.setStyle("-fx-text-fill: #166534;");
            hasilLabel.setText("Nama: " + bmi.getNama()
                + "\nBMI: " + String.format("%.1f", bmi.hitungBmi())
                + "\nKategori: " + bmi.getKategori());
        } catch (NumberFormatException e) {
            tampilkanError("Berat dan tinggi harus berupa angka (contoh: 60 atau 60,5).");
        } catch (IllegalArgumentException e) {
            tampilkanError(e.getMessage());
        }
    }

    // Terima koma maupun titik sebagai pemisah desimal
    private double parseDesimal(String teks) {
        return Double.parseDouble(teks.trim().replace(',', '.'));
    }

    private void tampilkanError(String pesan) {
        hasilLabel.setStyle("-fx-text-fill: #b91c1c;");
        hasilLabel.setText(pesan);
    }
}
