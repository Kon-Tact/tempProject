package com.libgdx.roguelike;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AndroidInterfaceClass implements FirebaseInterface {

    FirebaseFirestore db;
    CollectionReference dbRoguelike;

    public AndroidInterfaceClass() {
        db = FirebaseFirestore.getInstance();
        dbRoguelike = db.collection("Roguelike");
    }
    private float myX, myY;

    @Override
    public void sendXToDB(float x) {
        myX = x;
        Map<String, Object> user = new HashMap<>();
        user.put("nom", "toto");

        dbRoguelike.add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Toast.makeText(MainActivity3.this, "Enregistrement de " + titre, Toast.LENGTH_SHORT).show();
                        System.out.println("OK sendXYToDB -------------------- " + myX);
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
        Map<String, Object> user = new HashMap<>();
        user.put("nom", "toto");

        dbRoguelike.add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Toast.makeText(MainActivity3.this, "Enregistrement de " + titre, Toast.LENGTH_SHORT).show();
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
