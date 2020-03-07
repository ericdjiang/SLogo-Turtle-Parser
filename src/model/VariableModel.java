package model;

import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class    VariableModel {

    private HashMap<String, Double> myMap;
    private boolean isNewVarAdded;
    private List<Variable> myVariables;
    private Map<String,Integer> Map;

    public VariableModel(){
        myMap = new HashMap<>();
        myVariables = new ArrayList<>();
        Map = new HashMap<>();
    }

    public Variable addVariable(String name, double value){
        Variable variable = new Variable(myVariables.size(),name,value);
        Map.put(name,myVariables.size());
        myVariables.add(variable);
        return variable;
    }

    public void updateVariable(String variableName, double value,boolean fromFront){
        String variable = variableName.substring(1);
        if(!Map.containsKey(variable)) {
            addVariable(variable, value);
            System.out.println("new Variable");
        }
        else{
            int index = Map.get(variable);
            System.out.println(index);
            Variable v = myVariables.get(index);
            String vName = v.getName();
            double vVal = v.getVal();
            if(!vName.equals(variable)){
                v.updateVariable(variable);
            }
            if(vVal != value){
                v.updateVariable(value);
            }

        }
        if(!fromFront) isNewVarAdded = true;
        System.out.println(variable + value);
    }



    public boolean checkIfVariableExists(String variableName){
        String variable = variableName.substring(1);
        return myMap.containsKey(variable);
    }

    public double getValue(String variableName){
        String variable = variableName.substring(1);
        if(!Map.containsKey(variable)) return 0;
        int index = Map.get(variable);
        System.out.println(index);
        Variable v = myVariables.get(index);
        return v.getVal();
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

    public boolean newVarAdded() {
        return this.isNewVarAdded;
    }
    public void varReceived() {
        isNewVarAdded = false;
    }
    public void clearVarInfo() {
      //  myVariables.clear();
    }
    public List<Variable> getVariables(){
        return myVariables;
    }
}
