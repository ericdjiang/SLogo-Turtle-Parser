package controller;

import execution.CommandFactory;
import model.TurtleModel;
import parsing.Parser;
import view.TurtleView;

public class Controller {
    private TurtleModel turtleModel;
    private TurtleView turtleView;
    private Parser parser;
    private CommandFactory commandFactory;

    public Controller() {
        this.turtleView = new TurtleView();
        this.commandFactory = new CommandFactory();
        //this.turtleModel = new TurtleModel()
    }

}
