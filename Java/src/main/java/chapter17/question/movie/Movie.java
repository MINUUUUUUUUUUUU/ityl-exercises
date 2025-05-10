package chapter17.question.movie;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie implements Comparable<Movie> {
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;

    @Override
    public int compareTo(Movie o) {
        return Double.compare(this.rating, o.rating);
    }
}
