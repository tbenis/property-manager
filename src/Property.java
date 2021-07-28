/**
 * Propery class.
 *
 * @author Benis Tambe
 *
 */
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    /**
     * non-Parameterized Constructor
     */
    public Property(){
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0;
        this.owner = "";
        this.plot = new Plot(0,0,1,1);
    }
    /** Copy Constructor
     */
    public Property(Property property){
        this.propertyName = property.propertyName;
        this.city = property.city;
        this.rentAmount = property.rentAmount;
        this.owner = property.owner;
        this.plot = property.plot;
    }
    /** Parameterized Constructor with default plot values
     * @param propertyName
     * @param city
     * @param rentAmount
     * @param owner
     */
    public Property(String propertyName, String city, double rentAmount, String owner){
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(0,0,1,1);
    }
    /** Parameterized Constructor
     * @param propertyName
     * @param city
     * @param rentAmount
     * @param owner
     * @param x
     * @param y
     * @param w
     * @param d
     */
    public Property(String propertyName, String city, double rentAmount, String owner, int x,int y, int d, int w){
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x,y,d,w);
    }

    /**
     * Class getter and setter methods
     */
    public String getCity() {
        return city;
    }

    public String getOwner() {
        return owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOwner(String owner) { this.owner = owner; }

    public void setPropertyName(String name) {
        this.propertyName = name;
    }

    public void setRentAmount(double rentalAmount) {
        this.rentAmount = rentalAmount;
    }

    public Plot getPlot() { return this.plot; }

    /** toString method overrides java toString method and returns a string
     * @return
     */
    public String toString(){
        return "Property Name: "+ this.propertyName +
                "\n Located in: "+ this.city +
                "\n Belonging to: "+ this.owner +
                "\n Rent Amount: "+ this.rentAmount;
    }

}
