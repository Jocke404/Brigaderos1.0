package io.unibs.fp.ArchivioCD;

import java.util.ArrayList;
import java.util.Random;

public class Album {
	
	private ArrayList<Track> trackList;
	private String albumName;
	private String author;
	
	public Album(ArrayList<Track> _trackList, String _albumName, String _author) {
		this.trackList = _trackList;
		this.albumName = _albumName;
		this.author = _author;
	}

	public ArrayList<Track> getTrackList() {
		return trackList;
	}

	public String getAlbumName() {
		return albumName;
	}

	public String getAuthor() {
		return author;
	}
	
	public void addTrack() {
		this.trackList.add(IOStream.askTrack());
	}
	
	public void playRandomTrack() {
		Random ran = new Random();
		int trackIndex = ran.nextInt(this.trackList.size()); 
		System.out.println(this.trackList.get(trackIndex).toString());
	}
	
	/*
	 * works the same as album finder, giving the position for positive result and the length for negative one
	 */
	
	public int trackIndexFinder(String trackName) {
		for (int i = 0;i<this.trackList.size(); i++) {
			if (this.trackList.get(i).getName().equalsIgnoreCase(trackName)) return i;
		}
		return this.trackList.size();
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Album name: ");
		str.append(this.albumName);
		str.append("\nAuthor: ");
		str.append(this.author);
		str.append("\nTracklist: ");
		for (int i=0; i<trackList.size(); i++) {
			str.append(trackList.get(i).toString());
		}
		return str.toString();
	}

}
