package execution.all_commands;

import execution.Command;
import java.util.List;

import model.*;

public class SetTowards implements Command {
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int HALFCIRCLE = 180;

    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, ModelContainer allModels) {
           ConsoleModel consoleModel = allModels.getConsoleModel();
           double differenceX = Double.parseDouble(parameters.get(FIRST)) - turtleModel.getX() ;
           double differenceY = Double.parseDouble(parameters.get(SECOND)) - turtleModel.getY() ;
           if(differenceX == 0){
               if(differenceY > 0){
                   turtleModel.setAngle(0);
                   System.out.println(0);
                   return 0;
               }
               if(differenceY < 0){
                   turtleModel.setAngle(HALFCIRCLE);
                   System.out.println(HALFCIRCLE);
                   return -HALFCIRCLE;
               }
           }
           double angle = Math.toDegrees(Math.atan(differenceX/differenceY));
           if(differenceX<0&&differenceY<0){
               angle = angle + HALFCIRCLE;
           }
           if(differenceX>0&&differenceY<0){
               angle = angle + HALFCIRCLE;
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
