package execution.all_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class SetTowards implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        double originalAngle = turtleModel.getAngle();
        double xDiff = turtleModel.getX() - Double.parseDouble(parameters.get(0));
        double yDiff = turtleModel.getY() - Double.parseDouble(parameters.get(1));
        if(xDiff == 0 && yDiff == 0){
            return 0;
        }
        if(xDiff == 0){
            if(yDiff > 0){
                turtleModel.setAngle(180);
                return originalAngle - 180;
            }
            else{
                turtleModel.setAngle(0);
                return originalAngle;
            }
        }

        if(yDiff == 0){
            if(xDiff > 0){
                turtleModel.setAngle(90);
                return originalAngle - 90;
            }
            else {
                turtleModel.setAngle(0);
                return originalAngle + 90;
            }
        }


        double[] orginalvector = {Math.sin(Math.toRadians(originalAngle)), Math.cos(Math.toRadians(originalAngle))};
        double[] differenceBTPoints = {turtleModel.getX() - Double.parseDouble(parameters.get(0)), turtleModel.getY() - Double.parseDouble(parameters.get(1))};
        double dotProduct = differenceBTPoints[0] * orginalvector[0] + differenceBTPoints[1] * orginalvector[1];
        double cosine = dotProduct/Math.sqrt(Math.pow(2,differenceBTPoints[0]) + Math.pow(2,differenceBTPoints[1]));
        double angle = Math.toDegrees(Math.acos(cosine));

//        double[] xyVector = {Double.parseDouble(parameters.get(0)), Double.parseDouble(parameters.get(1))};
//        double[] differenceVector = { Math.cos(Math.toRadians(originalAngle) - Double.parseDouble(parameters.get(0))),  Math.sin(Math.toRadians(originalAngle)) - Double.parseDouble(parameters.get(1)) };
//        double differenceAngle = Math.atan(differenceVector[0]/ differenceVector[1]);
//        double differenceAngleInDegrees = Math.toDegrees(differenceAngle);
        turtleModel.setAngle(originalAngle + angle);
        System.out.println(angle);
        //FIXME: This is not the correct implementation
        consoleModel.setReturnVal(angle);
        return angle;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
