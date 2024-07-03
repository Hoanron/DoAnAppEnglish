package com.example.doanapphoctienganh.LearnToRead;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanapphoctienganh.R;

public class ReadTestActivity extends AppCompatActivity {

    TextView tvNodung;
    ReadExercise read= new ReadExercise();
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_test);

        Bundle bundle = getIntent().getBundleExtra("package");
        read.setId( bundle.getInt("id"));
        read.setTenBaiDoc(bundle.getString("tenBai"));
        read.setNoiDungBaiDoc(bundle.getString("noiDung"));
        read.setIdBaiHoc(bundle.getInt("idBaiHoc"));
        tvNodung = (TextView) findViewById(R.id.tvContent);
        btnStart = (Button) findViewById(R.id.btnStart);

        tvNodung.setText(read.getNoiDungBaiDoc());
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ReadTestDetailsActivity.class);
                Bundle bundle= new Bundle();
                bundle.putInt("id", read.getId());
                bundle.putInt("idBaiHoc", read.getIdBaiHoc());
                bundle.putString("tenBai", read.getTenBaiDoc());
                bundle.putString("noiDung", read.getNoiDungBaiDoc());
                myintent.putExtra("package",bundle);
                startActivity(myintent);
            }
        });
    }
}