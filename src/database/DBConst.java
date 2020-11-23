package database;

public class DBConst {
    //Create constants to set columns and tables

    //MOVIE TABLE
    public static final String TABLE_MOVIE = "movie";
    public static final String MOVIE_COLUMN_ID = "movie_id";
    public static final String MOVIE_COLUMN_TITLE = "movie_title";
    public static final String MOVIE_COLUMN_DIRECTOR = "director";
    public static final String MOVIE_PRODUCTION_COMPANY = "production_company";
    public static final String MOVIE_RELEASE_YEAR = "release_year";
    public static final String MOVIE_LENGTH_MINUTES = "length_minutes";
    public static final String MOVIE_COLUMN_RATING = "rating";
    public static final String MOVIE_COLUMN_GENRE = "genre";

    //LOGIN TABLE
    public static final String TABLE_LOGIN = "login";
    public static final String LOGIN_COLUMN_ID = "login_id";
    public static final String LOGIN_COLUMN_NAME = "login_name";
    public static final String LOGIN_COLUMN_PASSWORD = "password";

    //USER TABLE
    public static final String TABLE_USER = "user";
    public static final String USER_COLUMN_ID = "user_id";
    public static final String USER_COLUMN_LOGIN_ID = "user_login_id";
    public static final String USER_COLUMN_FIRST_NAME = "first_name";
    public static final String USER_COLUMN_LAST_NAME = "last_name";
    public static final String USER_COLUMN_IS_ADMIN = "is_admin";

    //COMPANY LIST TABLE
    public static final String TABLE_COMPANY = "company_list";
    public static final String COMPANY_COLUMN_ID = "company_id";
    public static final String COMPANY_COLUMN_NAME = "company_name";

    //WATCHED LIST TABLE
    public static final String TABLE_WATCHED_LIST = "watched_movies";
    public static final String WATCHED_LIST_COLUMN_ID = "watched_id";
    public static final String WATCHED_LIST_COLUMN_USER_ID = "user_id";
    public static final String WATCHED_LIST_COLUMN_MOVIE_ID = "movie_id";

    //WISH LIST TABLE
    public static final String TABLE_WISH_LIST = "wish_list_movies";
    public static final String WISH_LIST_COLUMN_ID = "id";
    public static final String WISH_LIST_COLUMN_USER_ID = "user_id";
    public static final String WISH_LIST_COLUMN_MOVIE_ID = "movie_id";

    //CRUD
    //create Company List Table
    public static final String CREATE_TABLE_COMPANY = "CREATE TABLE " + TABLE_COMPANY +
                                                    "(" + COMPANY_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, "
                                                    + COMPANY_COLUMN_NAME + " VARCHAR(40), "
                                                    + "PRIMARY KEY(" + COMPANY_COLUMN_ID + "))";

    //create Login Table
    public static final String CREATE_TABLE_LOGIN = "CREATE TABLE " + TABLE_LOGIN + "(" +
                                                    LOGIN_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, "
                                                    + LOGIN_COLUMN_NAME + " VARCHAR(30), " +
                                                    LOGIN_COLUMN_PASSWORD + " VARCHAR(50), " +
                                                    "PRIMARY KEY(" + LOGIN_COLUMN_ID + "))";

    //create User Table
    public static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER +
                                                    "(" + USER_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                                    + USER_COLUMN_LOGIN_ID + " int NOT NULL, "
                                                    + USER_COLUMN_FIRST_NAME + " VARCHAR(30), "
                                                    + USER_COLUMN_LAST_NAME + " VARCHAR(40), "
                                                    + USER_COLUMN_IS_ADMIN + " BOOLEAN, "
                                                    + "FOREIGN KEY (" + USER_COLUMN_LOGIN_ID + ")"
                                                    + " REFERENCES " + TABLE_LOGIN + "(" + LOGIN_COLUMN_ID + "))";

    //Manageable Movie Table
    public static final String CREATE_TABLE_MOVIE = "CREATE TABLE " + TABLE_MOVIE +
                                                    "(" + MOVIE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                                                    MOVIE_COLUMN_TITLE + " VARCHAR(75), " +
                                                    MOVIE_COLUMN_DIRECTOR + " VARCHAR(50), " +
                                                    MOVIE_PRODUCTION_COMPANY + " int NOT NULL, " +
                                                    MOVIE_RELEASE_YEAR + " int(4) NOT NULL, " +
                                                     MOVIE_LENGTH_MINUTES + " int(3) NOT NULL, " +
                                                    MOVIE_COLUMN_RATING + " VARCHAR(7), " +
                                                    MOVIE_COLUMN_GENRE + " VARCHAR(30), " +
                                                    "FOREIGN KEY (" + MOVIE_PRODUCTION_COMPANY + ")"
                                                    + " REFERENCES " + TABLE_COMPANY + "(" + COMPANY_COLUMN_ID + "))";

    //create Watched List Table
    public static final String CREATE_TABLE_WATCHED = "CREATE TABLE " + TABLE_WATCHED_LIST + "("
                                                    + WATCHED_LIST_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                                    + WATCHED_LIST_COLUMN_USER_ID + " int NOT NULL, "
                                                    + WATCHED_LIST_COLUMN_MOVIE_ID + " int NOT NULL, "
                                                    + "FOREIGN KEY (" + WATCHED_LIST_COLUMN_USER_ID + ")"
                                                    + " REFERENCES " + TABLE_USER + "(" + USER_COLUMN_ID + "),"
                                                    + "FOREIGN KEY (" + WATCHED_LIST_COLUMN_MOVIE_ID + ")"
                                                    + " REFERENCES " + TABLE_MOVIE + "(" + MOVIE_COLUMN_ID + "))";


    //create Wish List Table
    public static final String CREATE_TABLE_WISH_LIST = "CREATE TABLE " + TABLE_WISH_LIST + "("
                                                        + WISH_LIST_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                                                        + WISH_LIST_COLUMN_USER_ID + " int NOT NULL, "
                                                        + WISH_LIST_COLUMN_MOVIE_ID + " int NOT NULL, "
                                                        + "FOREIGN KEY (" + WISH_LIST_COLUMN_USER_ID + ")"
                                                        + " REFERENCES " + TABLE_USER + "(" + USER_COLUMN_ID + "),"
                                                        + "FOREIGN KEY (" + WISH_LIST_COLUMN_MOVIE_ID + ")"
                                                        + " REFERENCES " + TABLE_MOVIE + "(" + MOVIE_COLUMN_ID + "))";




}
