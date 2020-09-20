package ki_17_5.lab_1.task_03;

public class Building {
    private readonly String streetName;
    private readonly Integer floorsNumber;
    private readonly Integer buildingNumber;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(Integer floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Building(String streetName, Integer floorsNumber, Integer buildingNumber) {
        this.streetName = streetName;
        this.floorsNumber = floorsNumber;
        this.buildingNumber = buildingNumber;
    }
}
