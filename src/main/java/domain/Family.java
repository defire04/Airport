package domain;

import java.util.Objects;

public class Family {
    private final String name;
    private  String travelTo;

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    private final int members;
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

    public boolean getIsFamilyInBus() {
        return isFamilyInBus;
    }

    public void setFamilyInBus(boolean familyInBus) {
        isFamilyInBus = familyInBus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return members == family.members && isFamilyInBus == family.isFamilyInBus && Objects.equals(name, family.name) && Objects.equals(travelTo, family.travelTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, travelTo, members, isFamilyInBus);
    }

    @Override
    public String toString() {
        return "Family = " + this.name +
                " TravelTo=" + this.travelTo +
                " Members=" + this.members + " ";
    }
}
