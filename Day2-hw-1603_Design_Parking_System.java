class ParkingSystem {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;

    public ParkingSystem(int big, int medium, int small) {
        bigSlots = big;
        mediumSlots = medium;
        smallSlots = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) { // big
            if (bigSlots > 0) {
                bigSlots--;
                return true;
            }
        } else if (carType == 2) { // medium
            if (mediumSlots > 0) {
                mediumSlots--;
                return true;
            }
        } else if (carType == 3) { // small
            if (smallSlots > 0) {
                smallSlots--;
                return true;
            }
        }
        return false;
    }
}
