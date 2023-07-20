package cdd.cloudcodedevelopers.listview;

import static cdd.cloudcodedevelopers.listview.Admob.Admob.showAdmobInterstitial;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nebclass12organicchemistrynotes.app.R;
import com.nebclass12organicchemistrynotes.app.databinding.ActivityShowPdfBinding;

import cdd.cloudcodedevelopers.listview.Admob.Admob;

public class ShowPdfActivity extends AppCompatActivity {

    ActivityShowPdfBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowPdfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        Admob.loadBannerAd(findViewById(R.id.bannerAd),ShowPdfActivity.this);


        showAdmobInterstitial(ShowPdfActivity.this,true);

        int position = getIntent().getIntExtra("pos",0);
        String chapter = getIntent().getStringExtra("name");

        binding.toolBarName.setText(chapter);

        if (position==0){
            binding.pdfView.fromAsset("Go language.pdf").load();
        }
        else if (position==1){
            binding.pdfView.fromAsset("Web development.pdf").load();
        }
        else if (position==2){
            binding.pdfView.fromAsset("PYTHON.pdf").load();
        }
        else if (position==3){
            binding.pdfView.fromAsset("c++.pdf").load();
        }
        else if (position==4){
            binding.pdfView.fromAsset("c programing.pdf").load();
        }
        else if (position==5){
            binding.pdfView.fromAsset("Microsoft Sql.pdf").load();
        }
        else if (position==6){
            binding.pdfView.fromAsset("Matlab.pdf").load();
        }
        else if (position==7){
            binding.pdfView.fromAsset("Linux.pdf").load();
        }
        else if (position==8){
            binding.pdfView.fromAsset("jquery.pdf").load();
        }
        else if (position==9){
            binding.pdfView.fromAsset("Java.pdf").load();
        }
        else if (position==10){
            binding.pdfView.fromAsset("Angular.pdf").load();
        }
        else if (position==11){
            binding.pdfView.fromAsset("CSS.pdf").load();
        }
        else if (position==12){
            binding.pdfView.fromAsset("Excel").load();
        }
        else if (position==13){
            binding.pdfView.fromAsset("Git notes.pdf").load();
        }
        else if (position==14){
            binding.pdfView.fromAsset("Haskel.pdf").load();
        }
        else if (position==15){
            binding.pdfView.fromAsset("Android.pdf").load();
        }
        else if (position==16){
            binding.pdfView.fromAsset("Entity framework.pdf").load();
        }
        else if (position==17){
            binding.pdfView.fromAsset("Hibernate.pdf").load();
        }
        else if (position==18){
            binding.pdfView.fromAsset("HTML5.pdf").load();
        }
        else if (position==19){
            binding.pdfView.fromAsset("IOS notes.pdf").load();
        }

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {

        showAdmobInterstitial(ShowPdfActivity.this,true);
        super.onBackPressed();
    }

}