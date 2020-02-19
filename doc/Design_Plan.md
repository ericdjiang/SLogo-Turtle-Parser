# Design Plan
## Team 8
#### Introduction
The goal of this program is to provide an IDE that allows users to write SLogo programs. The IDE should allow commands to be issued on a per instruction basis and focus on helping users to experiment and build complex expressions while also providing a visual representation of the turtle. 

Our program should be flexible in its implementation of View and Model such that new additions to the UI such as views for conosle history or list of commands can be added with relative ease. The Model should be able to handle the addition of more commands as well as throw any errors unique to those commands. Being flexible in both of these regions will allow us to achieve our goal of creating a user-friendly coding IDE. 

With an MVC design in mind, our program should keep its model and view closed in the sense that neither component should know or rely on the data structure implemented. Meanwhile, the Controller will hold both the view and model, allowing them to communicate so that they do not have to access each other. 

At a high level, the View component is responsible for visualization of the input and output of commands in the form of a console where the user inputs text and a window where a turtle is moved and draws. Commands input into the View are then sent through the Controller, where they are parsed and checked for errors, to the Model which contains a compiler holding the SLogo logic. This information is then passed back through the Controller to be visualized in the View's main visualization window. 
#### Overview
As a high level overview, the slogo project will follow the overarching design paradigm of the MVC. The model, view, and controller each contain their own respective classes which can communicate with each other to get and alter states via public API methods. 

At the top level is the Main class, which serves as the wrapper which holds the Visualizers and Models. The main class is responsible for passing the references to the instantiated models to their corresopnding Visualizer objects, as detailed as follows:

Starting with the view, there will be two classes which inherit from a base Visualizer class which provides common abstract methods such as updateDisplay. The ConsoleVisualizer class will be responsible for returning a scene containing the IDE to the Main class. This is where the user will type methods and hit "run". 

Once the run button has been hit, the user input string is sent to the controller, which is the Parser class. This Parser class is responsible for first performing validation on the input string. If no syntax errors/potential errors are detected, the Parser will split each line of the input message, split the raw String into a method and parameters, and send these inputs as parameters to be executed the Executioner class.

The Executioner class is actually calling the commands to alter the turtle model based based on the input Command from the Parser. It will look to a properties file to map the input command and parameters to the corresponding commands on the Turtle model (which will provide an API to alter its state instance variables).

Now moving to the second component of the SLOGO visualization, we will discuss the actual visualization component of the turtle within a playarea. Like ConsoleVisualizer, TurtleVisualizer will extend from the Visualizer class and return a scene containing all lines, the play area, and of course the turtle itself. The TurtleVisualizer will also provide buttons/GUI elements which allow the GUI to be adjusted on the fly. 

When buttons/sliders on the TurtleVisualizer are changed, the corresponding setter methods are called on the StageModel object in order to update the state variables (such as strokeWidth). The TurtleVisualizer will then reupdate its view to reflect the changes to the StageModel class.

The TurtleVisualizer class will be responsible for returning a scene containing the "turtle pen", turtle representation, and the relevant buttons (such as to for adjusting stroke color and stroke width). 

We are going to make message objects. We have to store the user's past commands with these objects. We plan to use a list to implement this. We could also use a list of maps. The map will connect the lines of code to whether or not that section of code passed or failed. All we are going to pass are the messsge objects so the actual data structure that stores the lines of code will be hidden from the rest of the program. 

##### Graphic Design of our program
![](https://i.imgur.com/og3Sz1a.jpg)

#### User Interface
##### An example of the user interface
![](https://i.imgur.com/vUyu7N7.png)
Instead of only taking one line at a time, like in the example, our program will take in multiple lines. 
    The user will be able to write multiple lines of code into the command box. Then the user will hit run and see the turtle respond to the commands or the user will see an error box. The command box will also have a clear button to remove all commands currently written in it.
    There will be a viewing window that contains the turtle and its trail, a command box where the user will type into, and a list of commands as a reference. This list of commands will most likly be a scroll pane on the side that can be switched to by clicking a tab. The default side panel will be a scroll pane displaying the user's input history. If the user types a bad command, the user will see an error message that explains the error. These errors will include, an error in syntax and command parameters.



#### Design Details
The front-end external API will be in the StageModel class. This is where the user is able to change the background color and move the turtle around the screen. The StageModel class provides an end-to-end solution to allowing the user to change alter any Stage-specific parameters on the fly (including but not limited to the colors of the turtle/lines, stroke widths, and the size of the stage). This is achieved in the StageModel API by providing public setter methods to alter each of these state variables which are called by the StageVisualizer whenever an eventlistener for a button/GUI element is triggered. Since the StageModel also stores the result of the user-specified front-end attributes, the StageVisualizer can then read from the StageModel via getter methods and render the corresponding JavaFX nodes on screen based on the input parameters.

The back-end external API will include the console model. This section of the program will include the parser that provides the main functionality in terms of executing commands. A key feature of our SLOGO project is the ConsoleModel, which contains an entire history of the commands that the user input. Just as any other Model class, this ConsoleModel backend external API provides getter and setter methods to retrieve and update, respectively, the corresponding state variables. 

The front-end internal classes will provide features that do not require any processing by the back-end. This includes changing the color or formating the display, changing the input language, and viewing lists of old commands or variables. These classes will use each of the language properties. 

The Executioner and Parser classes will be back-end internal classes. This section will focus on providing features and ways of changing the back-end processing that the front-end does not care about. Part of this extensibility is built into the Command Interface, which allows an obvious way for new commands to be added to the Slogo language.


#### API as Code
We can forsee the following exceptions being nessesary:
* Syntax exception
* RunTime exception
* Out of bounds exception
* Slogo RunTime exception

```java
/**
 * This class is responsible for handling the user's direct input
 * It does not alter any Model itself, but rather passes simply validates
 * each line of the user-input message, splits it into corresponding methods,
 * and sends the split messages and parameters to the Executioner.
 */
 

public interface Parser {
  /**
   handleUserInput will call multiple private methods which serve the purpose
   of first splitting the inputMessage into its corresponding individual lines of code,
   ensuring the syntax for each line is correct, then finally extracting the method
   and the parameters and storing each line's data in a Message object that is passed
   to the executioner to actually alter the model.
  **/
  
  public boolean handleUserInput(String inputMsg);
}

/**
 * This class is responsible for actually altering the state of the model
 * based on the corresponding input method and parameters from the user
 */

public interface Executioner {
  // takes in our specially defined Message datatype which contains
  // the desired method, corresponding methods, and executes the
  // corresponding commands via setter methods in TurtleModel
  public void executeMsg(Message);
}

/**
 * Provides API to store a new message
 * and retrieve a list of all historical messages
 */
public interface ConsoleModel {
  // Takes in user input string as a parameter and stores it to
  // a storage data structure for all messages
  public void addNewMessage(String msg);

  // Returns a list of all messages; the datatype of the list
  // is an implementation detail an can be either a String or a HashMap
  // which stores additional details
  public List<Message> getAllMessages;
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.paint.Color;

/**
 * Responsible for storing state variables of the stage
 * which correspond to GUI attributes such as color and size.
 *
 * Provides API for TurtleVisualizer to alter and change state attributes
 */
public interface StageModel {
  // Setup the initial default settings and parameters for the stage
  public void initDefaultSettings();

  // Setter methods which provide the ability to alter stage settings
  public void setStageWidth(int width);
  public void setStageHeight(int height);
  public void setPenWidth(int width);
  public void setPenHeight(int height);
  public void setPenColor(Color color);

  // Getter method which returns Map containing key/value pairs mapping to
  // instance variables settings of the stage
  public Map<String, String> getStageSettings();
}

```

```java
Front External

public interface VisualizerPropertiesInterface {
    //alter color of pen
    public void setTrailColor(Color penColor);
    //alter stroke width
    public void setTrailWidth(int width);
    //alter stage width
    public void setStageWidth(int width);
    //alter stage height
    public void setStageHeight(int height);
    //alter color of main view background
    public void setBackgroundColor(Color bgColor);
    //update visuals based on commands input
    public void update();
}

Front Internal

public interface UIPropertiesInterface {
    //retrieve a collection of past commands
    public List getCommandHistory();
    //retrieve a collection of variables storing values
    public List getUsedVariables();
    //set display font color for buttons, title, etc
    public void setFontColor();
    //alter language of command inputs
    public void setLanguage(String language);
}


Back External

public interface SLogoLogicInterface {
    public void addNewMessage();
    public List<String>getAllMessages();
    
}

Back Internal (throws syntax, runtime, out of bounds exceptions)

public interface CompilerInterface {
    public boolean checkSyntax();
    public boolean checkBounds();
    public boolean checkRuntime();
}
```

#### Use Cases
* The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history. Note, it is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command will be. 
    *  The user input goes into the console visualizer which gets sent to the model. Based on the command, it will get the method. And then the command will be called on the turtle model and the visuals will be updated. 
* The user sets the pen's color using the UI so subsequent lines drawn when the turtle moves use that color. 
    * The user input gors to the StageModel class that has the setTrailColor() method. Then the user will be able to see that change in color throught the TurtleVisualizer that updates the Visualizer. Both the Turtlevisualizer and the Visualizer will be contained in main. 

* The user mistypes "forward" to be "foward" and presses run.
    * The user input would go to the ConsoleVisualizer that calls getUserInput() and sendInputToParser(). After being sent to the Parser, the parser will validate the input by calling validateMsg(). This is where the program will see that this is not an actual input. The parser will then throw an Execution Exception that will inform the user that there was a syntax error. 
    
* The user wants to reset the current state of the turle to the default state.
    * The user will hit a clear button. This will send a message to the ConsoleVisalizer. The ConsoleModle will use the Parser to send a message to the Executioner which will call consolemodle.clearHistory(). Then the Executioner will use the TurtleModel to set the turtle's X,Y, and angle positions to the default state. These updates to the TurleModel will be reflected in the TurtleVisualizer.
    
* The user inputs a series of commands taking up multiple lines. However, the each line of code is separated by a blank line. 
    * The Parser should be able to accommodate for blank lines, simply disregarding them in the parsing process rather than throwing a syntax error. The commands are then compiled and ran as if there were no blank lines. The flow of data in this case follows the same as other commands from the console visualizer to the console model which invokes methods on the turtle.

* The user wishes to issue a chain of commands involving order of processing such as 'fd fd fd fd 5'.
    *  In this case, the model and parser should be equipped to handle a general theory of regex given in a file in the data folder wherein processing is handled right to left. The command here is sent to the Parser which will break up the input into portions to recursively parse. In this case, this command is the same as 'fd 20'. The command will be parsed as 4 instances of fd 5 that execute 'fd' by 'fd'. This comamnd will then follow the normal chain of data flow mentioned in previous use cases.
   
* The user wishes to revert to a previous state of the SLOGO project
    * First, the user will press a back button generated and displayed by the TurtleVisualizer component. An event listener for this button will be triggered and the corresponding event handler for this event will be triggered. In this specific use case, the ConsoleModel API will be called in order to revert to a revert to the command by stepping backwards in the List of Message objects. Finally, the TurtleVisualizer will call updateDisplay() on itself to render the recent change.
* The user inputs a long input message containing multiple commands.
    * The entire input String will be sent to the Parser. The Parser will split the String based on SLOGO langauage's delimiting character, where each individual command is stored as a Message datatype in a List containing all Messages in that particular input message. After validating and checking for syntax errors, the Parser will iterate through each Message in the data storage and pass the Message (which contains the method and paramters needed for execution) to the Executor object to actually enact the changes. 
* The user wants to change the color of the background.
    * The user will input a command to change the color of the background. It will be sent to the Parser. The Parser will validate and check the message object for syntx errors and will then pass the Message to the Executor object. Here the setBackgroundColor() method will be called on the Stage Model. 





#### Design Considerations

* One aspect of the design that my team has focused on is where the error handling should be done with respect to the parsing of the input that the user types. We discussed whether or not we should do a pre-check for basic "syntax" errors by checking if all of the words typed by the user are in the properties file. If we did this primary check, we would disable the run button until all of the commands were valid. Our argument for doing this would be that it would reduce the amount of error checking later, because we would not even let the user run code with broken commands. However, this starts to confuse the front-end with the back-end and complicate encapsulation. It also does not save any time, since we can just make this the first check in the back-end and format it the same way.
* Another design decision that we talked about was whether or not we should use a controller. In the end we wanted to make sure that our design was more closed and so we decided to employ a controller in a few classes.
* ASSUMPTIONS:
    * Sometimes, I find it hard to come up with assumptions that we've made until we run into a decision that shows us that we have made an assumption. So I'm gonna just touch on a few instances of assumptions that we made along the way, but tried to account for them.
    * One of the assumptions that we made at first was that every command was one line. This lead to poor design decisions such as passing a String into the parser and choosing a bad data type to use to store all of the past commands. However, we then decided to create a Message object that would help us hold data other than simply the raw string that was typed. In addition, we then picked a data type that would allow us to access the line that was inputted before which will help with multi-line code.
    * Another assumption that we made originally was that the turtle object was the only object that needed to be displayed on the display. However, we then decided to split up the turtle itself, the trail behind it (pen), and the background. We also created an inheritance structure so that we could further extend our visual objects class and create more if that is how the project is extended.
* DEPENDENCIES: 
    * The Main class holds the TurtleModel and StageModel objects and passes them to both the ConsoleVisualizer and the TurtleVisualizer
    * The ConsoleVisualizeer contains a Parser object
    * The Parser class contains an instance of the Executor
    

#### Team Responsibilities
We will split up resonsibilites by giving each of us an API. 

When we start working on the project, our plan of action is as follows:
* We will first set up the structure of all of the classes.
* Make sure we can see the visualizer.
* Make sure that the visualizer can read from a data file. 

