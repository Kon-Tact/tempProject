package com.libgdx.roguelike;

public class DesktopInterFaceClass implements FirebaseInterface{

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
    public int getCoorX() {
        final int[] returnX = {0};
        return returnX[0];
    }

    @Override
    public int getCoorY() {
        final int[] returnY = {0};
        return returnY[0];
    }
}
