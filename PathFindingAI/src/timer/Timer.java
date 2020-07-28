/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

/**
 *
 * @author civankorkmaz
 */
public class Timer {
    private long startTime;
    private long endTime;
    private long duration;

    public Timer() {
    }
    
    
    public void setStartTime(){
       startTime = System.currentTimeMillis();
    }
    
    
    public void setEndTime(){
       endTime = System.currentTimeMillis();
       duration = endTime - startTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    
    
}
