package com.rdseducation.english.grammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Grammer extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llIdomsVisible, llIdomsGone, llOneVisible, llOneGone, llAntonyms, llPhrasal, llRoot, llSynonyms, llVocablaries;
    boolean Idoms = false;
    boolean One = false;
    ImageView ivBadTop, ivBadBottom, ivOneTop, ivOneBottom;
    TextView tvIdom1, tvIdom2, tvIdom3, tvOne1, tvOne2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammer);

        init();

    }

    private void init() {

        llIdomsVisible = (LinearLayout) findViewById(R.id.llIdomsVisible);
        llIdomsGone = (LinearLayout) findViewById(R.id.llIdomsGone);
        llOneVisible = (LinearLayout) findViewById(R.id.llOneVisible);
        llOneGone = (LinearLayout) findViewById(R.id.llOneGone);
        llAntonyms = (LinearLayout) findViewById(R.id.llAntonyms);
        llPhrasal = (LinearLayout) findViewById(R.id.llPhrasal);
        llRoot = (LinearLayout) findViewById(R.id.llRoot);
        llSynonyms = (LinearLayout) findViewById(R.id.llSynonyms);
        llVocablaries = (LinearLayout) findViewById(R.id.llVocablaries);
        ivBadBottom = (ImageView) findViewById(R.id.ivBadBottom);
        ivBadTop = (ImageView) findViewById(R.id.ivBadTop);
        ivOneTop = (ImageView) findViewById(R.id.ivOneTop);
        ivOneBottom = (ImageView) findViewById(R.id.ivOneBottom);

        tvIdom1 = (TextView) findViewById(R.id.tvIdom1);
        tvIdom2 = (TextView) findViewById(R.id.tvIdom2);
        tvIdom3 = (TextView) findViewById(R.id.tvIdom3);
        tvOne1 = (TextView) findViewById(R.id.tvOne1);
        tvOne2 = (TextView) findViewById(R.id.tvOne2);

        llIdomsVisible.setOnClickListener(this);
        llOneVisible.setOnClickListener(this);
        llAntonyms.setOnClickListener(this);
        tvIdom1.setOnClickListener(this);
        tvIdom2.setOnClickListener(this);
        tvIdom3.setOnClickListener(this);
        tvOne1.setOnClickListener(this);
        llPhrasal.setOnClickListener(this);
        tvOne2.setOnClickListener(this);
        llRoot.setOnClickListener(this);
        llSynonyms.setOnClickListener(this);
        llVocablaries.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llIdomsVisible:

                if (!Idoms) {
                    ivBadTop.setVisibility(View.GONE);
                    ivBadBottom.setVisibility(View.VISIBLE);
                    llIdomsGone.setVisibility(View.VISIBLE);
                    Idoms = true;
                } else if (Idoms) {
                    ivBadTop.setVisibility(View.VISIBLE);
                    ivBadBottom.setVisibility(View.GONE);
                    llIdomsGone.setVisibility(View.GONE);
                    Idoms = false;
                }

                break;

            case R.id.llOneVisible:

                if (!One) {
                    ivOneTop.setVisibility(View.GONE);
                    ivOneBottom.setVisibility(View.VISIBLE);
                    llOneGone.setVisibility(View.VISIBLE);
                    One = true;
                } else if (One) {
                    ivOneTop.setVisibility(View.VISIBLE);
                    ivOneBottom.setVisibility(View.GONE);
                    llOneGone.setVisibility(View.GONE);
                    One = false;
                }

                break;

            case R.id.llAntonyms:

                Intent intent = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent.putExtra("EXTRA_SESSION_ID", "ant.pdf");
                startActivity(intent);

                break;

            case R.id.tvIdom1:

                Intent intent1 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent1.putExtra("EXTRA_SESSION_ID", "idom1.pdf");
                startActivity(intent1);

                break;

            case R.id.tvIdom2:

                Intent intent2 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent2.putExtra("EXTRA_SESSION_ID", "idom2.pdf");
                startActivity(intent2);

                break;

            case R.id.tvIdom3:

                Intent intent3 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent3.putExtra("EXTRA_SESSION_ID", "idom3.pdf");
                startActivity(intent3);

                break;

            case R.id.tvOne1:

                Intent intent4 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent4.putExtra("EXTRA_SESSION_ID", "oneword1.pdf");
                startActivity(intent4);

                break;

            case R.id.tvOne2:

                Intent intent5 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent5.putExtra("EXTRA_SESSION_ID", "oneword2.pdf");
                startActivity(intent5);

                break;

            case R.id.llPhrasal:

                Intent intent6 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent6.putExtra("EXTRA_SESSION_ID", "phrasal.pdf");
                startActivity(intent6);

                break;

            case R.id.llRoot:

                Intent intent7 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent7.putExtra("EXTRA_SESSION_ID", "root.pdf");
                startActivity(intent7);

                break;

            case R.id.llSynonyms:

                Intent intent8 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent8.putExtra("EXTRA_SESSION_ID", "syn.pdf");
                startActivity(intent8);

                break;

            case R.id.llVocablaries:

                Intent intent9 = new Intent(Activity_Grammer.this, Activity_pdf.class);
                intent9.putExtra("EXTRA_SESSION_ID", "voc.pdf");
                startActivity(intent9);

                break;
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Activity_Grammer.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

}
