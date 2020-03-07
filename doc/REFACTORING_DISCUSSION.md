The main problems displayed by the checkup dev were related to magic numbers in many of the UI components as well as multiple 
aspects of the Parser such as longest method and intra file duplication. Going through this program reinforced our plan to 
begin a serious refactor of the Parser method, which we already knew had problems with readability and complexity. 
The main way by which we will handle these problems is by creating constants and additional resource file keys to handle
magic strings and numbers in the UI. This will go hand-in-hand with on-the-fly language changing functionality. For the Parser,
we will begin by compartmentalizing many portions into smaller methods that have specific, unique functions. This will be done
after the Parser is modified to handle multiple turtles, as we assume that this will involve a significant amount of change that
should be reviewed before refactoring. The UserInterface may also benefit from the use of super classes for aspects such as 
all of the windows that display history, references, variables, etc.

Furthermore, we have identified multiple constructors that take in upwards of six parameters. This includes classes such as the execution command interface and parser. We could potentially 
eliminate this code smell by creating a container for all of the models that gives out specific models as needed, similar to 
the container that was implemented to handle multiple turtles. This would reduce the number of parameters down to two or three
while also adding some modularity. Besides these major problems, the overall program needs to be reviewed in terms of dependencies
and how much of certain classes are accessed. 