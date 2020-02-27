package model;

import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariableModel {

    private HashMap<String, Double> myMap;
    private List myVariableNames;
    private List myVariableVals;
    private boolean isNewVarAdded;

    public VariableModel(){
        myMap = new HashMap<>();
        myVariableNames = new ArrayList();
        myVariableVals = new ArrayList();
    }

    public void updateVariable(String variableName, double value){
        isNewVarAdded = true;
        myMap.put(variableName,value);
        myVariableNames.add(variableName);
        myVariableVals.add(value);
        System.out.println(variableName + value);
    }


    public boolean checkIfVariableExists(String variableName){
        return myMap.containsKey(variableName);
    }

    public double getValue(String variableName){
        return myMap.get(variableName);
    }

    public double addVariables(String variable1, String variable2){
        double varival = myMap.get(variable1);
        double varival2 = myMap.get(variable2);
        double sum = varival +varival2;
        return sum;
    }
    public String getVariable() {
        if (myVariableNames.size() > 0) {
            return (String) myVariableNames.get(myVariableNames.size() - 1) + ": " + Double.toString((Double) myVariableVals.get(myVariableVals.size() - 1));
        }
        else {
            return null;
        }
    }
    public boolean newVarAdded() {
        return this.isNewVarAdded;
    }
    public void varReceived() {
        isNewVarAdded = false;
    }
}
