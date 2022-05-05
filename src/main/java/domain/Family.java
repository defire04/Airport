package domain;

public class Family {
    private final String name;
    private final String travelTo;
    private final int members;

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

    @Override
    public String toString() {
        return "Family{" +
                "name='" + this.name + '\'' +
                ", travelTo='" + this.travelTo + '\'' +
                ", members=" + this.members +
                '}';
    }
}
