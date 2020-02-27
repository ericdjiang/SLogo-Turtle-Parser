package execution.all_commands;

import execution.Command;
import execution.LoopCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import model.ConsoleModel;
import model.MethodModel;
import model.TurtleModel;
import model.VariableModel;
import parsing.Parser;

public class Repeat extends LoopCommand implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    int expEnd = getExpEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(1, expEnd)), language, turtleModel, variableModel, consoleModel, methodModels);
    int numRepeats = (int) Math.round(loopGuardParser.getLastReturnValue());

    String loopBody = String.join(" ",symbolList.subList(expEnd+1, symbolList.size()));

//    System.out.println(language);
//    System.out.println(numRepeats);
//    System.out.println(loopBody);

    double lastReturnValue = 0;

    for (int i = 0; i < numRepeats; i++) {
      try{
//        System.out.println("parsing"+loopBody);
        Parser parser = new Parser(loopBody, language, turtleModel, variableModel, consoleModel, methodModels);

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
