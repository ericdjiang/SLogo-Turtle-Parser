package execution.all_commands;

import execution.Command;
import execution.LoopCommand;
import execution.MultipleTurtlesCommand;
import model.*;
import parsing.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Ask extends LoopCommand implements MultipleTurtlesCommand {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel turtleModel) {
        List<TurtleModel> oldActive = turtleModelContainer.getActiveTurtles();
        List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));
        String language = symbolList.get(0);
        int runner = 0;
        List<TurtleModel> newActiveTurtles = new ArrayList<>();
        for(runner = 2; runner < symbolList.size() -2; runner ++){
            if(symbolList.get(runner).equals("]")){
                break;
            }
            int id = Integer.parseInt(symbolList.get(runner));
            int difference = id - turtleModelContainer.getTurtleIds().size();
            System.out.println(turtleModelContainer.getTurtleModels().size());
            if(difference > 0){
                for(int k = 0; k < difference; k ++ ){
                    int newId = turtleModelContainer.getTurtleIds().get(turtleModelContainer.getTurtleIds().size()-1) + 1;
                    TurtleModel newTurtleModel = turtleModelContainer.addTurtle(newId);
                    if(newId == id)newActiveTurtles.add(newTurtleModel);
                }
            }
            else{
                TurtleModel newTurtleModel = turtleModelContainer.getTurleModel(id);
                newActiveTurtles.add(newTurtleModel);
            }
        }
        turtleModelContainer.setActiveTurtles(newActiveTurtles);

        symbolList = symbolList.subList(runner+2, symbolList.size());


        int loopGuardEnd = getLoopGuardEnd(symbolList);
        Parser loopGuardParser = new Parser(String.join(" ", symbolList.subList(0, loopGuardEnd)), language, variableModel, consoleModel, methodModels, turtleModelContainer );
        double loopLimit =  Math.round(loopGuardParser.getLastReturnValue());

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

//        for (int i = 0; i < 1; i++) {
//            try{
//                //variableModel.updateVariable(varName, i);
//                Parser parser = new Parser(loopBody, language, variableModel, consoleModel , methodModels, turtleModelContainer);
//
//                lastReturnValue = parser.getLastReturnValue();
//            } catch (Exception e) {
//                System.out.println("Error in ask");
//            }
//        }

        consoleModel.setReturnVal(lastReturnValue);
        turtleModelContainer.setActiveTurtles(oldActive);
        return loopLimit;
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
