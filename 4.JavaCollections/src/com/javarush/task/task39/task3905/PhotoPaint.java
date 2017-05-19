package com.javarush.task.task39.task3905;

import java.util.Arrays;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
        if(desiredColor==null)return false;
        if(c >= image.length||r>=image[0].length ){
            return false;
        }else if(image[c][r]==desiredColor){
            return false;

        }else {
            image[c][r]=desiredColor;
            /*for(int i=c;i<image.length;i++){
                for(int j=r;j<image[c].length;j++){
                    if(image[j][i]!=desiredColor) {
                        image[j][i] = desiredColor;
                    }
                }
            }*/
            return true;
        }
    }
}
