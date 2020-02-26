package model;

import javafx.scene.layout.VBox;

import java.util.HashMap;

public class VariableModel {

    private HashMap<String, Double> myMap;

    public VariableModel(){
        myMap = new HashMap<>();
    }

    public void updateVariable(String variableName, double value){
        myMap.putIfAbsent(variableName, 0.0);
        myMap.put(variableName,value);
    }

    public void incrementVariable(String variableName) {
        myMap.putIfAbsent(variableName, -1.00);
        myMap.put(variableName, myMap.get(variableName)+1);
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
}
