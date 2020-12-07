package student;

/**
 *
 * @author Denmar Ermitano
 */
public class Address {
    private String aptNum;
    private String streetNum;
    private String streetName;
    private String city;
    private String province;
    private String zipcode;

    /**
     * Default constructor
     */
    public Address() {
        this.aptNum = null;
        this.streetNum = null;
        this.streetName = null;
        this.city = null;
        this.province = null;
        this.zipcode = null;
    }
    
    /**
     * Constructor with all data members
     * @param aptNum the number of the apartment
     * @param streetNum the number of the street
     * @param streetName the name of the street
     * @param city the name of the city
     * @param province the name of the province
     * @param zipcode the zipcode
     */
    public Address(String aptNum, String streetNum, String streetName, 
            String city, String province, String zipcode) {
        this.aptNum = aptNum;
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.zipcode = zipcode;
    }

    /**
     * Copy constructor
     * @param address the address to copy
     */
    public Address(Address address) {
        this.aptNum = address.aptNum;
        this.streetNum = address.streetNum;
        this.streetName = address.streetName;
        this.city = address.city;
        this.province = address.province;
        this.zipcode = address.zipcode;
    }
    
    /**
     * To check if a zipcode is valid or not, template: A1A 1A1
     * @param zipcode the zipcode you want to check
     * @return true if the zipcode is valid, false if the zipcode is not valid
     */
    public boolean isZipCodeValid(String zipcode) {
        if (zipcode.length() != 7)
            return false;
        for (int i = 0; i < zipcode.length(); i++) {
            if ((i == 0 || i == 2 || i == 5) && !Character.isLetter(zipcode.charAt(i)))
                return false;
            if ((i == 1 || i == 4 || i == 6) && !Character.isDigit(zipcode.charAt(i)))
                return false;
        }
        return zipcode.charAt(3) == ' ';
    }
    
    /**
     * To compare two addresses
     * @param address the address to compare
     * @return true if the addresses are the same, false if they are different
     */
    public boolean equals (Address address) {
        return this.aptNum.equals(address.aptNum) &&
               this.streetNum.equals(address.streetNum) &&
               this.streetName.equals(address.streetName) &&
               this.city.equals(address.city) &&
               this.province.equals(address.province) &&
               this.zipcode.equals(address.zipcode);
    }
    
    /**
     * To generate a string representing the address
     * @return the string representing the address
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-12s %s %s %s\n", "", aptNum, streetNum, streetName);
        str += String.format("%-12s %s %s, %s\n", "", city, province, zipcode);
        
        return str;
    }

    public String getAptNum() {
        return aptNum;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        if (isZipCodeValid(zipcode))
            this.zipcode = zipcode.toUpperCase();
        else
            System.out.printf("%s is not a valid zipcode\n", zipcode);
    }
}


