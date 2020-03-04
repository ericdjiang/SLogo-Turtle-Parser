package execution.all_commands;

import execution.Command;
import java.util.List;
import java.util.Map;

import model.*;

public class SetTowards implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModelContainer turtleModelContainer, TurtleModel currentTurtleModel) {
            TurtleModel turtleModel = currentTurtleModel;
           double differenceX = Double.parseDouble(parameters.get(0)) - turtleModel.getX() ;
           double differenceY = Double.parseDouble(parameters.get(1)) - turtleModel.getY() ;
           if(differenceX == 0){
               if(differenceY > 0){
                   turtleModel.setAngle(0);
                   System.out.println(0);
                   return 0;
               }
               if(differenceY < 0){
                   turtleModel.setAngle(180);
                   System.out.println(180);
                   return -180;
               }
           }
           double angle = Math.toDegrees(Math.atan(differenceX/differenceY));
           if(differenceX<0&&differenceY<0){
               angle = angle + 180;
           }
           if(differenceX>0&&differenceY<0){
               angle = angle + 180;
           }

           turtleModel.setAngle(angle);


        consoleModel.setReturnVal(angle);

        return angle;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
