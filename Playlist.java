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

public class Playlist{
	private String name;
	private String description;
	private Song [] arr;
	private int numSongs;

	public Playlist(){
		this.name = "Untitled";
		this.description = "Your First Playlist. Please add songs here!";
		this.arr = new Song[10];
		Song bleh = new Song();
		arr[0] = bleh;
		this.numSongs = 0;
	}

	public void setName(String nameIn){
		this.name = nameIn;
	}

	public void setDescription(String descriptionIn){
		this.description = descriptionIn;
	}

	public void setArr(Song [] arrIn){
		this.arr = arrIn;
	}

	public String getName(){
		return this.name;
	}

	public String getDescription(){
		return this.description;
	}

	public Song[] getArr(){
		return this.arr;
	}

	public Song[] getLikedSongs(){
		Song [] likedSongs = new Song[10];
		int index = 0;
		for(int i = 0; i<numSongs;i++){
			if(arr[i].getIsLiked()==true){
				likedSongs[index] = arr[i];
				index++;
			}
		}
		return likedSongs;
	}

	public int numLikedSongs(){
		Song [] likedSongs = new Song[10];
		int index = 0;
		for(int i = 0; i<numSongs;i++){
			if(arr[i].getIsLiked()==true){
				likedSongs[index] = arr[i];
				index++;
			}
		}
		return index;
	}

	public boolean hasSong(String songName, String artistName){
		for(int i = 0; i<numSongs;i++){
			String currSongName = arr[i].getName();
			String currArtistName = arr[i].getArtist();
			if(currSongName.equals(songName)&&currArtistName.equals(artistName)){
				return true;
			}
		}
		return false;
	}

	public void addSong(Song song){
		if(numSongs>=arr.length){
			System.out.println("Playlist full!");
		}
		else{
			arr[numSongs] = song;
			numSongs++;
		}
	}

	public Song removeSong (String songName, String artistName){
		int index = 0;
		for(int i = 0; i<numSongs;i++){
			String currName = arr[i].getName();
			String currArtist = arr[i].getArtist();
			if((currName.equals(songName))&&currArtist.equals(artistName)){
				index = i;
			}
		}

		Song removedSong = arr[index];

		for(int i = index;i<numSongs;i++){
			arr[i] = arr[i+1];
		}
		numSongs--;

		return removedSong;
	}

	public String toString(){
		String playlistString = "";
		if(numSongs==0){
			return "Name: "+ this.name + "\n"+ "Description: "+ this.description+ "\n"+ "Songs: "+ "~Playlist is Empty~";
		}
		else{
			for(int i = 0; i<numSongs;i++){
				playlistString += arr[i].toString() + "\n" + "\n";
			}
			return "Name: "+ this.name + "\n"+ "Description: "+ this.description+ "\n"+ "Songs: "+ playlistString;
		}
	}

	public boolean isFull(){
		if(numSongs>=arr.length){
			return true;
		}
		else{
			return false;
		}
	}

	public void likeOrUn(String songName, String artistName){
		int index = 0;
		for(int i = 0; i<numSongs;i++){
			String currSongName = arr[i].getName();
			String currArtistName = arr[i].getArtist();
			if(currSongName.equals(songName)&&currArtistName.equals(artistName)){
				index = i;
			}
		}
		boolean isLiked = arr[index].getIsLiked();
		if(isLiked){
			arr[index].setIsLiked(false);
		}else{
			arr[index].setIsLiked(true);
		}
	}

}