import java.util.*;

// Abstract interface for common database operations
interface DatabaseOperations {
    void createTable(String tableName);

    void insertRecord(String tableName, String... fields);

    void displayTable(String tableName);
}

// Class representing a single table with generic columns
class Table {
    private String name;
    private List<List<String>> records;
    private List<String> columns;

    public Table(String name, List<String> columns) {
        this.name = name;
        this.columns = columns;
        this.records = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRecord(List<String> record) {
        if (record.size() == columns.size()) {
            records.add(record);
        } else {
            System.out.println("Record does not match table column structure.");
        }
    }

    public void displayRecords() {
        System.out.println("\nTable: " + name);
        System.out.println(String.join(" | ", columns));
        System.out.println("----------------------------------");
        for (List<String> record : records) {
            System.out.println(String.join(" | ", record));
        }
    }
}

// Main DBMS class to manage multiple tables
class MolestieDBMS implements DatabaseOperations {
    private Map<String, Table> tables;

    public MolestieDBMS() {
        tables = new HashMap<>();
    }

    @Override
    public void createTable(String tableName) {
        switch (tableName) {
            case "PlantID":
                tables.put(tableName, new Table(tableName, Arrays.asList("ID", "Description")));
                break;
            case "PlantName":
                tables.put(tableName, new Table(tableName, Arrays.asList("PlantID", "Name")));
                break;
            case "Location":
                tables.put(tableName, new Table(tableName, Arrays.asList("PlantID", "Location")));
                break;
            case "GrowthStage":
                tables.put(tableName, new Table(tableName, Arrays.asList("PlantID", "Stage")));
                break;
            case "CareActivities":
                tables.put(tableName, new Table(tableName, Arrays.asList("PlantID", "Activity")));
                break;
            default:
                System.out.println("Unknown table name: " + tableName);
        }
    }

    @Override
    public void insertRecord(String tableName, String... fields) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.addRecord(Arrays.asList(fields));
        } else {
            System.out.println("Table " + tableName + " does not exist.");
        }
    }

    @Override
    public void displayTable(String tableName) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.displayRecords();
        } else {
            System.out.println("Table " + tableName + " does not exist.");
        }
    }
}

public class MolestieDatabaseSystem {
    public static void main(String[] args) {
        MolestieDBMS dbms = new MolestieDBMS();

        // Creating tables
        dbms.createTable("PlantID");
        dbms.createTable("PlantName");
        dbms.createTable("Location");
        dbms.createTable("GrowthStage");
        dbms.createTable("CareActivities");

        // Inserting records
        dbms.insertRecord("PlantID", "1", "Unique identifier for Mango");
        dbms.insertRecord("PlantID", "2", "Unique identifier for Jackfruit");
        dbms.insertRecord("PlantID", "3", "Unique identifier for Papaya");
        dbms.insertRecord("PlantID", "4", "Unique identifier for Rose");
        dbms.insertRecord("PlantID", "5", "Unique identifier for Tulip");
        dbms.insertRecord("PlantID", "6", "Unique identifier for Rajanigandha");
        dbms.insertRecord("PlantID", "7", "Unique identifier for Hasnahena");
        dbms.insertRecord("PlantID", "8", "Unique identifier for Joba");
        dbms.insertRecord("PlantID", "9", "Unique identifier for Beli");
        dbms.insertRecord("PlantID", "10", "Unique identifier for Mango (Orchard)");

        dbms.insertRecord("PlantName", "1", "Mango");
        dbms.insertRecord("PlantName", "2", "Jackfruit");
        dbms.insertRecord("PlantName", "3", "Papaya");
        dbms.insertRecord("PlantName", "4", "Rose");
        dbms.insertRecord("PlantName", "5", "Tulip");
        dbms.insertRecord("PlantName", "6", "Rajanigandha");
        dbms.insertRecord("PlantName", "7", "Hasnahena");
        dbms.insertRecord("PlantName", "8", "Joba");
        dbms.insertRecord("PlantName", "9", "Beli");
        dbms.insertRecord("PlantName", "10", "Mango (Orchard)");

        dbms.insertRecord("Location", "1", "Garden");
        dbms.insertRecord("Location", "2", "Backyard");
        dbms.insertRecord("Location", "3", "Farm");
        dbms.insertRecord("Location", "4", "Balcony");
        dbms.insertRecord("Location", "5", "Greenhouse");
        dbms.insertRecord("Location", "6", "Balcony");
        dbms.insertRecord("Location", "7", "Garden");
        dbms.insertRecord("Location", "8", "Backyard");
        dbms.insertRecord("Location", "9", "Garden");
        dbms.insertRecord("Location", "10", "Orchard");

        dbms.insertRecord("GrowthStage", "1", "Sapling");
        dbms.insertRecord("GrowthStage", "2", "Mature");
        dbms.insertRecord("GrowthStage", "3", "Growing");
        dbms.insertRecord("GrowthStage", "4", "Blooming");
        dbms.insertRecord("GrowthStage", "5", "Budding");
        dbms.insertRecord("GrowthStage", "6", "Blooming");
        dbms.insertRecord("GrowthStage", "7", "Budding");
        dbms.insertRecord("GrowthStage", "8", "Mature");
        dbms.insertRecord("GrowthStage", "9", "Blooming");
        dbms.insertRecord("GrowthStage", "10", "Sapling");

        dbms.insertRecord("CareActivities", "1", "Water daily");
        dbms.insertRecord("CareActivities", "2", "Prune branches");
        dbms.insertRecord("CareActivities", "3", "Add fertilizer");
        dbms.insertRecord("CareActivities", "4", "Remove wilted flowers");
        dbms.insertRecord("CareActivities", "5", "Maintain temperature");
        dbms.insertRecord("CareActivities", "6", "Water moderately");
        dbms.insertRecord("CareActivities", "7", "Add compost");
        dbms.insertRecord("CareActivities", "8", "Water regularly");
        dbms.insertRecord("CareActivities", "9", "Remove dry leaves");
        dbms.insertRecord("CareActivities", "10", "Protect from pests");

        // Displaying tables
        dbms.displayTable("PlantID");
        dbms.displayTable("PlantName");
        dbms.displayTable("Location");
        dbms.displayTable("GrowthStage");
        dbms.displayTable("CareActivities");
    }
}

