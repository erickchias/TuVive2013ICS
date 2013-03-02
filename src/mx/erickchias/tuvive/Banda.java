package mx.erickchias.tuvive;

public class Banda {
    int _id;
    String name;
    String day;
    String schedule;
    String place;
 
    public Banda(){
 
    }

    public Banda(int id, String name, String _day, String _schedule){
        this._id = id;
        this.name = name;
        this.day = _day;
        this.schedule = _schedule;
    }
    public Banda(String name, String _day, String schedule,String place){
        this.name = name;
        this.day = _day;
        this.schedule = schedule;
        this.place = place;
    }
 
    public int getID(){
        return this._id;
    }
 
    public void setID(int id){
        this._id = id;
    }
 
    public String getName(){
        return this.name;
    }
 
    public void setName(String name){
        this.name = name;
    }
 
    public String getDay(){
        return this.day;
    }
 
    public void setDay(String day){
        this.day = day;
    }
    
    public String getSchedule(){
        return this.schedule;
    }
 
    public void setSchedule(String schedule){
        this.schedule = schedule;
    }

    public String getPlace(){
        return this.place;
    }
 
    public void setPlace(String place){
        this.place = place;
    }

}
