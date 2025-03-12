package com.example.basketballscoretablemvi;
//mvp state
public class MainViewState {
    private int aTeamScore;
    private int bTeamScore;

    public MainViewState(int aTeamScore, int bTeamScore) {
        this.aTeamScore = aTeamScore;
        this.bTeamScore = bTeamScore;
    }

    public int getaTeamScore() {
        return aTeamScore;
    }

    public int getbTeamScore() {
        return bTeamScore;
    }
}
