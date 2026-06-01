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

public class Library{
	
	private Song [] arr;
	private int numSongs;

	public Library(){
		this.arr = new Song[20];
		Song bleh = new Song();
		arr[0] = bleh;
		this.numSongs = 0;
	}

	public void setArr(Song [] libraryIn){
		this.arr = libraryIn;
	}

	public Song [] getArr(){
		return this.arr;
	}

	public void addSongToLibrary(Song song){
		if(numSongs>=arr.length){
			System.out.println("Library full!");
		}else{
		arr[numSongs] = song;
		numSongs++;	
		}
	}

	public String toString(){
		String libraryString = "";
		if(numSongs==0){
			return "Library is Empty";
		}
		else{
			for(int i = 0; i<numSongs;i++){
				libraryString += arr[i].toString() + "\n" + "\n";
			}
			return "Library: " + libraryString;
		}
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
}