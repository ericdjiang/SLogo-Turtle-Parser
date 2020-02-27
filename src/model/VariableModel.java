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
        String variable = variableName.substring(1);
        isNewVarAdded = true;
        myMap.put(variable,value);
        myVariableNames.add(variable);
        myVariableVals.add(value);
        System.out.println(variable + value);
    }


    public boolean checkIfVariableExists(String variableName){
        String variable = variableName.substring(1);
        return myMap.containsKey(variable);
    }

    public double getValue(String variableName){
        String variable = variableName.substring(1);
        return myMap.get(variable);
    }

    public double addVariables(String variable1, String variable2){
        String var1 = variable1.substring(1);
        String var2 = variable2.substring(1);
        double varival = myMap.get(var1);
        double varival2 = myMap.get(var2);
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
