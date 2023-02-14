public class TStudent extends TPerson {

    protected String group, year;

    public String getGroup() {
        return group;
    }

    public String getYear() {
        return year;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public TStudent(String surName, String Name, String middleName, String group, String year){
        super(surName, Name, middleName);
        this.group = group;
        this.year = year;
    }

    public String getFullData() {
        return (super.getFullData() + " " + this.group + " " + this.year);
    }

}
