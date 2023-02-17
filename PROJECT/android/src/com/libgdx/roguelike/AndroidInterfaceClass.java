package com.libgdx.roguelike;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AndroidInterfaceClass implements FirebaseInterface {
    FirebaseFirestore db;
    DocumentReference myRef;
    Map<String, Object> xPlayer = new HashMap<>();
    Map<String, Object> yPlayer = new HashMap<>();
    Map<String, Object> xCam = new HashMap<>();
    Map<String, Object> yCam = new HashMap<>();
    Map<String, Object> user = new HashMap<>();

    private float myX, myY, myCamX, myCamY;

    public AndroidInterfaceClass() {
        db = FirebaseFirestore.getInstance();
        myRef = db.collection("coorPlayer").document("Maposition");
    }


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

    @Override
    public void cameraX(float x) {
        myCamX = x;

        user.put("Camera X : ", x);

        myRef.set(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("OK send Camera X to db ---- " + myCamX);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(/*@NonNull */Exception e) {
                        //Toast.makeText(MainActivity3.this, "ERREUR de l'ajout", Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, e.toString());
                        System.out.println("ERROR send Camera X to db ---- ");
                    }
                });
    }

    @Override
    public void cameraY(float y) {
        myCamY = y;

        user.put("Camera Y : ", y);

        myRef.set(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("OK send Camera Y to db ---- " + myCamY);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(/*@NonNull */Exception e) {
                        //Toast.makeText(MainActivity3.this, "ERREUR de l'ajout", Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, e.toString());
                        System.out.println("ERROR send Camera Y to db ---- ");
                    }
                });
    }

    @Override
    public void getCoorX() {

    }

    @Override
    public void getCoorY() {

    }
}
