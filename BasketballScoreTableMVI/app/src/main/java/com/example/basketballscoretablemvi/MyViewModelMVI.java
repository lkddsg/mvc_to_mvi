package com.example.basketballscoretablemvi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//mvi
public class MyViewModelMVI extends ViewModel {
    private final MutableLiveData<MainViewState> viewState = new MutableLiveData<>(new MainViewState(0, 0));

    public LiveData<MainViewState> getViewState() {
        return viewState;
    }

    public void processIntent(MainViewIntent intent) {
        MainViewState currentState = viewState.getValue();
        if (currentState == null) {
            currentState = new MainViewState(0, 0);
        }

        if (intent instanceof MainViewIntent.AddScoreToATeam) {
            int newScore = currentState.getaTeamScore() + ((MainViewIntent.AddScoreToATeam) intent).getScore();
            viewState.setValue(new MainViewState(newScore, currentState.getbTeamScore()));
        } else if (intent instanceof MainViewIntent.AddScoreToBTeam) {
            int newScore = currentState.getbTeamScore() + ((MainViewIntent.AddScoreToBTeam) intent).getScore();
            viewState.setValue(new MainViewState(currentState.getaTeamScore(), newScore));
        }
    }
    public void addScoreToATeam(int score) {
        processIntent(new MainViewIntent.AddScoreToATeam(score));
    }

    public void addScoreToBTeam(int score) {
        processIntent(new MainViewIntent.AddScoreToBTeam(score));
    }
}
