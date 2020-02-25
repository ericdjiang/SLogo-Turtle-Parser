package model;

public class TurtleModel {
  private double myX;
  private double myY;
  private double myAngle;
  public TurtleModel (double myX, double myY, double myAngle) {
    this.myX = myX;
    this.myY = myY;
    this.myAngle = myAngle;
  }

  public void setX(double x){
    this.myX = x;
  }

  public void setY(double y){
    this.myY = y;
  }

  public void setXY(double x, double y) {
    setX(x);
    setY(y);
  }

}