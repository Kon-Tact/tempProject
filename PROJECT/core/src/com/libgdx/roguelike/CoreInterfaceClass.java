package com.libgdx.roguelike;

public class CoreInterfaceClass implements FirebaseInterface{

    public void sendXToDB(float x) {

    };
    public void sendYToDB(float y){

    }

    @Override
    public void cameraX(float x) {

    }

    @Override
    public void cameraY(float y) {

    }

    @Override
    public float getCoorX(float x) {;
        return x;
    }

    @Override
    public float getCoorY(float y) {
        return y;
    }
}
