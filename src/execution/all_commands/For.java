package execution.all_commands;

import execution.Command;

import java.util.Arrays;
import java.util.List;

import model.*;
import parsing.Parser;

public class For implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
    VariableModel variableModel = allModels.getVariableModel();
    ConsoleModel consoleModel = allModels.getConsoleModel();
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));


    String language = symbolList.get(0);

    String varName = symbolList.get(2);
    int loopStart = Integer.parseInt(symbolList.get(3));
    int loopEnd = Integer.parseInt(symbolList.get(4));
    int loopIncrement = Integer.parseInt(symbolList.get(5));
    String loopBody = String.join(" ",symbolList.subList(8, symbolList.size()));

/**
 * FOR [ variable start end increment ]   [  command(s) ]
 * 0   1    2      3     4    5       6   7     8
 * **/
//
//        System.out.println(language);
//        System.out.println(loopLimit);
//        System.out.println(loopBody);

    double lastReturnValue = 0;
    for (double i = loopStart; i < loopEnd; i+=loopIncrement) {
      try{

        variableModel.updateVariable(varName, i,false);
        Parser parser = new Parser(loopBody, language, allModels);
        lastReturnValue = parser.getLastReturnValue();
      } catch (Exception e) {
        System.out.println("Error in dotimes");
      }
    }
    consoleModel.setReturnVal(lastReturnValue);
    return lastReturnValue;
  }

  @Override
  public int getNumParams() {
    return 1;
  }
}
