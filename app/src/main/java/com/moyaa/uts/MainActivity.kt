package com.moyaa.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

const val EXTRA_NAMA_PELANGGAN = "EXTRA_NAMA_PELANGGAN"
const val EXTRA_KODE_NOTA = "EXTRA_KODE_NOTA"
const val EXTRA_BERAT_KG = "EXTRA_BERAT_KG"
const val EXTRA_BIAYA_AWAL = "EXTRA_BIAYA_AWAL"
const val EXTRA_POTONGAN = "EXTRA_POTONGAN"
const val EXTRA_BAYAR_AKHIR = "EXTRA_BAYAR_AKHIR"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kolomPelanggan = findViewById<EditText>(R.id.etPelanggan)
        val kolomNota = findViewById<EditText>(R.id.etNota)
        val kolomBerat = findViewById<EditText>(R.id.etBerat)
        val aksiLaundry = findViewById<Button>(R.id.btnProsesLaundry)

        aksiLaundry.setOnClickListener {
            val namaPelanggan = kolomPelanggan.text.toString().trim()
            val kodeNota = kolomNota.text.toString().trim()

            if (namaPelanggan.isEmpty()) {
                kolomPelanggan.error = "Wajib diisi"
                return@setOnClickListener
            }
            if (kodeNota.isEmpty()) {
                kolomNota.error = "Wajib diisi"
                return@setOnClickListener
            }

            val beratStr = kolomBerat.text.toString().trim()
            val beratKg = beratStr.toIntOrNull()
            if (beratKg == null || beratKg !in 1..12) {
                kolomBerat.error = "Berat harus 1-12 kg"
                return@setOnClickListener
            }

            val tarifPerKg: Int = 8500
            val biayaAwal: Int = beratKg * tarifPerKg
            val potongan: Int = if (beratKg >= 6) (biayaAwal * 10) / 100 else 0
            val bayarAkhir: Int = biayaAwal - potongan
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(EXTRA_NAMA_PELANGGAN, namaPelanggan)
            intent.putExtra(EXTRA_KODE_NOTA, kodeNota)
            intent.putExtra(EXTRA_BERAT_KG, beratKg)
            intent.putExtra(EXTRA_BIAYA_AWAL, biayaAwal)
            intent.putExtra(EXTRA_POTONGAN, potongan)
            intent.putExtra(EXTRA_BAYAR_AKHIR, bayarAkhir)
            startActivity(intent)
        }
    }
}
