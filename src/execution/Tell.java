package execution;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tell {
        public double execute(List<String> parameters, ConsoleModel consoleModel, TurtleModelContainer turtleModelContainer) {
            List <String> symbolList = Arrays.asList(parameters.get(0).split("[ ]+"));
            List<TurtleModel> newActiveTurtles = new ArrayList<>();
                for(int i = 2; i < symbolList.size(); i ++){
                    int id = Integer.parseInt(symbolList.get(i));
                    int difference = id - turtleModelContainer.getTurtleIds().size();
                    if(difference > 0){
                        for(int k = 0; k < difference; k ++ ){
                            int newId = turtleModelContainer.getTurtleIds().get(turtleModelContainer.getTurtleIds().size()-1) + 1;
                            TurtleModel turtleModel = turtleModelContainer.addTurtle(id);
                            newActiveTurtles.add(turtleModel);
                        }
                    }
                    else{
                        TurtleModel turtleModel = turtleModelContainer.getTurleModel(id);
                        newActiveTurtles.add(turtleModel);
                    }
                }
                turtleModelContainer.setActiveTurtles(newActiveTurtles);
            return Integer.parseInt(symbolList.get(symbolList.size()-1));
        }


        public int getNumParams() {
            return 1;
        }
    }

