package execution.all_commands;

import execution.Command;
import execution.LoopCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import execution.MultipleTurtlesCommand;
import model.*;
import parsing.Parser;

public class Repeat extends LoopCommand implements MultipleTurtlesCommand {
  @Override
  public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    int expEnd = getExpEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(1, expEnd)), language, variableModel, consoleModel, methodModels, turtleModelContainer);
    int numRepeats = (int) Math.round(loopGuardParser.getLastReturnValue());

    String loopBody = String.join(" ",symbolList.subList(expEnd+1, symbolList.size()));

//    System.out.println(language);
//    System.out.println(numRepeats);
//    System.out.println(loopBody);

    double lastReturnValue = 0;

    for (int i = 0; i < numRepeats; i++) {
      try{
//        System.out.println("parsing"+loopBody);
        Parser parser = new Parser(loopBody, language, variableModel, consoleModel, methodModels,turtleModelContainer);

        lastReturnValue = parser.getLastReturnValue();
      } catch (Exception e) {

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
