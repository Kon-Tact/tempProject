package com.libgdx.roguelike;


import android.util.Log;

import androidx.annotation.NonNull;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AndroidInterfaceClass implements FirebaseInterface {
    FirebaseFirestore db;
    DocumentReference refCoorX, refCoorY, refCamX, refCamY;
    Map<String, Object> playX = new HashMap<>();
    Map<String, Object> playY = new HashMap<>();
    Map<String, Object> CamX = new HashMap<>();
    Map<String, Object> CamY = new HashMap<>();

    private float myX, myY, myCamX, myCamY;

    public AndroidInterfaceClass() {
        db = FirebaseFirestore.getInstance();
        refCoorX = db.collection("coorPlayer").document("PlayerPosX");
        refCoorY = db.collection("coorPlayer").document("PlayerPosY");
        refCamX = db.collection("coorCam").document("CamPosX");
        refCamY = db.collection("coorCam").document("CamPosY");
    }


    @Override
    public void sendXToDB(float x) {
        myX = x;

        playX.put("playerPosX ", x);

        refCoorX.set(playX)
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

        playY.put("PlayerPosY ", y);

        refCoorY.set(playY)
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

        CamX.put("camPosX ", x);

        refCamX.set(CamX)
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

        CamY.put("camPosY ", y);

        refCamY.set(CamY)
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
    public float getCoorX(float x) {

        final int[] returnX = {0};
        refCoorX.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot doc = task.getResult();
                            if (doc.exists()) {
                                Log.d("TAG", "Document Snapshot data: " + doc.getData());
                                String value = String.valueOf(doc.getData().values());
                                Matcher matcher = Pattern.compile("\\d+").matcher(value);
                                if ( matcher.find() ) {
                                    returnX[0] = Integer.parseInt(matcher.group(0));
                                    System.out.println("Coor Y dans la méthode " + returnX[0]);
                                }
                                else {
                                    System.out.println("Cette valeur n'existe pas");
                                }
                            } else {
                                Log.d("TAG", "Ce document n'existe pas");
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
        return x = returnX[0];
    }

    @Override
    public float getCoorY(float y) {

        final int[] returnY = {0};
        refCoorY.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot doc = task.getResult();
                            if (doc.exists()) {
                                Log.d("TAG", "Document Snapshot data: " + doc.getData());
                                String value = String.valueOf(doc.getData().values());
                                System.out.println(value);
                                Matcher matcher = Pattern.compile("\\d+").matcher(value);
                                if ( matcher.find() ) {
                                    returnY[0] = Integer.parseInt(matcher.group(0));
                                    System.out.println("Coor Y dans la méthode " + returnY[0]);
                                }
                                else {
                                    System.out.println("Cette valeur n'existe pas");
                                }

                            } else {
                                Log.d("TAG", "No such document");
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
        return y = returnY[0];
    }
}
