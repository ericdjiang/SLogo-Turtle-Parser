package execution.all_commands;

import execution.Command;
import execution.LoopCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import execution.MultipleTurtlesCommand;
import model.*;
import parsing.Parser;

public class DoTimes extends LoopCommand implements MultipleTurtlesCommand{
  @Override
  public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);
    String varName = symbolList.get(2);

    int loopGuardEnd = getLoopGuardEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(3, loopGuardEnd)), language, variableModel, consoleModel, methodModels, turtleModelContainer );
    int loopLimit = (int) Math.round(loopGuardParser.getLastReturnValue());

//    System.out.println(loopLimit);
//    System.out.println(String.join(" ",symbolList.subList(loopGuardEnd+2, symbolList.size())));
    String loopBody = String.join(" ",symbolList.subList(loopGuardEnd+2, symbolList.size()));

    //DOTIMES [ variable limit ]
    //[ command(s) ]
//
//        System.out.println(language);
//        System.out.println(loopLimit);
//        System.out.println(loopBody);

    double lastReturnValue = 0;

    for (int i = 0; i < loopLimit; i++) {
      try{
        variableModel.updateVariable(varName, i,false);
        Parser parser = new Parser(loopBody, language, variableModel, consoleModel , methodModels, turtleModelContainer);

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
