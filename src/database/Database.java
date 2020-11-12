package database;

public class Database {

    //instance variable
    private static Database instance = null;

    //private constructor
    private Database(){
        //set connection
    }
    //public static getInstance method
    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
