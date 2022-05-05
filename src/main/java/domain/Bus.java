package domain;

public class Bus {
    private final int passengersCount;
    private final String driveTo;

    public Bus(int passengersCount, String driveTo) {
        this.passengersCount = passengersCount;
        this.driveTo = driveTo;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public String getDriveTo() {
        return driveTo;
    }
}
