package edu.wwu.addictionhelperlog;

/**
 * Created by dell on 9/16/2017.
 */

public class Entry {
    private int id;
    private String date;
    private String addiction;
    private String cause;
    private String amount;
    private String cost;
    private String who;
    private String where;

    public Entry(int newId, String newDate, String newAddiction, String newCause,
                 String newAmount, String newCost/*, String newWho, String newWhere*/){
        setId(newId);
        setDate(newDate);
        setAddiction(newAddiction);
        setCause(newCause);
        setAmount(newAmount);
        setCost(newCost);
//        setWho(newWho);
//        setWhere(newWhere);
    }

    public void setId(int newId){ id = newId; }

    public void setDate(String newDate){ date = newDate; }

    public void setAddiction(String newAddiction){ addiction = newAddiction; }

    public void setCause(String newCause){ cause = newCause; }

    public void setAmount(String newAmount){ amount = newAmount; }

    public void setCost(String newCost){ cost = newCost; }

//    public void setWho(String newWho){ who = newWho; }
//
//    public void setWhere(String newWhere){ where = newWhere; }

    public int getId(){ return id; }

    public String getDate(){ return date; }

    public String getAddiction() { return addiction; }

    public String getCause() { return cause; }

    public String getAmount() { return amount; }

    public String getCost() { return cost; }

//    public String getWho() { return who; }
//
//    public String getWhere() { return where; }

    public String toString(){
        return id + "; " + date + "; " + addiction + "; " + cause + "; " + amount + "; " + cost/* + "; " + who + "; " + where*/;
    }
}
