#SLogo API
## Team 8

1) The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.
   
   The user input goes into the console visual which gets sent to the model. Based on the command, it will get the method. And then the command will be called on the turtle model and the visuals will be updated. 

2) The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.
    
    Based on our error checking the back-end will throw this error when it parses. It will have to communicate with our back-end error checking class that will make an error box pop up.
    
3) The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once without a trail and once with a trail).
   
   We will have a pen class that will keep track of the trail.
    
4) The user changes the color of the environment's background.
   
   We will have a backgroud object that will update the UI. 
   
   
   
   ![hello ](../data/IMG_1385.HElC)