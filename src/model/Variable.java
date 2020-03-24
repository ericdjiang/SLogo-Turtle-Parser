package model;

/**
 * Stores information for a singluar variable
 */
public class Variable {
    private int myIndex;
    private String myName;
    private double myValue;

    /**
     * Constructor
     * @param index index of variable
     * @param name name of variable
     * @param value number value of variable
     */
    public Variable(int index, String name, double value){
        myIndex = index;
        myName = name;
        myValue = value;
    }

    /**
     * Sets the variable
     * @param value of the variable to be set
     */
    public void updateVariable( double value){
        myValue = value;
    }

    /**
     * Updates the name of the variable
     * @param name of the variable
     */
    public void updateVariable(String name){
        myName = name;
    }

    /**
     * @return variable name
     */
    public String getName(){
        return myName;
    }

    /**
     * @return value stored in the variable
     */
    public double getVal(){
        return myValue;
    }

}
