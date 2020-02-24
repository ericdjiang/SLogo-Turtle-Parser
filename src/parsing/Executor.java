package parsing;

public class Executor {

    public Executor(){
    }

    public void forward(int size){
        System.out.println(String.format("The Turtle moves forward %d steps", size) );
    }

    public void backward(int size){
        System.out.println(String.format("The Turtle moves backward %d steps", size) );
    }
    public void left(int size){
        System.out.println(String.format("The Turtle moves left %d steps", size) );
    }
    public void right(int size){
        System.out.println(String.format("The Turtle moves right %d steps", size) );
    }

}
