package com.m1m2.geoquiz.qa_manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vinayreddypolati on 2/10/17.
 */

public class Repository {
    int count = 0;
    private HashMap<String,Boolean> questions;
    public Repository(){
        this.questions = new HashMap<String,Boolean>();
        initializeRepository();
    }

    public String getRandomQuestion(){
        String randomQuestion = new String();
        int randomNumber = (int)(Math.random()*questions.size());
        Iterator itr = questions.entrySet().iterator();
        int num = 0;
        while(itr.hasNext()){
            if(num == randomNumber){
                randomQuestion = ((Map.Entry)itr.next()).getKey().toString();
                break;
            }itr.next();
            num++;
        }
        return randomQuestion;
    }
    /* check if question is already in repository and add only if it doesn't exist*/
    public boolean addQuestion(String question,Boolean answer){
           if(questions.containsKey(question))
               return false;
           else {
               questions.put(question,answer);
               return  true;
           }
    }

    public boolean isCorrectAnswer(String question,Boolean answer){
        if(questions.get(question).equals(answer))
            return true;
        else
            return false;
    }

    /* override question if its in there & return true, return false otherwise */
    public boolean updateQuestion(String question,Boolean answer){
           if(!questions.containsKey(question))
               return  false;
           else{
               questions.put(question,answer);
               return true;
           }
    }

    private void initializeRepository(){
        /* initialize repository with some questions
       source: https://matadornetwork.com/life/can-answer-21-geography-questions-everyone-know-quiz/*/
         String question1 = "Iceland is covered in ice?";
         Boolean answer1 = false;
          questions.put(question1,answer1);
        String question2 = "Atlantic ocean lies on the east coast of the United States";
        Boolean answer2 = true;
          questions.put(question2,answer2);
        String question3 = "Mount Everest is the world's highest mountain";
        Boolean answer3 = true;
          questions.put(question3,answer3);
        String question4 = "There are 6 Great Lakes";
        Boolean answer4 = false;
          questions.put(question4,answer4);
        String question5 = "Missouri River is the longest river in the U.S.A";
        Boolean answer5 = true;
          questions.put(question5,answer5);

    }
}
