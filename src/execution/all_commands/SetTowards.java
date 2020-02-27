package execution.all_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class SetTowards implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
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
        double angle = Math.toDegrees(Math.atan(differenceY/differenceX));
        turtleModel.setAngle(angle);
        return angle;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
