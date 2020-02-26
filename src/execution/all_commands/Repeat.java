package execution.all_commands;

import execution.Command;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;
import parsing.Parser;

public class Repeat implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);
    int numRepeats = Integer.parseInt(symbolList.get(1));
    String loopBody = String.join(" ",symbolList.subList(2, symbolList.size()));

    for (int i = 0; i < numRepeats; i++) {
      try{
        Parser parser = new Parser(language, loopBody, turtleModel, variableModel);
      } catch (Exception e) {

      }
    }


    return Double.parseDouble(parameters.get(0));
  }

  @Override
  public int getNumParams() {
    return 1;
  }
}
