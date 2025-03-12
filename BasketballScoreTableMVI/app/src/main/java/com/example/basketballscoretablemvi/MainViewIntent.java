package com.example.basketballscoretablemvi;
//mvp intent
public abstract class MainViewIntent {
    public static class AddScoreToATeam extends MainViewIntent {
        private final int score;

        public AddScoreToATeam(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    public static class AddScoreToBTeam extends MainViewIntent {
        private final int score;

        public AddScoreToBTeam(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }
}
