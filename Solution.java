import java.util.*;

class TravelAgencies {
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;


    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }


    public int getRegNo() {
        return regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}

public class Solution {


    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr) {
        int max = Integer.MIN_VALUE;

        for (TravelAgencies t : arr) {
            if (t.getPrice() > max) {
                max = t.getPrice();
            }
        }

        return max;
    }


    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] arr, int regNo, String packageType) {

        for (TravelAgencies t : arr) {
            if (t.getRegNo() == regNo &&
                t.getPackageType().equalsIgnoreCase(packageType) &&
                t.isFlightFacility()) {

                return t;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        TravelAgencies[] arr = new TravelAgencies[n];

        for (int i = 0; i < n; i++) {
            int regNo = sc.nextInt();
            sc.nextLine();

            String name = sc.nextLine();
            String type = sc.nextLine();

            int price = sc.nextInt();
            boolean flight = sc.nextBoolean();
            sc.nextLine();

            arr[i] = new TravelAgencies(regNo, name, type, price, flight);
        }

        int searchRegNo = sc.nextInt();
        sc.nextLine();
        String searchType = sc.nextLine();


        int maxPrice = findAgencyWithHighestPackagePrice(arr);
        System.out.println(maxPrice);


        TravelAgencies result = agencyDetailsForGivenIdAndType(arr, searchRegNo, searchType);

        if (result != null) {
            System.out.println(result.getAgencyName() + ":" + result.getPrice());
        }
        sc.close();
    }
}

// Added in feature branch