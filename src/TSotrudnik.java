public class TSotrudnik extends TPerson {
    protected String serviceNumber;

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public TSotrudnik(String surName, String Name, String middleName, String serviceNumber){
        super(surName,Name,middleName);
        this.serviceNumber = serviceNumber;

    }
    public String getFullData() {
        return (super.getFullData() + " " + this.getServiceNumber());
    }

}
