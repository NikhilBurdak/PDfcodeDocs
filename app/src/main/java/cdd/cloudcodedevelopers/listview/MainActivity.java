package cdd.cloudcodedevelopers.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.nebclass12organicchemistrynotes.app.R;
import com.nebclass12organicchemistrynotes.app.databinding.ActivityMainBinding;

import java.util.ArrayList;

import cdd.cloudcodedevelopers.listview.Admob.Admob;

public class MainActivity extends AppCompatActivity {

    ArrayList<CategoryModel> list;
    CategoryAdapter adapter;
    RecyclerView recyclerView;
    SearchView search_view;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView menu;
    View header;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();



        recyclerView = findViewById(R.id.recyclerView);

        Admob.loadBannerAd(findViewById(R.id.bannerAd),MainActivity.this);

        menu = findViewById(R.id.menu);
        navigationView = (NavigationView)findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);


        list = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list.add(new CategoryModel("Go language",R.drawable.grad3,R.drawable.vertical_back, R.color.black));
        list.add(new CategoryModel("Web development",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));
        list.add(new CategoryModel("Python",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("c++ notes",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));
        list.add(new CategoryModel("c programing",R.drawable.grad5,R.drawable.ver5,R.color.black));

        list.add(new CategoryModel("Microsoft Sql",R.drawable.grad3,R.drawable.vertical_back, R.color.black));
        list.add(new CategoryModel("Matlab",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));
        list.add(new CategoryModel("Linux",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("jquary",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));

        list.add(new CategoryModel("Java",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));
        list.add(new CategoryModel("Angular",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));
        list.add(new CategoryModel("CSS",R.drawable.grad5,R.drawable.ver5,R.color.black));
        list.add(new CategoryModel("Excel",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("Git notes",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("Haskel",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("Android",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));
        list.add(new CategoryModel("Entity framework",R.drawable.grad3,R.drawable.vertical_back, R.color.black));
        list.add(new CategoryModel("Hibranate",R.drawable.grad5,R.drawable.ver5,R.color.black));
        list.add(new CategoryModel("HTML5",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));
        list.add(new CategoryModel("IOS notes",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));




        adapter = new CategoryAdapter(list,this);       recyclerView.setAdapter(adapter);

        header = navigationView.getHeaderView(0);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else {

                    drawerLayout.openDrawer(GravityCompat.START);
                }


            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){


                    case R.id.home:

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.share:

                        String shareBody = "Hey, I am using best app for computer science notes";
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.rate:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/games?pli=1")));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }


                return true;
            }
        });


    }
}