public class Bill {
    private String customerId;
    private String name;
    private String type;
    private int units;
    private double amount;

    public Bill(String customerId, String name, String type, int units, double amount) {
        this.customerId = customerId;
        this.name = name;
        this.type = type;
        this.units = units;
        this.amount = amount;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getUnits() { return units; }
    public double getAmount() { return amount; }
}