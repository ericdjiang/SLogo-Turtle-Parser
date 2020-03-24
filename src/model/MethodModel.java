package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holds the user-defined methods
 */

public class MethodModel {
  private String methodBody;
  private List<String> variableNames;
  private List<String> methodNames;
  private List<String> variables;

  /**
   * Constructor which takes in method name and arguments
   * @param variableString the arguments to the method in string form
   * @param methodBody the method body
   */
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

  /**
   * @return the total number of arguments
   */
  public int getNumVariables () {
    return variableNames.size();
  }

  /**
   * @param i index of argument
   * @return the name of the ith argument
   */
  public String getVariableName (int i) {
    System.out.println("variables" + variableNames);
    return variableNames.get(i);
  }

  /**
   * @return the method body of the user defined method
   */
  public String getMethodBody () {
    System.out.println("method" + methodBody);
    return methodBody;
  }

  /**
   * @return the name of the most recent method
   */
  public String getMethodName() { return methodNames.get(methodNames.size()-1);
  }

  /**
   * Add a new method name to the methodNames list
   * @param name of the method in String form
   */
  public void addMethodName(String name) { methodNames.add(name);
  }

  /**
   * @return the arguments to the methods
   */
  public List<String> getVariablesFE(){
      return variables;
  }
}
