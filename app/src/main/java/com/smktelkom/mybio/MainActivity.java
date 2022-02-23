package com.smktelkom.mybio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText setNama, setKelas, setTanggalLahir, setTempatLahir, setAlamat, setHobi;
    Spinner setJK;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTanggalLahir = (EditText) findViewById(R.id.setTanggalLahir);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        setTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        setNama = findViewById(R.id.setNama);
        setKelas = findViewById(R.id.setKelas);
        setTempatLahir = findViewById(R.id.setTempatLahir);
        setTanggalLahir = findViewById(R.id.setTanggalLahir);
        setJK = (Spinner) findViewById(R.id.setJK);
        setAlamat = findViewById(R.id.setAlamat);
        setHobi = findViewById(R.id.setHobi);

        Button btnTampil = findViewById(R.id.button);
        btnTampil.setOnClickListener(this);

        Button btnHapus = (Button) findViewById(R.id.button2);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNama.setText("");
                setKelas.setText("");
                setTempatLahir.setText("");
                setTanggalLahir.setText("");
                setAlamat.setText("");
                setHobi.setText("");
            }
        });
    }

    private void showDateDialog() {
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                setTanggalLahir.setText(dateFormatter.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityTampil.class);
        intent.putExtra("nama", setNama.getText().toString());
        intent.putExtra("kelas", setKelas.getText().toString());
        intent.putExtra("ttl", setTempatLahir.getText().toString());
        intent.putExtra("ttl2", setTanggalLahir.getText().toString());
        intent.putExtra("jk", setJK.getSelectedItem().toString());
        intent.putExtra("alamat", setAlamat.getText().toString());
        intent.putExtra("hobi", setHobi.getText().toString());
        startActivity(intent);
    }
}
