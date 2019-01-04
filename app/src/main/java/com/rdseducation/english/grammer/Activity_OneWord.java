package com.rdseducation.english.grammer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity_OneWord extends AppCompatActivity implements View.OnClickListener {

    TextView tvOne1, tvOne2;
    FloatingActionButton btnMsg;
    Count count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneword);

        init();
    }

    private void init() {

        count = new Count(this);

        tvOne1 = (TextView) findViewById(R.id.tvOne1);
        tvOne2 = (TextView) findViewById(R.id.tvOne2);
        btnMsg = (FloatingActionButton)findViewById(R.id.btnMsg);
        btnMsg.setOnClickListener(this);
        tvOne1.setOnClickListener(this);
        tvOne2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnMsg:

                count.countt();
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=919116161918&text=hello%20RDS%20Education"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.tvOne1:
                count.countt();
                Intent intent4 = new Intent(Activity_OneWord.this, Activity_pdf.class);
                intent4.putExtra("EXTRA_SESSION_ID", "oneword1.pdf");
                startActivity(intent4);
//                finish();

                break;

            case R.id.tvOne2:
                count.countt();
                Intent intent5 = new Intent(Activity_OneWord.this, Activity_pdf.class);
                intent5.putExtra("EXTRA_SESSION_ID", "oneword2.pdf");
                startActivity(intent5);
//                finish();

                break;
        }
    }
}
