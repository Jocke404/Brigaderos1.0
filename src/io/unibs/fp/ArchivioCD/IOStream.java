package io.unibs.fp.ArchivioCD;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class IOStream {
	
	//String constants used 
	public static final String EMPTY_ARCHIVE = "Sorry, the archive is empty";
	public static final String NOT_FOUND = "Sorry, element not found";
	public static final String ALREDY_ADDED = "Sorry, this element has alredy been added in the collecion";
	public static final String SEARCH_MENU_TITLE = "Welcome, by which paramether would you like to serach for?";
	public static final String[] SEARCH_OPERATORS = {"By album title", "By track title", "By author"};
	public static final String CONFIRMATION_MENU_TITLE = "Are you sure?";
	public static final String[] CONFIRMATION_OPTIONS = {"Yes, i'm sure", "No I'm not"};
	
	//the next are the menu constants 
	public static final int CONFIRM_OPTION = 1;
	public static final int DENY_OPTION = 2;
	public static final int SEARCH_BY_ALBUM = 1;
	public static final int SEARCH_BY_TRACK = 2;
	public static final int SEARCH_BY_AUTHOR = 3;
	
	public static String askTitle() {
		String title = InputDati.leggiStringa("What is his name?");
		return title;
	}
	
	public static PlayTime askPlayTime() {
		int minutes, seconds;
		minutes = InputDati.leggiIntero("Insert duration time: Minutes");
		seconds = InputDati.leggiIntero("Insert duration time: Seconds");
		return new PlayTime(minutes, seconds);
	}
	
	public static Track askTrack() {
		String name;
		name = InputDati.leggiStringa("Insert Track name:");
		return new Track(IOStream.askPlayTime(), name);
	}
	
	public static ArrayList<Track> askTracklist() {
		ArrayList<Track> tracks = new ArrayList<>();
		int trackNumber;
		trackNumber = InputDati.leggiIntero("How many tracks does this tracklist have?");
		for(int i=0; i<trackNumber; i++) {
			tracks.add(IOStream.askTrack());
		}
		return tracks;
	}
	
	public static String askAlbumTitle() {
		return InputDati.leggiStringa("Insert album name:");
	}
	
	/*
	 * it asks the rest of the info of the album given the title
	 * @return a new Album given the info
	 */
	
	public static Album askAlbum(String albumTitle) {
		String author;
		author = InputDati.leggiStringa("Insert author name:");
		return new Album (IOStream.askTracklist(), albumTitle,author);
	}
	
	public static int askPlaylistLenght() {
		return InputDati.leggiIntero("How many tracks would you like to hear?");
	}
	
	public static int searchMenuOption() {
		MyMenu searchMenu = new MyMenu(IOStream.SEARCH_MENU_TITLE, IOStream.SEARCH_OPERATORS);
		return searchMenu.scegli();
	}
	
	public static int confirmationMenuOption()  {
		MyMenu confirmationMenu = new MyMenu(IOStream.CONFIRMATION_MENU_TITLE, IOStream.CONFIRMATION_OPTIONS);
		return confirmationMenu.scegli();
	}
	
}
