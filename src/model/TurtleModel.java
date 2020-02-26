package model;

public class TurtleModel {
  private double myX;
  private double myY;
  private double myAngle;
  private boolean isShowing;
  private boolean penDown;
  private double myZeroX;
  private double myZeroY;


  public TurtleModel (double myX, double myY, double myAngle) {
    this.myX = myX;
    this.myY = myY;
    this.myAngle = myAngle;
  }

  public void setX(double x){
    //double newX = x + myZeroX;
    this.myX = x;
    System.out.println(this.myX);
  }

  public void setY(double y){
    //double newY  = myZeroY - y;
    this.myY = y;
    System.out.println(this.myY);
  }

  public void setXY(double x, double y) {
    setX(x);
    setY(y);
  }
  public void setAngle(double a) {
    this.myAngle = a;
  }
  public double getX() {
    return this.myX;
  }
  public double getY() {
    return this.myX;
  }
  public double getAngle() {
    return this.myAngle;
  }

  public boolean getShowing() {return this.isShowing;}
  public boolean getPen() {return this.penDown;}

  public void makePenDown(){
    penDown = true;
  }
  public void makePenUp(){
    penDown = false;
  }
  public void hideTurtle(){
    isShowing = false;
  }
  public void showTurtle(){
    isShowing = true;
  }
  public void clearPen(){
    //TODO: Implement
  }
}