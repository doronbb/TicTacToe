package com.example.TicTacToe;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fbController {
    public static FirebaseAuth mAuth;
    private Context context;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;

    public DatabaseReference getDbRef(String Ref) {
        dbRef = db.getReference(Ref);
        return dbRef;
    }

    public void setDbRef(DatabaseReference dbRef) {
        this.dbRef = dbRef;
    }

    public FirebaseDatabase getDb() {
        if(db==null)
        {
            db = FirebaseDatabase.getInstance();
        }
        return db;
    }

    public void setDb(FirebaseDatabase db) {
        this.db = db;
    }





    public fbController(Context context)
    {
        this.context = context;
        this.mAuth = FirebaseAuth.getInstance();
        this.db = FirebaseDatabase.getInstance();
    }

    public static FirebaseAuth getAuth(){
        if(mAuth == null)
            mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }


    public void CreateUser (String email, String password, User user)
    {
        getAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user.setUid(task.getResult().getUser().getUid());
                            getDbRef("Users").child(user.getUid()).setValue(user);

                            Toast.makeText(context.getApplicationContext(),"Authentication Successful",Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context.getApplicationContext(), mainActivity.class));

                        } else {
                            Toast.makeText(context.getApplicationContext(),"Authentication failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void LoginUser(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context.getApplicationContext(),"Authentication Successful",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(context,new Intent(context,mainActivity.class), null);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(context.getApplicationContext(),"Authentication failed",Toast.LENGTH_SHORT).show();

                        }
                    }});
    }

    public void LogOutUser()
    {
        mAuth.signOut();
        startActivity(context,new Intent(context,loginActivity.class), null);
    }

    public boolean isLoggedIn()
    {
        return getAuth().getCurrentUser() != null;
    }
}