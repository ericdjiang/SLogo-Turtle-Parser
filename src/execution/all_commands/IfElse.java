package execution.all_commands;

import execution.Command;
import execution.LoopCommand;

import java.util.Arrays;
import java.util.List;

import model.*;
import parsing.Parser;

public class IfElse extends LoopCommand implements Command {

  /***
   * Parses the if loop guard and executes either the if/else body based on the loop guard output
   * @param parameters a list of each parameter as a space delimited string
   * @param TurtleModel the turtle model containing position states/methods
   * @param allModels a wrapper class containing user defined methods and variables classes
   * @return the last return value of the parsed loop body
   */
  @Override
  public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    int expEnd = getExpEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(1, expEnd)), language, allModels);
    int loopGuard = (int) Math.round(loopGuardParser.getLastReturnValue());

    String [] loopBodies = getLoopBodies(symbolList);

    Parser parser;
    if (loopGuard > 0){
       parser = new Parser(loopBodies[0], language, allModels);
    } else {
      System.out.println(loopBodies[1]);
      parser = new Parser(loopBodies[1], language, allModels );
    }

    return parser.getLastReturnValue();
  }

  /**
   * @return the number of parameters required
   */
  @Override
  public int getNumParams() {
    return 1;
  }
}
