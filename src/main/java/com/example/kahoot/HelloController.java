package com.example.kahoot;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    ToggleGroup toggleGroup=new ToggleGroup();
    public Label questionLabel;
    public Button btnNext;
    int i=0;
    ArrayList<String> qutions=new ArrayList<>();
    ArrayList<String> optionA=new ArrayList<>();
    ArrayList<String> optionB=new ArrayList<>();
    ArrayList<String> optionC=new ArrayList<>();
    ArrayList<String> optionD=new ArrayList<>();
    ArrayList<String> answer=new ArrayList<>();

    ArrayList<String> userAnswer=new ArrayList<>();

    public RadioButton ansA;
    public RadioButton ansB;
    public RadioButton ansC;
    public RadioButton ansD;


    public void onNext(MouseEvent mouseEvent) {
        if(toggleGroup.getSelectedToggle().isSelected()&&i<qutions.size()){
        userAnswer.add( String.valueOf(toggleGroup.getSelectedToggle().getUserData()));}
       else{userAnswer.add(null);}

        if(i<qutions.size()-1){i++;showQution(i);}
        if(i==10){
           for(int j=0;j<answer.size();j++){
               Boolean b=answer.get(j).equals(userAnswer.get(j));
               System.out.println(b+"\nRight Answer : "+answer.get(j)+"\nYour Answer : "+userAnswer.get(j) ); }
        }
        if(i==9){btnNext.setText("Submit");i++;}
    }

    public void onPrev(MouseEvent mouseEvent) {
        if(i!=0){
        i--;
        showQution(i);}
        if(i==9){btnNext.setText("Submit");}
        else{btnNext.setText("Next");}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ansA.setToggleGroup(toggleGroup);
        ansB.setToggleGroup(toggleGroup);
        ansC.setToggleGroup(toggleGroup);
        ansD.setToggleGroup(toggleGroup);
        qutions.add("1.Number of primitive data types in Java are?");
        qutions.add("2.What is the size of float and double in java?");
        qutions.add("3. Automatic type conversion is possible in which of the possible cases?");
        qutions.add("4. Find the output of the following code.");
        qutions.add("5. Find the output of the following program.");
        qutions.add("6. Find the output of the following program.");
        qutions.add("7. Select the valid statement.");
        qutions.add("8. Find the output of the following program.");
        qutions.add("9. When an array is passed to a method, what does the method receive?");
        qutions.add("10. Select the valid statement to declare and initialize an array.");

        answer.add("8");answer.add("32 and 64");answer.add("int to long");answer.add("24I");answer.add("Compile error");
        answer.add("-127");answer.add("char[]ch=char[5]");answer.add("120 200 14");answer.add("The reference of Array");answer.add("int [] A={1,2,3}");

        optionA.add("6"); optionB.add("7");optionC.add("8"); optionD.add("9");
        optionA.add("32 and 64"); optionB.add("32 and 32");optionC.add("64 and 32"); optionD.add("64 and 64");
        optionA.add("Byte to int"); optionB.add("int to long");optionC.add("long to int"); optionD.add("short to int");
        optionA.add("Compile error"); optionB.add("Throws Excption");optionC.add("I"); optionD.add("24I");
        optionA.add("50"); optionB.add("10");optionC.add("Compile error"); optionD.add("Excption");
        optionA.add("-127"); optionB.add("127");optionC.add("29"); optionD.add("2");
        optionA.add("char[]ch=new char(5)"); optionB.add("char[]ch=char[5]");optionC.add("char[]ch=new char[]"); optionD.add("char[]ch=new char()");
        optionA.add("120 200 016"); optionB.add("120 200 14");optionC.add("120 200 16"); optionD.add("None");
        optionA.add("The reference of Array"); optionB.add("A copy of Array");optionC.add("Length of Array"); optionD.add("Copy of first Element");
        optionA.add("int [] A={}"); optionB.add("int [] A={1,2,3}");optionC.add("int [] A=(1,2,3)"); optionD.add("int [][] A={1,2,3}");
        showQution(i);
    }
    public void showQution(int index){
        questionLabel.setText(qutions.get(index));
        ansA.setText(optionA.get(index));
        ansB.setText(optionB.get(index));
        ansC.setText(optionC.get(index));
        ansD.setText(optionD.get(index));
        ansA.setUserData(optionA.get(index));
        ansB.setUserData(optionB.get(index));
        ansC.setUserData(optionC.get(index));
        ansD.setUserData(optionD.get(index));
    }
}