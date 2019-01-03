package com.rdseducation.english.grammer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity_Idoms extends AppCompatActivity implements View.OnClickListener {

    TextView tvIdom1, tvIdom2, tvIdom3;
    FloatingActionButton btnMsg;
    Count count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idoms);

        init();
    }

    private void init() {

        count = new Count(this);
        tvIdom1 = (TextView) findViewById(R.id.tvIdom1);
        tvIdom2 = (TextView) findViewById(R.id.tvIdom2);
        tvIdom3 = (TextView) findViewById(R.id.tvIdom3);
        btnMsg = (FloatingActionButton)findViewById(R.id.btnMsg);
        btnMsg.setOnClickListener(this);
        tvIdom1.setOnClickListener(this);
        tvIdom2.setOnClickListener(this);
        tvIdom3.setOnClickListener(this);
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
            case R.id.tvIdom1:
                count.countt();
                Intent intent1 = new Intent(Activity_Idoms.this, Activity_pdf.class);
                intent1.putExtra("EXTRA_SESSION_ID", "idom1.pdf");
                startActivity(intent1);
                finish();
                break;

            case R.id.tvIdom2:
                count.countt();
                Intent intent2 = new Intent(Activity_Idoms.this, Activity_pdf.class);
                intent2.putExtra("EXTRA_SESSION_ID", "idom2.pdf");
                startActivity(intent2);
                finish();
                break;

            case R.id.tvIdom3:
                count.countt();
                Intent intent3 = new Intent(Activity_Idoms.this, Activity_pdf.class);
                intent3.putExtra("EXTRA_SESSION_ID", "idom3.pdf");
                startActivity(intent3);
                finish();
                break;

        }
    }
}
