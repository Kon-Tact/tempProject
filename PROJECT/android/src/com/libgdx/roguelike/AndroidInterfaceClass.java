package com.libgdx.roguelike;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AndroidInterfaceClass implements FirebaseInterface {
    FirebaseFirestore db;
    CollectionReference dbRoguelike;
    DocumentReference myRef;
    Map<String, Object> user = new HashMap<>();

    public AndroidInterfaceClass() {
        db = FirebaseFirestore.getInstance();
        dbRoguelike = db.collection("coorPlayer");
        myRef = dbRoguelike.document("Ma position");
        myRef = db.collection("coorPlayer").document("Maposition");
    }
    private float myX, myY;

    @Override
    public void sendXToDB(float x) {
        myX = x;

        user.put("X : ", x);

        myRef.set(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("OK sendXToDB -------------------- " + myX);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(/*@NonNull */Exception e) {
                        //Toast.makeText(MainActivity3.this, "ERREUR de l'ajout", Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, e.toString());
                        System.out.println("ERROR sendXYToDB ----------------------" + myX);
                    }
                });
    }

    public void sendYToDB(float y) {
        myY = y;

        user.put("Y : ", y);

        myRef.set(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("OK sendYToDB -------------------- " + myY);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(/*@NonNull */Exception e) {
                        //Toast.makeText(MainActivity3.this, "ERREUR de l'ajout", Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, e.toString());
                        System.out.println("ERROR sendYToDB ----------------------" + myY);
                    }
                });
    }
}
