package io.unibs.fp.ArchivioCD;

public class Track {

	private PlayTime duration;
	private String name;
	
	public Track(PlayTime _duration, String _name) {
		super();
		this.duration = _duration;
		this.name = _name;
	}

	public PlayTime getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\nTrack name: ");
		str.append(name);
		str.append("\nPlay time: ");
		str.append(duration.toString());
		return str.toString();
	}
	
}
