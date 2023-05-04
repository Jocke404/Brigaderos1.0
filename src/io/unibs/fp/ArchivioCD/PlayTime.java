package io.unibs.fp.ArchivioCD;

public class PlayTime {

	private int minutes;
	private int seconds;
	
	public PlayTime(int _minutes, int _seconds) {
		this.minutes = _minutes;
		this.seconds = _seconds;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Duration: ");
		str.append(this.minutes);
		str.append(":");
		str.append(this.seconds);
		return str.toString();
	}
	
	
}
