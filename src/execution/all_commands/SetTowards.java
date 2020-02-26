package execution.all_commands;

import execution.Command;
import java.util.List;
import model.TurtleModel;
import model.VariableModel;

public class SetTowards implements Command {
    @Override
    public double execute(List<String> parameters, TurtleModel turtleModel, VariableModel variableModel) {
        System.out.println(" number of degrees turned" + parameters.get(0));
        double originalAngle = turtleModel.getAngle();
        if(Double.parseDouble(parameters.get(1)) == 0){
            if(Double.parseDouble(parameters.get(0)) > 0) turtleModel.setAngle(90);
            else if(Double.parseDouble(parameters.get(1) ) <0){turtleModel.setAngle(-90);}
            else{ turtleModel.setAngle(0);}
        }
        double angle = Math.atan(Double.parseDouble(parameters.get(0))/Double.parseDouble(parameters.get(1)));
        turtleModel.setAngle(angle);
        return Double.parseDouble(parameters.get(0));
    }

    @Override
    public int getNumParams() {
        return 2;
    }
}
