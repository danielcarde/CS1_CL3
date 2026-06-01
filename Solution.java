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

import java.util.Scanner;
import java.io.File;

public class Solution{
	public static void main(String [] args){
		File libraryText = new File("song_library.txt");
		Scanner input = new Scanner(System.in);

		Library lib = new Library();
		listToLibrary(libraryText,lib);
		User user = new User();

		boolean exit = false;

		while(!exit){
			printMenu();
			System.out.print("Select Option: ");
			int userInput = input.nextInt();
			switch(userInput){
				case 1:
					option1(user);
					break;
				case 2:
					option2(user);
					break;
				case 3:
					option3(user);
					break;
				case 4:
					option4(user,lib);
					break;
				case 5:
					option5(user);
					break;
				case 6:
					option6(user);
					break;
				case 7:
					option7(user,lib);
					break;
				case 8:
					exit = true;
					break;
				default:
					System.out.println("Invalid Input. Please Try Again!");
					input.nextLine();
					System.out.println();
			}
		}

	}

	public static boolean AddSongToPlaylistFromLibrary(Library lib, User user, String song){
		Song [] curLib = lib.getArr();
		
		Playlist playlist = user.getPlaylist();

		for(int i = 0; i<curLib.length;i++){
			String curLibString = curLib[i].getName();
			if(curLibString.equals(song)){
				if(!playlist.isFull()){
					playlist.addSong(curLib[i]);
					user.setPlaylist(playlist);
					return true;
				}else{
					System.out.println("Playlist is full!");
					return false;
				}
			}
		}
		return false;
	}

	public static int amountSongs(File fileName){
		int amountLines = 0;
			try{
				Scanner fileReader = new Scanner(fileName);
				while(fileReader.hasNextLine()){
					amountLines++;
					fileReader.nextLine();
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return amountLines;
	}


	public static void listToLibrary(File fileName, Library library){
		try{
			Scanner fileReader = new Scanner(fileName);
			int amountSongs = amountSongs(fileName);
			for(int i = 0; i<amountSongs;i++){
				String currLine = fileReader.nextLine();
				int partOfLine = 1;
				String songName = "";
				String artistName = "";
				String genre = "";
				for(int j = 0;j<currLine.length();j++){
					char currChar = currLine.charAt(j);
					if(currChar == ','){
						partOfLine++;
					}
					else{
						if(partOfLine == 1){
							songName += currChar;
						}
						if(partOfLine == 2){
							artistName += currChar;
						}
						if(partOfLine == 3){
							genre += currChar;
						}
					}
				}
				Song newSong = new Song();
				newSong.setName(songName);
				newSong.setArtist(artistName);
				newSong.setGenre(genre);
				library.addSongToLibrary(newSong);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void printMenu(){
		System.out.println("************************");
		System.out.println(" * Welcome to Utepify! *");
		System.out.println("************************");
		System.out.println("Options");
		System.out.println();
		System.out.println("1. Modify User");
		System.out.println("2. Modify User's Playlist");
		System.out.println("3. Remove Song from Playlist");
		System.out.println("4. Add a song from the library to a Playlist");
		System.out.println("5. List Songs in Playlist");
		System.out.println("6. List Liked Songs in Playlist");
		System.out.println("7. Like/unlike a Song");
		System.out.println("8. Exit Utepify");
		System.out.println("************************");
	}

	public static void option1(User user){
		Scanner input = new Scanner(System.in);

		System.out.println(user.toString());
		System.out.println();
		boolean exit = false;
		while(!exit){
			System.out.println("Would you like to modify username, genre, or continue?");
			String userInput = input.nextLine();
			switch(userInput){
				case "username":
					System.out.print("New Username: ");
					String newUser = input.nextLine();
					user.setUsername(newUser);
					break;
				case "genre":
					System.out.print("New Favorite genre: ");
					String newGenre = input.nextLine();
					user.setGenrePreference(newGenre);
					break;
				case "continue":
					System.out.println("Continuing...");
					exit = true;
					break;
				default:
					System.out.println("Invalid input, continuing...");
					exit = true;
					break;
			}
		}
	}

	public static void option2(User user){
		Scanner input = new Scanner(System.in);

		Playlist userPlaylist = user.getPlaylist();
		System.out.println(userPlaylist.toString());
		System.out.println();
		boolean exit = false;
		while(!exit){
			System.out.println("Would you like to modify name, description, or continue?");
			String userInput = input.nextLine();
			switch(userInput){
				case "name":
					System.out.print("New Playlist Name: ");
					String newName = input.nextLine();
					userPlaylist.setName(newName);
					break;
				case "description":
					System.out.print("New Playlist Description: ");
					String newDescription = input.nextLine();
					userPlaylist.setDescription(newDescription);
					break;
				case "continue":
					System.out.println("Continuing...");
					exit = true;
					break;
				default:
					System.out.println("Invalid input, continuing...");
					exit = true;
					break;
			}
		}
	}

	public static void option3(User user){
		Scanner input = new Scanner(System.in);

		Playlist userPlaylist = user.getPlaylist();
		System.out.println(userPlaylist.toString());
		System.out.println();
		System.out.print("Which song would you like to remove? Please enter the song name: ");
		String pickedSong = input.nextLine();
		System.out.print("Please enter the song artist: ");
		String pickedArtist = input.nextLine();
		boolean hasSong = userPlaylist.hasSong(pickedSong,pickedArtist);
		if(hasSong){
			userPlaylist.removeSong(pickedSong,pickedArtist);
			System.out.println("Removed.");
		}else{
			System.out.println("No such song in the playlist, continuing...");
		}
	}

	public static void option4(User user,Library lib){
		Scanner input = new Scanner(System.in);

		System.out.println(lib.toString());
		System.out.println();
		System.out.print("Which song would you like to add? Please enter the song name: ");
		String pickedSong = input.nextLine();
		System.out.print("Please enter the artist name: ");
		String pickedArtist = input.nextLine();
		boolean hasSong = lib.hasSong(pickedSong,pickedArtist);
		boolean added = false;
		if(hasSong){
			added = AddSongToPlaylistFromLibrary(lib,user,pickedSong);
			if(added){
				System.out.println("Added.");
			}else{
			System.out.println("Playlist is at max capacity, continuing...");
			}
		}else{
			System.out.println("No such song in the library, continuing...");
		}
		
	}

	public static void option5(User user){
		Playlist userPlaylist = user.getPlaylist();
		System.out.println(userPlaylist.toString());
	}

	public static void option6(User user){
		Playlist userPlaylist = user.getPlaylist();
		Song [] likedSongs = userPlaylist.getLikedSongs();
		int amount = userPlaylist.numLikedSongs();
		for(int i = 0; i<amount;i++){
			System.out.println(likedSongs[i].toString());
			System.out.println();
		}
	}

	public static void option7(User user,Library lib){
		Scanner input = new Scanner(System.in);

		Playlist userPlaylist = user.getPlaylist();
		System.out.println(userPlaylist.toString());
		System.out.println();
		System.out.print("Which song would you like to Like or Unlike? Please enter the song name: ");
		String pickedSong = input.nextLine();
		System.out.print("Please enter the song artist: ");
		String pickedArtist = input.nextLine();
		boolean hasSong = userPlaylist.hasSong(pickedSong,pickedArtist);
		if(hasSong){
			userPlaylist.likeOrUn(pickedSong,pickedArtist);
			user.setPlaylist(userPlaylist);
		}else{
			System.out.println("No such song in the playlist, continuing...");
		}
	}

}