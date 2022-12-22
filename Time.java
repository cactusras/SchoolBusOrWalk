public class Time {
    private int hour=0;
    private int minute=0;
    public Time(int hour, int minute){
        setHour(hour);
        setMinute(minute);
    }
    public Time (int minute) {//例：130 min → 02:10
        setHour(minute/60);
        setMinute(minute%60);
    }
    public int getHour (){
        return hour;
    }
    public int getMinute (){
        return minute;
    }
    public void setHour(int hour){
        this.hour=hour;
    }
    public void setMinute(int minute){
        this.minute=minute;
    }
    public int howManyMinute() {//例：02:10 → 130 min
        int min=0;
        min=getHour()*60+getMinute();
        return min;
    }
    public void add(Time later) {// 01:00+00:30=01:30
        int min = howManyMinute()+later.howManyMinute();
        setHour(min/60);
        setMinute(min%60);
    }
    public void subtract(Time before) {// 01:00-00:30=00:30 算差(恆正)
        int min = Math.abs(howManyMinute()-before.howManyMinute());
        setHour(min/60);
        setMinute(min%60);
    }
}