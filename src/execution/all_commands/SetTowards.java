package execution.all_commands;

import execution.Command;
import java.util.List;

import model.ConsoleModel;
import model.TurtleModel;
import model.VariableModel;

public class SetTowards implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel, ConsoleModel consoleModel) {
        System.out.println(" number of degrees turned" + parameters.get(0));
        double originalAngle = turtleModel.getAngle();
        double[] orginalvector = {Math.cos(Math.toRadians(originalAngle)), Math.sin(Math.toRadians(originalAngle))};
        double[] xyVector = {Double.parseDouble(parameters.get(0)), Double.parseDouble(parameters.get(1))};
        double[] differenceVector = {Double.parseDouble(parameters.get(0)) - Math.cos(Math.toRadians(originalAngle)), Double.parseDouble(parameters.get(1)) - Math.sin(Math.toRadians(originalAngle)) };
        double differenceAngle = Math.atan(differenceVector[0]/ differenceVector[1]);
        turtleModel.setAngle(originalAngle + differenceAngle);
        //FIXME: This is not the correct implementation
        return differenceAngle;
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
