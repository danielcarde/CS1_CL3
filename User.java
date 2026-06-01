 /* Daniel Adrian Cardenas
 [CS1101] Comprehensive Lab 3
 This work is to be done individually. It is not permitted 
to. share, reproduce, or alter any part of this assignment 
for any purpose. Students are not permitted to share code, 
upload this assignment online in any form, or 
view/receive/ modifying code written by anyone else. This 
assignment is part of an academic course at The University 
of Texas at El Paso and a grade will be assigned for the 
work produced individually by the student.
 */

public class User{
	
	private String username;
	private String genrePreference;
	private Playlist userPlaylist;

	public User(){
		this.username = "Default User";
		this.genrePreference = "None";
		this.userPlaylist = new Playlist();
	}

	public void setUsername(String usernameIn){
		this.username = usernameIn;
	}

	public void setGenrePreference(String genrePreferenceIn){
		this.genrePreference = genrePreferenceIn;
	}

	public void setPlaylist(Playlist userPlaylistIn){
		this.userPlaylist = userPlaylistIn;
	}

	public String getUsername(){
		return this.username;
	}

	public String getGenrePreference(){
		return this.genrePreference;
	}

	public Playlist getPlaylist(){
		return this.userPlaylist;
	}

	public String toString(){
		Playlist userP = this.userPlaylist;
		return "Username: " + this.username + "\nUser Genre Preference: " + this.genrePreference + "\nPlaylist: " + "\n" + userP.toString();
	}

}