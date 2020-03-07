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
    private String oldVariable;
    private double oldVariableVal;
    private List<String> varNames;
    private List<String> varVals;

    public VariableModel(){
        myMap = new HashMap<>();
        myVariableNames = new ArrayList();
        myVariableVals = new ArrayList();
        varNames = new ArrayList();
        varVals = new ArrayList<>();
        this.oldVariable=null;
    }

    public void updateVariable(String variableName, double value){
        String variable = variableName.substring(1);
        if (! myMap.containsKey(variable) || (myMap.containsKey(variable) && myMap.get(variable) != value)) {
            isNewVarAdded = true;
            varNames.add(variable);
            varVals.add(Double.toString(value));
        }
        oldVariable = variable;
        oldVariableVal = value;
        myMap.put(variable,value);
        myVariableNames.add(variable);
        myVariableVals.add(value);
        System.out.println(variable + value);

    }

    public void frontEndUpdate(String variableName, double value){
        String variable = variableName.substring(1);
        myMap.put(variable,value);

    }


    public boolean checkIfVariableExists(String variableName){
        String variable = variableName.substring(1);
        return myMap.containsKey(variable);
    }

    public double getValue(String variableName){
        String variable = variableName.substring(1);
        if(!myMap.containsKey(variable)) return 0;
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
    //TODO impelment memory
    public List getVariableName() {
        if (myVariableNames.size() > 0) {
            return varNames;
        }
        else {
            return null;
        }
    }
    public List getVariableInfo() {
        if (myVariableNames.size() > 0) {
            return varVals;
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
    public void clearVarInfo() {
        varNames.clear();
        varVals.clear();
    }
}
