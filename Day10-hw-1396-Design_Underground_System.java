import java.util.*;
class UndergroundSystem {
    private Map<Integer, String[]> checkIns; 
    private Map<String, double[]> routeData; 
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeData = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new String[]{stationName, String.valueOf(t)});
    }
    public void checkOut(int id, String stationName, int t) {
        String[] checkInData = checkIns.remove(id);
        String startStation = checkInData[0];
        int startTime = Integer.parseInt(checkInData[1]);
        String route = startStation + "->" + stationName;
        int travelTime = t - startTime;
        routeData.putIfAbsent(route, new double[2]);
        routeData.get(route)[0] += travelTime; // total time
        routeData.get(route)[1] += 1;          // trip count
    }
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        double[] data = routeData.get(route);
        return data[0] / data[1];
    }
}
