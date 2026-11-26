package com.moyaa.uts

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val identitas = findViewById<TextView>(R.id.tvIdentitasLaundry)
        val rincian = findViewById<TextView>(R.id.tvRincianLaundry)
        val hasil = findViewById<TextView>(R.id.tvTagihanLaundry)
        val namaPelanggan = intent.getStringExtra(EXTRA_NAMA_PELANGGAN) ?: ""
        val kodeNota = intent.getStringExtra(EXTRA_KODE_NOTA) ?: ""
        val beratKg = intent.getIntExtra(EXTRA_BERAT_KG, 0)
        val biayaAwal = intent.getIntExtra(EXTRA_BIAYA_AWAL, 0)
        val potongan = intent.getIntExtra(EXTRA_POTONGAN, 0)
        val bayarAkhir = intent.getIntExtra(EXTRA_BAYAR_AKHIR, 0)

        identitas.text = "Nama Pelanggan: $namaPelanggan\nKode Nota: $kodeNota\nBerat Cucian: $beratKg kg"
        rincian.text = "Biaya Awal: Rp $biayaAwal\nPotongan: Rp $potongan"
        hasil.text = "Total Bayar: Rp $bayarAkhir"
    }
}
