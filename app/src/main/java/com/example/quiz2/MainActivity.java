package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.quiz2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bt1.setOnClickListener(v -> {
            HitungHarga();
        });


    }

    private void HitungHarga() {
        String jam = binding.et1.getText().toString();
        if (jam.isEmpty())
        {
            Toast.makeText(this, "Masukkan jumlah jam yang akan di pesan", Toast.LENGTH_SHORT).show();
        }

        int jumlahjam= Integer.parseInt(jam);
        int hargaperjam = 0;
        if (binding.rbps1.isChecked())
        {
            hargaperjam = 10000;
        } else if (binding.rbps2.isChecked()) {
            hargaperjam = 8000;
        }
        else if (binding.rbps3.isChecked()) {
            hargaperjam = 5000;
        }
        else if (binding.rbps4.isChecked()) {
            hargaperjam = 20000;
        }
        else {
            Toast.makeText(this, "Pilih jenis PS yang akan dipesan", Toast.LENGTH_SHORT).show();
        }

        int hargatambahan = 0;
        if (binding.rbadt1.isChecked())
        {
            hargatambahan = 7000;

        } else if (binding.rbadt2.isChecked()) {
            hargatambahan = 10000;
        }
        else if (binding.rbadt3.isChecked()) {
            hargatambahan = 5000;
        }
        int hargaakhir = (jumlahjam * hargaperjam) + hargatambahan;

        Invoice invoice = new Invoice();
        invoice.setType(getTypePs());
        invoice.setTambahan(getTypeadt());
        invoice.setWaktu(jam);
        invoice.setTotal(Integer.toString(hargaakhir));


        Intent intent = new Intent(this, InvoiceActivity.class);
        intent.putExtra(InvoiceActivity.KEY_DATA, invoice);
        startActivity(intent);

    }

    private String getTypeadt() {
        if (binding.rbadt1.isChecked()) {
            return "Indomie : Rp 7.000";
        } else if (binding.rbadt2.isChecked()) {
            return "Mie ayam : Rp 10.000";
        } else if (binding.rbadt3.isChecked()) {
            return "Somay : Rp 5.000";
        } else
        {
            return  "Tidak ada makanan yang dipesan";
        }
    }

    private String getTypePs() {
        if (binding.rbps1.isChecked()) {
            return "Type : PS 5 (Rp 10.000)";
        } else if (binding.rbps2.isChecked()) {
            return "Type : PS 4 (Rp 8.000)";
        } else if (binding.rbps3.isChecked()) {
            return "Type : PS 3 (Rp 5.000)";
        } else {
            return "Type : PS VR (Rp 20.000)";
        }
    }
}