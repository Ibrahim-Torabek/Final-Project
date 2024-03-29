package pojo;


/**
 * <h1>Movie Tracer Program</h1>
 * <h2>Java Project of MAD300 Course</h2>
 * <p>This class is a Plain Old Java Object class to pretty display Movie List. It is used by Movie Table,
 * WatchedList Table and WishList Table.
 * </p>
 *
 * @author  Ibrahim Osman, Elena Polyakova
 * @version 1.0
 * @since   2020-11-20
 *
 * @see tables.MovieTable
 * @see tables.WatchedListTable
 * @see tables.WishListTable
 *
 */
public class DisplayMovie {
    private int id;
    private String movieTitle;
    private String director;
    private String productionCompany;
    private int releaseYear;
    private int lengthMinutes;
    private String rating;
    private String genre;

    public DisplayMovie(int id, String movieTitle, String director, String productionCompany, int releaseYear, int lengthMinutes, String rating, String genre) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.director = director;
        this.productionCompany = productionCompany;
        this.releaseYear = releaseYear;
        this.lengthMinutes = lengthMinutes;
        this.rating = rating;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return movieTitle;
    }
}
