package com.libgdx.roguelike;

public interface FirebaseInterface {

    void sendXToDB(float x);
    void sendYToDB(float y);

    void cameraX (float x);
    void cameraY (float y);

    void getCoorX();
    void getCoorY();
}
