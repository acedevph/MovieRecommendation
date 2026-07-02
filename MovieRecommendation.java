import java.util.ArrayList;
import java.util.Scanner;

public class MovieRecommendation {

    static ArrayList<String[]> movieDatabase = new ArrayList<>();

    public static void initializeMovies() {
        // Format: {title, genre, year, rating}
        movieDatabase.add(new String[]{"The Dark Knight", "Action", "2008", "9.0"});
        movieDatabase.add(new String[]{"Mad Max: Fury Road", "Action", "2015", "8.1"});
        movieDatabase.add(new String[]{"John Wick", "Action", "2014", "7.4"});
        movieDatabase.add(new String[]{"Die Hard", "Action", "1988", "8.2"});
        movieDatabase.add(new String[]{"Mission: Impossible", "Action", "1996", "7.1"});

        movieDatabase.add(new String[]{"The Hangover", "Comedy", "2009", "7.7"});
        movieDatabase.add(new String[]{"Superbad", "Comedy", "2007", "7.6"});
        movieDatabase.add(new String[]{"Home Alone", "Comedy", "1990", "7.7"});
        movieDatabase.add(new String[]{"Dumb and Dumber", "Comedy", "1994", "7.3"});
        movieDatabase.add(new String[]{"Knives Out", "Comedy", "2019", "7.9"});

        movieDatabase.add(new String[]{"The Shawshank Redemption", "Drama", "1994", "9.3"});
        movieDatabase.add(new String[]{"Forrest Gump", "Drama", "1994", "8.8"});
        movieDatabase.add(new String[]{"Schindler's List", "Drama", "1993", "9.0"});
        movieDatabase.add(new String[]{"Good Will Hunting", "Drama", "1997", "8.3"});
        movieDatabase.add(new String[]{"A Beautiful Mind", "Drama", "2001", "8.2"});

        movieDatabase.add(new String[]{"Inception", "Sci-Fi", "2010", "8.8"});
        movieDatabase.add(new String[]{"Interstellar", "Sci-Fi", "2014", "8.6"});
        movieDatabase.add(new String[]{"The Matrix", "Sci-Fi", "1999", "8.7"});
        movieDatabase.add(new String[]{"Arrival", "Sci-Fi", "2016", "7.9"});
        movieDatabase.add(new String[]{"Ex Machina", "Sci-Fi", "2014", "7.7"});

        movieDatabase.add(new String[]{"The Conjuring", "Horror", "2013", "7.5"});
        movieDatabase.add(new String[]{"Get Out", "Horror", "2017", "7.7"});
        movieDatabase.add(new String[]{"A Quiet Place", "Horror", "2018", "7.5"});
        movieDatabase.add(new String[]{"It", "Horror", "2017", "7.3"});
        movieDatabase.add(new String[]{"Hereditary", "Horror", "2018", "7.3"});

        movieDatabase.add(new String[]{"The Lion King", "Animation", "1994", "8.5"});
        movieDatabase.add(new String[]{"Spirited Away", "Animation", "2001", "8.6"});
        movieDatabase.add(new String[]{"Toy Story", "Animation", "1995", "8.3"});
        movieDatabase.add(new String[]{"Up", "Animation", "2009", "8.2"});
        movieDatabase.add(new String[]{"Coco", "Animation", "2017", "8.4"});
    }

    public static void displayRecommendations(String genre) {
        ArrayList<String[]> matches = new ArrayList<>();

        for (String[] movie : movieDatabase) {
            if (movie[1].equalsIgnoreCase(genre)) {
                matches.add(movie);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("\n  No movies found for genre: " + genre);
            System.out.println("  Try: Action, Comedy, Drama, Sci-Fi, Horror, Animation");
        } else {
            System.out.println("\n  ╔══════════════════════════════════════════════════════╗");
            System.out.printf("  ║  %-20s Movies (%d found)%15s║%n", genre, matches.size(), "");
            System.out.println("  ╠══════════════════════════════════════════════════════╣");
            System.out.printf("  ║  %-3s %-30s %-6s %-6s  ║%n", "No.", "Title", "Year", "Rating");
            System.out.println("  ╠══════════════════════════════════════════════════════╣");

            int count = 1;
            for (String[] movie : matches) {
                System.out.printf("  ║  %-3d %-30s %-6s ⭐ %-4s ║%n",
                        count++, movie[0], movie[2], movie[3]);
            }
            System.out.println("  ╚══════════════════════════════════════════════════════╝");
        }
    }

    public static void main(String[] args) {
        initializeMovies();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       🎬 MOVIE RECOMMENDATION SYSTEM      ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("\n  Available Genres:");
        System.out.println("  1. Action     4. Sci-Fi");
        System.out.println("  2. Comedy     5. Horror");
        System.out.println("  3. Drama      6. Animation");

        boolean continueSearch = true;

        while (continueSearch) {
            System.out.print("\n  Enter preferred genre (or 'quit' to exit): ");
            String genre = scanner.nextLine().trim();

            if (genre.equalsIgnoreCase("quit") || genre.equalsIgnoreCase("exit")) {
                System.out.println("\n  Thanks for using Movie Recommendation System! 🎬");
                break;
            }

            if (genre.isEmpty()) {
                System.out.println("  Please enter a genre.");
                continue;
            }

            displayRecommendations(genre);

            System.out.print("\n  Search another genre? (yes/no): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                continueSearch = false;
                System.out.println("\n  Enjoy your movie! 🍿");
            }
        }

        scanner.close();
    }
}
