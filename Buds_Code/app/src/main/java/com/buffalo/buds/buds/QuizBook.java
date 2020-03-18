package com.buffalo.buds.buds;

import android.widget.Button;

public class QuizBook {

    public String[] mQuestions = new String[]  {
            "Calculate 2+2 = ?",
            "Which animal is this ?",
            "What is this shape known as ?",
            "Which English Alphabet is this ?",
            "What is the name of this reptile ?",
            "Calculate 5/5 = ?",
            "Which Hindi Alphabet is this ?",
            "Which English Alphabet is this ?",
            "What is this shape known as ?",
            "Which Hindi Alphabet is this ?"
    };

    public int[] mImages = new int[] {R.drawable.q1,R.drawable.q2,R.drawable.q3,R.drawable.q4,R.drawable.q5,R.drawable.q6,
            R.drawable.q7,R.drawable.q8,R.drawable.q9,R.drawable.q10};

    public  String[][] mChoices = new String[][]{
            {"8","6","4","2"},
            {"Tiger","Leopard","Panther","Lion"},
            {"Star","Rhombus","Circle","Square"},
            {"O","C","Q","G"},
            {"Turtles","Alligator","Lizard","Snake"},
            {"1","0","0.5","5"},
            {"AAO","AAA","OOO","AUU"},
            {"U","W","Y","V"},
            {"Circle","Traingle","SemiCircle","Star"},
            {"BHA","MMA","LLA","PPA"},
    };

    public String[] mAnswers = new String[] {
            "4","Lion","Star","Q","Snake","1","AAA","Y","Circle","BHA"
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public int getImages(int a){
        int images = mImages[a];
        return images;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getAnswer(int a) {
        String answer = mAnswers[a];
        return answer;
    }
}

