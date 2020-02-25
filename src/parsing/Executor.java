package parsing;

public class Executor {

    public Executor(){
    }

    public int forward(int size){
        System.out.println(String.format("The Turtle moves forward %d steps", size));
        return size;
    }

    public int backward(int size){
        System.out.println(String.format("The Turtle moves backward %d steps", size) );
        return -size;
    }
    public int left(int size){
        System.out.println(String.format("The Turtle moves left %d steps", size) );
        return -size;
    }
    public int right(int size){
        System.out.println(String.format("The Turtle moves right %d steps", size) );
        return size;
    }

}
