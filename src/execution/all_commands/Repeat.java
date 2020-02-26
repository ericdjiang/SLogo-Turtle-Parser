package execution.all_commands;

import execution.Command;

import java.util.Arrays;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;
import parsing.Parser;

public class Repeat implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);
    int numRepeats = Integer.parseInt(symbolList.get(1));
    String loopBody = String.join(" ",symbolList.subList(3, symbolList.size()));

//    System.out.println(language);
//    System.out.println(numRepeats);
//    System.out.println(loopBody);

    for (int i = 0; i < numRepeats; i++) {
      try{
//        System.out.println("parsing"+loopBody);
        Parser parser = new Parser(loopBody, language, turtleModel, variableModel, consoleModel);
      } catch (Exception e) {

      }
    }


    return 0;
  }

  @Override
  public int getNumParams() {
    return 1;
  }
}
