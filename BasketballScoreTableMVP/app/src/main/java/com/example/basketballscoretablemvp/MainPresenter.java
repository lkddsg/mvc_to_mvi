package com.example.basketballscoretablemvp;

//mvp
public class MainPresenter {
    private MainView view;
    private int aTeamScore = 0;
    private int bTeamScore = 0;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void addScoreToATeam(int score) {
        aTeamScore += score;
        view.updateATeamScore(aTeamScore);
    }

    public void addScoreToBTeam(int score) {
        bTeamScore += score;
        view.updateBTeamScore(bTeamScore);
    }
}
