package execution;

import java.util.List;

import model.*;

/**
 * Interface which serves as foundation of all commands
 */
public interface Command {

    /***
     * Execute will alter the corresopnding model
     * based on the input parameters
     * @param parameters a list of each parameter as a string
     * @param TurtleModel the turtle model containing position states/methods
     * @param allModels a wrapper class containing user defined methods and variables classes
     * @return the integer representing the result of executing the last command
     */
    double execute(List<String> parameters, TurtleModel TurtleModel, ModelContainer allModels);

    /**
     * @return the number of required parameters this command taeks
     */
    int getNumParams();
}
