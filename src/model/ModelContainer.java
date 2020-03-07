package model;

import java.util.List;
import java.util.Map;

public class ModelContainer {
    private ConsoleModel consoleModel;
    private Map<String, MethodModel> methodModels;
    private VariableModel variableModel;
    private PaletteModel paletteModel;
    private TurtleModelContainer turtleModelContainer;
    private TurtleContainer turtleContainer;

    public ModelContainer(VariableModel myVariableModel, ConsoleModel myConsoleModel, Map<String, MethodModel> myMethodModels,
        TurtleModelContainer myTurtleModelContainer, PaletteModel myPaletteModel){
        this.consoleModel = myConsoleModel;
        this.methodModels = myMethodModels;
        this.variableModel = myVariableModel;
        this.paletteModel = myPaletteModel;
        this.turtleModelContainer = myTurtleModelContainer;
    }
    public VariableModel getVariableModel(){
        return variableModel;
    }

    public ConsoleModel getConsoleModel(){
        return consoleModel;
    }

    public Map<String, MethodModel> getMethodModels() {return methodModels;}

    public TurtleModelContainer getTurtleModelContainer(){return turtleModelContainer;}

    public PaletteModel getPaletteModel(){
        return paletteModel;
    }

    public void setConsoleErrorMessage(String message){
        consoleModel.setErrorMessage(message);
    }

}
