package execution.all_commands;

import execution.Command;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;
import parsing.Parser;

public class DoTimes implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    String varName = symbolList.get(2);
    int loopLimit = Integer.parseInt(symbolList.get(3));
    String loopBody = String.join(" ",symbolList.subList(6, symbolList.size()));

    //DOTIMES [ variable limit ]
    //[ command(s) ]
//
//        System.out.println(language);
//        System.out.println(loopLimit);
//        System.out.println(loopBody);

    for (int i = 0; i < loopLimit; i++) {
      try{
        variableModel.updateVariable(varName, i);
        Parser parser = new Parser(loopBody, language, turtleModel, variableModel);
      } catch (Exception e) {
        System.out.println("Error in dotimes");
      }
    }


    return 0;
  }

  @Override
  public int getNumParams() {
    return 1;
  }
}
