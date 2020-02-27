package execution.all_commands;

import execution.Command;
import execution.LoopCommand;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;
import parsing.Parser;

public class Repeat extends LoopCommand implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    int expEnd = getExpEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(1, expEnd)), language, turtleModel, variableModel, consoleModel);
    int numRepeats = (int) Math.round(loopGuardParser.getLastReturnValue());

    String loopBody = String.join(" ",symbolList.subList(expEnd+1, symbolList.size()));

//    System.out.println(language);
//    System.out.println(numRepeats);
//    System.out.println(loopBody);

    double lastReturnValue = 0;

    for (int i = 0; i < numRepeats; i++) {
      try{
//        System.out.println("parsing"+loopBody);
        Parser parser = new Parser(loopBody, language, turtleModel, variableModel, consoleModel);

        lastReturnValue = parser.getLastReturnValue();
      } catch (Exception e) {

      }
    }


    return lastReturnValue;
  }

  @Override
  public int getNumParams() {
    return 1;
  }
}
