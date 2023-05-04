package io.unibs.fp.ArchivioCD;

import java.util.ArrayList;
import java.util.Random;

public class Archivio {

	private ArrayList<Album> albumlist;
	
	public Archivio () {
		this.albumlist = new ArrayList<>();
	}

	public ArrayList<Album> getAlbumlist() {
		return albumlist;
	}
	
	public void addAlbum() {
		String newAlbumName = IOStream.askAlbumTitle();
		int check = this.albumIndexFinder(newAlbumName, IOStream.SEARCH_BY_ALBUM); 
		if (check == this.albumlist.size()) { //given the title it checks if it's already registered before asking further indications
			this.albumlist.add(IOStream.askAlbum(newAlbumName));
		}
		else {
			System.out.println(IOStream.ALREDY_ADDED);
		}
	}
	
	public void removeAlbum() {
		if (albumlist.isEmpty()) {
			System.out.println(IOStream.EMPTY_ARCHIVE);
		}
		else {
			String title = IOStream.askTitle();
			int index = this.albumIndexFinder(title, IOStream.SEARCH_BY_ALBUM);
			if (index<albumlist.size()) 
				if (IOStream.confirmationMenuOption() == IOStream.CONFIRM_OPTION) albumlist.remove(index);
			else System.out.println(IOStream.NOT_FOUND);
		}
	}
	
	public void searchAlbum() {
		if (albumlist.isEmpty()) {
			System.out.println(IOStream.EMPTY_ARCHIVE);
		}
		else {
			int searchingOption = IOStream.searchMenuOption();
			int searchingElement = this.albumIndexFinder(IOStream.askTitle(), searchingOption);
			if (searchingElement < this.albumlist.size()) System.out.println(this.albumlist.get(searchingElement).toString());
			else System.out.println(IOStream.NOT_FOUND);
		}
	}
	
	public void showCollection() {
		if (albumlist.isEmpty()) {
			System.out.println(IOStream.EMPTY_ARCHIVE);
		}
		else {
			for (int i = 0; i<albumlist.size(); i++) {
				System.out.println(albumlist.get(i).toString());
				System.out.println("\n");
			}
		}
	}
	
	public void playRandomAlbum() {
		if (albumlist.isEmpty()) {
			System.out.println(IOStream.EMPTY_ARCHIVE);
		}
		else {
			Random ran = new Random();
			int AlbumIndex = ran.nextInt(albumlist.size());
			albumlist.get(AlbumIndex).playRandomTrack();
		}
	}
	
	/*
	 * This function search for an album position given the name of the album, the author or the title of a track.
	 * the constant used for choosing the type of search are in the IOStream class
	 * @return the index of the album by giving the album name, if the index is equal to the list it means that the album hasn't been found;
	 */
	
	private int albumIndexFinder (String searchName, int typeOfSearchParameter) {
		for (int i=0; i<this.albumlist.size(); i++) {
			switch (typeOfSearchParameter) {
			case(IOStream.SEARCH_BY_ALBUM):
				if (this.albumlist.get(i).getAlbumName().equalsIgnoreCase(searchName)) return i;
				break;
			case (IOStream.SEARCH_BY_AUTHOR):
				if (this.albumlist.get(i).getAuthor().equalsIgnoreCase(searchName)) return i;
			break;
			case (IOStream.SEARCH_BY_TRACK):
				if(this.albumlist.get(i).trackIndexFinder(searchName) < this.albumlist.get(i).getTrackList().size()) return i; //for each album starts the search method and checks if it's present
			}
		}
		return this.albumlist.size();
	}
}
