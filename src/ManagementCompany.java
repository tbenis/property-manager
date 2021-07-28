/**
 * ManagementCompany class.
 *
 * @author Benis Tambe
 */

public class ManagementCompany {
    private static final int MAX_PROPERTY = 5;
    private static final int MGMT_DEPTH = 10;
    private final int MGMT_WIDTH = 10;
    private String name;
    private String taxID;
    private double mgmFeePer;
    private int count = 0;
    private Property[] properties;// = new Property[MAX_PROPERTY];
    private Plot plot;

    /**
     * A management company non-parameterized constructor with default values.
     */
    public ManagementCompany() {
        properties = new Property[MAX_PROPERTY];
        this.name = "";
        this.taxID = "";
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    /**
     * A management company parameterized constructor with a default company plot.
     * @param name name of the company
     * @param taxID taxID of the property
     * @param mgmFee management fee
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
        properties = new Property[MAX_PROPERTY];
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }
    /**
     * A management company parameterized constructor.
     * @param name name of the company
     * @param taxID taxID of the property
     * @param mgmFee management fee
     * @param x
     * @param y
     * @param width
     * @param depth
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        properties = new Property[MAX_PROPERTY];
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
    }

    /**
     * Copy constructor creates a ManagementCompany object using another ManagementComapany object..
     * @param theCompany otherCompany is an object that is a copy
     */
    public ManagementCompany(ManagementCompany theCompany) {
        properties = new Property[MAX_PROPERTY];
        name = theCompany.name;
        taxID = theCompany.taxID;
        mgmFeePer = theCompany.mgmFeePer;
        plot = theCompany.plot;
    }

    /** addProperty method takes in a property object and returns a int
     * @param property
     * @return
     */
    public int addProperty(Property property) {
        if (property == null) {
            return -2;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && i < MAX_PROPERTY - 1) {
                if (properties[i].getPlot().overlaps(property.getPlot())) {
                    return -4;
                }
            } else if (properties[i] != null && i >= MAX_PROPERTY - 1) {
                return -1;
            } else {
                properties[i] = property;
                return i;
            }
        }
        return -1;
    }
    /**
     * addProperty method takes in a property object and returns a int.
     * @param name name of the company
     * @param city taxID of the property
     * @param rent management fee
     * @return
     */
    public int addProperty(String name, String city, double rent, String owner) {
        //create a property object.
        Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
        //adds the property object to properties array.
        properties[count] = property;
        count++;
        int i;
        for (i = 0; i < count; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
        }

        if (count == MAX_PROPERTY) {
            return -1;
        }
        if (this.plot.encompasses(property.getPlot())) {
            return -3;
        } else {
            properties[count] = property;
            count++;
            return count;
        }
    }

    /** addProperty method takes in a property object and returns a int
     * @param propertyName
     * @param city
     * @param rent
     * @param ownerName
     * @param x
     * @param y
     * @param width
     * @param depth
     * @return
     */
    public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
        int i;
        Property property = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
        properties[count] = property;

        for (i = 0; i < count; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
        }
        if (count == MAX_PROPERTY) {
            return -1;
        } else if (this.plot.encompasses(property.getPlot())) {
            return -3;
        } else {
            properties[count] = property;
            count++;
            return count;
        }
    }
    /** displayPropertyAtIndex method takes in a property object and returns a string
     * @param i
     * @return
     */
    public String displayPropertyAtIndex(int i) {
        String str = "";
        if (properties[i] != null) {
            str =
                    (
                            "Owner: " +
                                    properties[i].getOwner() +
                                    "City: " +
                                    properties[i].getCity() +
                                    "Property Name: " +
                                    properties[i].getPropertyName() +
                                    "Rent Amount: " +
                                    properties[i].getRentAmount() +
                                    "Plot: " +
                                    properties[i].getPlot()
                    );
        }
        return str;
    }
    /** getMAX_PROPERTY method returns a string
     * @return
     */
    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    /** maxRentProp method returns a string
     * @return
     */
    public String maxRentProp() {
        return properties[maxRentPropertyIndex()].toString();
    }
//    public double maxRentProp() { return properties[maxRentPropertyIndex()].getRentAmount(); }

    /** maxRentPropertyIndex method returns a innt
     * @return
     */
    public int maxRentPropertyIndex() {
        int indexOFMaxRent = 0;

        for (int i = 0; i < count; i++) {
            if (properties[i] != null) {
                if (
                        properties[indexOFMaxRent].getRentAmount() <
                                properties[i].getRentAmount()
                ) {
                    indexOFMaxRent = i;
                }
            }
        }

        return indexOFMaxRent;
    }
    /** toString method overrides java toString method and returns a string
     * @return
     */
    public String toString() {
        String printContent = "";
        System.out.println("List of the properties for Alliance, taxID: " + taxID);

        System.out.println("________________________________");

        for (int i = 0; i < count; i++) {
            if (properties[i] != null) {
                printContent = (
                        " Property Name: " +
                                properties[i].getPropertyName() +
                                "\n" +
                                " Located in: " +
                                properties[i].getCity() +
                                "\n" +
                                " Belonging to: " +
                                properties[i].getOwner() +
                                "\n" +
                                " Rent Amount: " +
                                properties[i].getRentAmount()
                );
            }
        }
        System.out.println("________________________________");
        System.out.println("Total management Fee: " + mgmFeePer);

        return printContent;
    }

    /**
     * A method that adds up all the amounts of rent.
     */
    public double totalRent() {
        double totalRent = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                break;
            } else {
                totalRent += properties[i].getRentAmount();
            }
        }
        return totalRent;
    }

    /**
     * A method that returns management company's name.
     */
    public String getName() {
        return name;
    }
    /**
     * A method that returns management company's plot.
     */
    public Plot getPlot() {
        return plot;
    }

}

