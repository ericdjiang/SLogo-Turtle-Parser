package model;

public class ConsoleModel {
    private double returnVal;
    private String errorMessage;
    public ConsoleModel() {
        returnVal = 0;
        errorMessage = null;
    }
    public void setReturnVal(double d) {
        this.returnVal = d;
    }
    public double getReturnVal() {
        return this.returnVal;
    }
    public void setErrorMessage(String message){
        errorMessage = message;
    }
    public String getErrorMessage(){
        return errorMessage;
    }



}
