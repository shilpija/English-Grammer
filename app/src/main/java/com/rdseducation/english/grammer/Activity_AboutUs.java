package com.rdseducation.english.grammer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_AboutUs extends AppCompatActivity implements View.OnClickListener {

    TextView tvNo,tvMail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        init();
    }

    private void init() {

        tvNo = (TextView)findViewById(R.id.tvNo);
        tvMail = (TextView)findViewById(R.id.tvMail);
        tvNo.setOnClickListener(this);
        tvMail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvNo:

                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=919116161918&text=hello%20RDS%20Education"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;

            case R.id.tvMail:

                Intent intent1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("rdseducationapp@gmail.com"));
                intent1.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
                intent1.putExtra(Intent.EXTRA_TEXT, "The message");
                try {
                    startActivity(intent1);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Mail account not configured", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
