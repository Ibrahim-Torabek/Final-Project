package database;

public class DBConst {
    //Create constants to set columns and tables

    //MOVIE TABLE
    public static final String TABLE_MOVIE = "movie";
    public static final String MOVIE_COLUMN_ID = "id";
    public static final String MOVIE_COLUMN_TITLE = "title";
    public static final String MOVIE_COLUMN_DIRECTOR = "director";
    public static final String MOVIE_PRODUCTION_COMPANY = "production_company";
    public static final String MOVIE_RELEASE_DATE = "release_date";
    public static final String MOVIE_LENGTH_MINUTES = "length_minutes";
    public static final String MOVIE_COLUMN_RATING = "rating";
    public static final String MOVIE_COLUMN_GENRE = "genre";

    //LOGIN TABLE
    public static final String TABLE_LOGIN = "login";
    public static final String LOGIN_COLUMN_ID = "id";
    public static final String LOGIN_COLUMN_NAME = "name";
    public static final String LOGIN_COLUMN_PASSWORD = "password";

    //USER TABLE
    public static final String TABLE_USER = "user";
    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_LOGIN_ID = "login_id";
    public static final String USER_COLUMN_FIRST_NAME = "first_name";
    public static final String USER_COLUMN_LAST_NAME = "last_name";
    public static final String USER_COLUMN_IS_ADMIN = "is_admin";

    //COMPANY LIST TABLE
    public static final String TABLE_COMPANY = "company_list";
    public static final String COMPANY_COLUMN_ID = "id";
    public static final String COMPANY_COLUMN_NAME = "name";

    //WATCHED LIST TABLE
    public static final String TABLE_WATCHED = "company_list";
    public static final String WATCHED_COLUMN_ID = "id";
    public static final String WATCHED_COLUMN_USER_ID = "user_id";
    public static final String WATCHED_COLUMN_MOVIE_ID = "movie_id";

    //WISH LIST TABLE
    public static final String TABLE_WISH_LIST = "wish_list";
    public static final String WISH_LIST_COLUMN_ID = "id";
    public static final String WISH_LIST_COLUMN_USER_ID = "user_id";
    public static final String WISH_LIST_COLUMN_MOVIE_ID = "movie_id";

    //CRUD
    public static final String CREATE_TABLE_MOVIE = "CREATE TABLE " + TABLE_MOVIE +
            "(" + MOVIE_COLUMN_ID + "int NOT NULL AUTO_INCREMENT, " + MOVIE_COLUMN_TITLE +
            " VARCHAR(75), " + MOVIE_COLUMN_DIRECTOR + " VARCHAR(50), " +
            MOVIE_PRODUCTION_COMPANY + " VARCHAR(70), " + MOVIE_RELEASE_DATE + " VARCHAR(11), " +
             MOVIE_LENGTH_MINUTES + " int(3), " + MOVIE_COLUMN_RATING + " VARCHAR(7), " +
            MOVIE_COLUMN_GENRE + " VARCHAR(30), " + "PRIMARY KEY(" + MOVIE_COLUMN_ID + ")" + ")";



}
