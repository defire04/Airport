package domain;

public class Family {
    private final String name;
    private  String travelTo;
    private final int members;

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    private boolean isFamilyInBus = false;

    public Family(String name, String travelTo, int members) {
        this.name = name;
        this.travelTo = travelTo;
        this.members = members;
    }



    public String getName() {
        return name;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public int getMembers() {
        return members;
    }

    public boolean isFamilyInBus() {
        return isFamilyInBus;
    }

    public void setFamilyInBus(boolean familyInBus) {
        isFamilyInBus = familyInBus;
    }

    @Override
    public String toString() {
        return "Family{" +
                "name='" + this.name + '\'' +
                ", travelTo='" + this.travelTo + '\'' +
                ", members=" + this.members +
                '}';
    }
}
