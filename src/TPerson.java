public class TPerson {
    private String name, surName, middleName;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurName() {
        return surName;
    }

    public TPerson(String surName, String Name, String middleName){
        this.surName = surName;
        this.name = Name;
        this.middleName = middleName;

    }
    public String getFullData() {
        return (this.surName + " " + this.name + " " + this.middleName);
    }
}
