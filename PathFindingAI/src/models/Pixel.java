/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author civankorkmaz
 */
public class Pixel {
    private int x;
    private int y;
    private double r_value;
    private double distance;
    private double closeness;
    private double cost;
    private Pixel parent;
    
    public Pixel(int x, int y){
        this.x = x;
        this.y = y;
        this.cost = 0;

    }

    public Pixel(int x, int y, double r_value, Pixel end, Pixel parent) {
        this.x = x;
        this.y = y;
        this.r_value = r_value;
        if(r_value == 0)
            setR_value(1.0);
        calculateDistance(end.getX(), end.getY());
//        this.closeness = (Double)(1/r_value) * Math.pow(distance, 2.55);
        this.closeness = (Double)(1/r_value) * distance;

        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getR_value() {
        return r_value;
    }

    public void setR_value(double r_value) {
        this.r_value = r_value;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    private void calculateDistance(int end_x, int end_y){
        this.distance  = Math.sqrt((end_x-x)*(end_x-x)+(end_y-y)*(end_y-y));
    }

    public double getCloseness() {
        return closeness;
    }

    public void setCloseness(double closeness) {
        this.closeness = closeness;
    }
    
    
    public void setCost(Pixel p){
        this.cost = p.getCost() + closeness;
    }

    public double getCost() {
        return cost;
    }

    public Pixel getParent() {
        return parent;
    }

    public void setParent(Pixel parent) {
        this.parent = parent;
    }
    
    
    
}
