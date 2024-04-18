package com.example.applotery;

import android.widget.TextView;
import java.util.Random;

public class Numbers {

    private int n1, n2, n3, n4, n5, n6;

    public Numbers() {
        n1 = 0;
        n2 = 0;
        n3 = 0;
        n4 = 0;
        n5 = 0;
        n6 = 0;
    }

    public void createNumbers(TextView Number1, TextView Number2, TextView Number3, TextView Number4, TextView Number5, TextView Number6) {
        Random random = new Random();
        n1 = random.nextInt(60) + 1;
        n2 = random.nextInt(60) + 1;
        n3 = random.nextInt(60) + 1;
        n4 = random.nextInt(60) + 1;
        n5 = random.nextInt(60) + 1;
        n6 = random.nextInt(60) + 1;

        Number1.setText(String.valueOf(n1));
        Number2.setText(String.valueOf(n2));
        Number3.setText(String.valueOf(n3));
        Number4.setText(String.valueOf(n4));
        Number5.setText(String.valueOf(n5));
        Number6.setText(String.valueOf(n6));
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getN6() {
        return n6;
    }

    public void setN6(int n6) {
        this.n6 = n6;
    }

}