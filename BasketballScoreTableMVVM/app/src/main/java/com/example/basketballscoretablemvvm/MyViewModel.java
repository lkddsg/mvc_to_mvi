package com.example.basketballscoretablemvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//MVVM
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;

    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null) {
            synchronized (this) {
                if (aTeamScore == null) {
                    aTeamScore = new MutableLiveData<>();
                    aTeamScore.setValue(0);
                }
            }
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null) {
            synchronized (this) {
                if (bTeamScore == null) {
                    bTeamScore = new MutableLiveData<>();
                    bTeamScore.setValue(0);
                }
            }
        }
        return bTeamScore;
    }
    public void aTeamAdd(int p){
        aTeamScore.setValue(aTeamScore.getValue()+p);
    };
    public void bTeamAdd(int p){
        bTeamScore.setValue(bTeamScore.getValue()+p);
    };
}

