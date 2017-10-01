package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface StarsView {

    int STAR_ONE=1;
    int STAR_TWO=2;
    int STAR_TRHEE=3;
    int STAR_FOUR=4;
    int STAR_FIVE=5;

    String ACTION_CLEAR_STAR="ACTION_CLEAR_STAR";
    String ACTION_FILL_HALF_STAR="ACTION_FILL_HALF_STAR";
    String ACTION_FILL_STAR="ACTION_FILL_STAR";

    void setRanking(String ranking);
    void workStar(String action, int starNumber);

}
