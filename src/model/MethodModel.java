package model;

import java.util.Arrays;
import java.util.List;

public class MethodModel {
  private String methodBody;
  private List<String> variableNames;

  public MethodModel (String variableString , String methodBody) {
    this.variableNames = Arrays.asList(variableString.split("[ ]+"));
    this.methodBody = methodBody;
  }

  public List<String> getVariableNames (){
    return variableNames;
  }

  public int getNumVariables () {
    return variableNames.size();
  }

  public String getVariableName (int i) {
    return variableNames.get(i);
  }
  public String getMethodBody () {
    return methodBody;
  }
}
