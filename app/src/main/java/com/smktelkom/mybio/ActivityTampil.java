package com.smktelkom.mybio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityTampil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        if (getIntent() != null) {
            TextView nama = (TextView) findViewById(R.id.outNama);
            TextView kelas = (TextView) findViewById(R.id.outKelas);
            TextView ttl1 = (TextView) findViewById(R.id.outTTL);
            TextView space = (TextView) findViewById(R.id.space);
            TextView ttl2 = (TextView) findViewById(R.id.outTTL2);
            TextView jk = (TextView) findViewById(R.id.outJK);
            TextView alamat = (TextView) findViewById(R.id.outAlamat);
            TextView hobi = (TextView) findViewById(R.id.outHobi);

            nama.setText(getIntent().getStringExtra("nama"));
            kelas.setText(getIntent().getStringExtra("kelas"));
            ttl1.setText(getIntent().getStringExtra("ttl"));
            space.setText(", ");
            ttl2.setText(getIntent().getStringExtra("ttl2"));
            jk.setText(getIntent().getStringExtra("jk"));
            alamat.setText(getIntent().getStringExtra("alamat"));
            hobi.setText(getIntent().getStringExtra("hobi"));
        }
    }
}