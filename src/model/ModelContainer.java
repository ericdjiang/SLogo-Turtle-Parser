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
        TurtleModelContainer myTurtleModelContainer, TurtleContainer myTurtleContainer, PaletteModel myPaletteModel){
        this.consoleModel = myConsoleModel;
        this.methodModels = myMethodModels;
        this.variableModel = myVariableModel;
        this.paletteModel = myPaletteModel;
        this.turtleModelContainer = myTurtleModelContainer;
        this.turtleContainer = myTurtleContainer;
    }

    public ConsoleModel getConsoleModel(){
        return consoleModel;
    }

    public VariableModel getVariableModel(){
        return variableModel;
    }

    public PaletteModel getPaletteModel(){
        return paletteModel;
    }


}
