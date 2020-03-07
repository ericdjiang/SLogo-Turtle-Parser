package execution.all_commands;

import execution.Command;
import execution.LoopCommand;

import java.util.Arrays;
import java.util.List;

import model.*;
import parsing.Parser;

public class If extends LoopCommand implements Command {
  @Override
  public double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels){
    List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));

    String language = symbolList.get(0);

    int expEnd = getExpEnd(symbolList);
    Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(1, expEnd)), language, allModels);
    int loopGuard = (int) Math.round(loopGuardParser.getLastReturnValue());

    String loopBody = String.join(" ",symbolList.subList(expEnd+1, symbolList.size()));

//    System.out.println(language);
//    System.out.println(numRepeats);
//    System.out.println(loopBody);

      if (loopGuard>0){
      try{
//        System.out.println("parsing"+loopBody);
        Parser parser = new Parser(loopBody, language, allModels);
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
