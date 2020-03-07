package execution.all_commands;

import execution.Command;
import execution.MultipleTurtlesCommand;
import javafx.scene.paint.Color;
import model.*;


import java.util.List;
import java.util.Map;

public class SetBackground implements Command {
    @Override
    public double execute(List<String> parameters, VariableModel variableModel, ConsoleModel consoleModel, Map<String, MethodModel> methodModels, TurtleModel turtleModel) {
        String hexNum = parameters.get(0);
        Color color = Color.rgb(Integer.valueOf( hexNum.substring( 0, 2 ), 16 ),Integer.valueOf( hexNum.substring( 2, 4 ), 16 ),Integer.valueOf( hexNum.substring( 4,6 ), 16 ));
        System.out.println(color);
        turtleModel.setBackGroundColor(color);
        return Integer.parseInt(hexNum,16);
    }

    @Override
    public int getNumParams() {
        return 1;
    }
}
