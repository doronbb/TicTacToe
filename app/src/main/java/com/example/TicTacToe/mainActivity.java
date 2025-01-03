package com.example.TicTacToe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class mainActivity extends AppCompatActivity {

    TextView tvMessage;

    FloatingActionButton btnAdd;
    MenuItem Settings;
    fbController auth = new fbController(mainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //addList check
        Intent addIntent = new Intent(mainActivity.this, hostActivity.class);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Game> games = new ArrayList<>();
        for (int i = 1; i < 11; i++)
        {
            games.add(new Game("Game "+ i, "Host: "));
        }
        RecyclerView recyclerView = findViewById(R.id.rvGames);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        GameAdapter gameAdapter = new GameAdapter(games);
        recyclerView.setAdapter(gameAdapter);


        tvMessage = findViewById(R.id.tvMessage);

        btnAdd = findViewById(R.id.btnHost);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mainActivity.this.startActivity(addIntent);

            }
        });
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemID = item.getItemId();

        if(itemID == R.id.Settings){
            openSettings();
        }
        if(itemID == R.id.LogOut){
            auth.LogOutUser();
        }
        if(itemID == R.id.Main){
            gotoMain();
        }

        return super.onOptionsItemSelected(item);
    }

    private void gotoMain(){

        Intent i;
        i = new Intent(this, mainActivity.class);
        this.startActivity(i);
    }

    private void openSettings(){

        Intent i;
        i = new Intent(this, settingsActivity.class);
        this.startActivity(i);

    }

    private void LogOut(){
        Intent i;
        i = new Intent(this, loginActivity.class);
        this.startActivity(i);
    }
}