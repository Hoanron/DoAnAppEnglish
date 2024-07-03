package com.example.doanapphoctienganh.LearnToRead;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.doanapphoctienganh.R;

import java.util.ArrayList;
import java.util.List;
public class ReadListActivity extends AppCompatActivity {

    FrameLayout FL_DSBaiViet;
    ListReadsHandle vietHandle;
    EditText txt_TimKiem;
    ImageButton btn_TimKiem,btn_QuayLai;
    private List<String> mList=new ArrayList<>();
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_read_list);
        loadFragment(new FragmentListRead());

        txt_TimKiem=(EditText) findViewById(R.id.txt_searchRead);
        btn_TimKiem=(ImageButton) findViewById(R.id.btn_findread);
        btn_QuayLai=(ImageButton) findViewById(R.id.btn_back);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFragment(new FragmentListRead());
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.FL_ListRead,fragment);
        ft.commit();
    }
}