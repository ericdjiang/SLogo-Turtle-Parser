package model;


import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class TurtleModel {
  private int myId;
  private double myX;
  private double myY;
  private double myAngle;
  private double penSize;
  private boolean isShowing;
  private boolean penDown;
  private double myZeroX;
  private double myZeroY;
  private boolean isCleared;
  private List<Double> myPoints;
  private boolean disabled;
  private List<Double> backgroundColor;
  private List<Double> penColor;
  private boolean isColorChanged;


  public TurtleModel (int id, double myX, double myY, double myAngle) {
    this.myId = id;
    this.myX = myX;
    this.myY = myY;
    this.myZeroX = myX;
    this.myZeroY = myY;
    this.myAngle = myAngle;
    this.myPoints = new ArrayList();
    this.myPoints.add(myX);
    this.myPoints.add(myY);
    this.isShowing = true;
    this.penDown = true;
    isColorChanged = false;
    this.backgroundColor = new ArrayList<>();
    this.penSize = 1;
  }

  /**
   * Sets whether or not the backgound color has been changed
   * @param changed
   */
  public void setColorChanged(boolean changed){
    isColorChanged = changed;
  }

  /**
   *
   * Sends in rgb vals for background color
   * @param rgbVals
   */
  public void setBackgroundColor(List<Double> rgbVals){
    backgroundColor = rgbVals;
  }

  /**
   * sends in rgb vals for pen color
   * @param rgbVals
   */
  public void setPenColor(List<Double> rgbVals){
    penColor = rgbVals;
  }

  /**
   * Sends in an x value to set as x value of turtle
   * @param x
   */
  public void setX(double x){
    this.myX = x;
    addPoints(x);
  }

  /**
   * Sends in an y value to set as y value of turtle
   * @param y
   */
  public void setY(double y) {
    this.myY = y;
    addPoints(y);
  }

  /**
   * Gets list of historic points (locations)
   * @return
   */
  public List getPointList() {
    return this.myPoints;
  }

  /**
   * Clears the list of points that exist
   */
  public void clearList() {
    myPoints.clear();
  }

  /**
   * reinitializes the center location of the turtle
   */
  public void reInitCenter() {
    clearList();
    myPoints.add(myZeroX);
    myPoints.add(myZeroY);
  }

  /**
   * Sets the x and y value of the turtle
   * @param x
   * @param y
   */
  public void setXY(double x, double y) {
    setX(x);
    setY(y);
  }

  /**
   * Sets the angle that the turtle faces
   * @param a
   */
  public void setAngle(double a) {
    this.myAngle = a;
  }

  /**
   * Returns the x value of turtle
   * @return
   */
  public double getX() {
    return this.myX;
  }

  /**
   * Returns the y value of the turtle
   * @return
   */
  public double getY() {
    return this.myY;
  }

  /**
   * Returns the angle facing of the turtle
   * @return
   */
  public double getAngle() {
    return this.myAngle;
  }

  /**
   * Says whether or not turtle is visible or not
   * @return
   */
  public boolean getShowing() {return this.isShowing;}

  /**
   * Returns whether or not pen is showing
   * @return
   */
  public boolean getPenStatus() {return this.penDown;}

  public void makePenDown(){
    if (! disabled) {
      penDown = true;
    }
  }
  public void makePenUp(){
    penDown = false;
  }
  public void hideTurtle(){
    isShowing = false;
  }
  public void showTurtle(){
    if (! disabled) {
      isShowing = true;
    }
  }
  public void setCleared(boolean b){
    isCleared = b;
  }
  public void setPenSize(double size){
    penSize = size;
  }
  public boolean getClearedStatus() {
    return this.isCleared;
  }
  public void trackPos() {
    myPoints.clear();
    myPoints.add(myX);
    myPoints.add(myY);
  }
  public int getModelId(){
    return myId;
  }

  public List<Double> getPenColor(){
    return penColor;
  }
  public List<Double> getBackgroundColor(){
    return backgroundColor;
  }

  public boolean getIsColorChanged(){
    return isColorChanged;
  }

  public double getPenSize(){return penSize;}

  public boolean checkBounds(double deltaX, double deltaY) {
    return this.getX() + deltaX < 230 && this.getX() + deltaX > -270 && this.getY() + deltaY < 240 && this.getY() + deltaY > -180;
  }
  public boolean checkAbsoluteBounds(double xPos, double yPos) {
    return xPos < 230 && xPos > -270 && yPos < 240 && yPos > -180;
  }
  public void disableShowAndPen(boolean b) {
    this.disabled = b;
  }
  public boolean getDisabledStatus() {
    return this.disabled;
  }
  private void addPoints(double p) {
    myPoints.add(p);
  }
}
