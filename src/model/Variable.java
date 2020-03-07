package model;

public class Variable {
    private int myIndex;
    private String myName;
    private double myValue;

    public Variable(int index, String name, double value){
        myIndex = index;
        myName = name;
        myValue = value;
    }

    public void updateVariable( double value){
        myValue = value;
    }
    public void updateVariable(String name){
        myName = name;
    }
    public String getName(){
        return myName;
    }
    public double getVal(){
        return myValue;
    }

}
