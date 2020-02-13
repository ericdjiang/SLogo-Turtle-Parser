#Collection API
##Team 8: Eric Jiang, Claudia Chapman, Doherty Guirand, Abhijay Suhag
1) In your experience using these collections, are they hard or easy to use?
Java's collections API is quite easy to use. They typiclaly have the same method names throughout. For example, the .add() method is standard for linkedlists, arraylists, and hashsets. This makes it easy to switch data structures without having to change a lot of code. 

2) In your experience using these collections, do you feel mistakes are easy to avoid?
We feel that mistakes are easy to avoid, as the IDE will often underline incorrect arguments to Collections methods. In addition, there is strong documentation online for a multitude of standard Java collections. Finally, in the event of a mistake, Java will throw an exception. 

3) How many interfaces do specific concrete collection classes implement (such as LinkedList)? What do you think is the purpose of each interface?
There are 4 interfaces that are implemented by the concerete collection classes that are implemented. For example, TreeSet and HashSet implement the Set interface and TreeMap and HashMap implement the Map interface. The Set interface does not allow duplicates, the map interface allows for key-value pairs to be stored, the list interface is ordered and allows for duplicates, and the deque interface is mutable and allows for adding and removal of elements from begining and end.

4) How many different implementations are there for a specific collection class (such as Set)? Do you think the number justifies it being an interface or not?
There are three implementations for the Set collection: HashSet , TreeSet , and LinkedHashSet. This number does indeed justify the collection being an interface; since each class implementation utilizes the same base methods, it is important to implement the base collection class. 

5) How many levels of superclasses do specific concrete collection classes have? What do you think is the purpose of each inheritance level?
Concrete collection classes such as ArrayList, HashMap, and HashSet have two to three levels of superclasses. For example, ArrayList is a subclass of AbstractList, which is a subclass of AbstractCollection, which is a subclass of Object. Each inheritance level works to add more methods that give the class unique, special function.

6) Why does it make sense to have the utility classes instead of adding that functionality to the collection types themselves? Are there any overlapping methods (ones that are in both a specific collection and a utility class)? If so, is there any guidance on which one you should use?
This serves to further contribute to the principles of abstraction in Java; by further abstractifying each utility class we can ensure that each class' functionality is as specific as possible. Thus based on a user's specific use case, they can choose the simulation which most effectively satisfies their needs rather than simply relying on a general collection method that needs to be adapted.