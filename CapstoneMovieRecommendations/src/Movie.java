import java.net.URL;

public class Movie {

	private int imdbIdentifier;
	private String title;
	private int year;
	private String country;
	private String genre;
	private String director;
	private int time;
	private URL imdbURL;

	public Movie(int ident,String t,int y,String c,String g,String dir,int ti,URL url) {
		imdbIdentifier = ident;
		title = t;
		year = y;
		country = c;
		genre = g;
		director = dir;
		time = ti;
		imdbURL = url;
	}

}
