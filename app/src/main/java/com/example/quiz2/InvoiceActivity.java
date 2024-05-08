package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.quiz2.databinding.ActivityInvoiceBinding;
import com.example.quiz2.databinding.ActivityMainBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class InvoiceActivity extends AppCompatActivity {

    private ActivityInvoiceBinding binding;
    public static final String KEY_DATA = "key_data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        binding = ActivityInvoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Invoice invoice = getIntent().getParcelableExtra(KEY_DATA);

        String tipeps = invoice.getType();
        binding.ettype.setText(tipeps);
        String tambahan = invoice.getTambahan();
        binding.ettambahan.setText(tambahan);
        String waktu = "Waktu : " + invoice.getWaktu() + " jam";
        binding.etwaktu.setText(waktu);

        int totalHarga = Integer.parseInt(invoice.getTotal());
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String total = "Total : " + formatRupiah.format(totalHarga);
        binding.ettotal.setText(total);



    }
}