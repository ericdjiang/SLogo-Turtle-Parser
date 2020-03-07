package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodModel {
  private String methodBody;
  private List<String> variableNames;
  private List<String> methodNames;
  private List<String> variables;

  public MethodModel (String variableString , String methodBody) {
      variables = Arrays.asList(variableString.split("[ ]+"));
  if (variableString.strip().length() == 0) this.variableNames = new ArrayList<>();
  else this.variableNames = Arrays.asList(variableString.split("[ ]+"));
      System.out.println("in method model");
    for (String s : variableNames){
      System.out.println(s);
    }
    System.out.println("nothing else");


    this.methodBody = methodBody;
    this.methodNames = new ArrayList<>();
  }

  public List<String> getVariableNames (){
    return variableNames;
  }

  public int getNumVariables () {
    return variableNames.size();
  }

  public String getVariableName (int i) {
    System.out.println("variables" + variableNames);
    return variableNames.get(i);
  }
  public String getMethodBody () {
    System.out.println("method" + methodBody);
    return methodBody;
  }
  public String getMethodName() { return methodNames.get(methodNames.size()-1);
  }
  public void addMethodName(String name) { methodNames.add(name);
  }
  public List<String> getVariablesFE(){
      return variables;
  }
}
