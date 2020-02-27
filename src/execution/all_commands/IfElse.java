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

public class IfElse extends LoopCommand implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    int expEnd = getExpEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(1, expEnd)), language, turtleModel, variableModel, consoleModel);
    int loopGuard = (int) Math.round(loopGuardParser.getLastReturnValue());


    String [] loopBodies = getLoopBodies(symbolList);

//    System.out.println(language);
//    System.out.println(numRepeats);
//    System.out.println(loopBody);

    if (loopGuard > 0){
       Parser parser = new Parser(loopBodies[0], language, turtleModel, variableModel, consoleModel);
    } else {
      System.out.println(loopBodies[1]);
      Parser parser = new Parser(loopBodies[1], language, turtleModel, variableModel, consoleModel);
    }


    return 0;
  }

  @Override
  public int getNumParams() {
    return 1;
  }
}
