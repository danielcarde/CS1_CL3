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

public class Song{
	
	private String name;
	private String artist;
	private String genre;
	private boolean isLiked;

	public Song(){
		this.name = "Untitled Song";
		this.artist = "Unkown Artist";
		this.genre = "None";
		this.isLiked = false;
	}

	public Song(String nameIn,String artistIn, String genreIn, boolean isLikedIn){
		this.name = nameIn;
		this.artist = artistIn;
		this.genre = genreIn;
		this.isLiked = isLikedIn;
	}

	public void setName(String nameIn){
		this.name = nameIn;
	}
	public void setArtist(String artistIn){
		this.artist = artistIn;
	}
	public void setGenre(String genreIn){
		this.genre = genreIn;
	}
	public void setIsLiked(boolean isLikedIn){
		this.isLiked = isLikedIn;
	}

	public String getName(){
		return this.name;
	}
	public String getArtist(){
		return this.artist;
	}
	public String getGenre(){
		return this.genre;
	}
	public boolean getIsLiked(){
		return this.isLiked;
	}


	public String toString(){
		return "Song Name: " + this.name + "\n  Artist Name: " + this.artist + "\n  Song Genre: " + this.genre + "\n  Is Liked: " + this.isLiked;
	}

}