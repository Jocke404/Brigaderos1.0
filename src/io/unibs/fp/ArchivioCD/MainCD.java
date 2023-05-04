package io.unibs.fp.ArchivioCD;

import it.unibs.fp.mylib.MyMenu;

public class MainCD {

	public static void main(String[] args) {
		
		String[] actions = {"Register new album", "Remove old album", "Search album", "Show collection", "Play ranodm song", "Play random playlist"};
		String title = "Welcome to your CD collection";
		int choose;
		Archivio archive1 = new Archivio();
		MyMenu m1 = new MyMenu (title,actions);
		do {
			choose = m1.scegli();
			switch (choose) {
			case 1:
				archive1.addAlbum();
				break;
			case 2:
				archive1.removeAlbum();
				break;
			case 3:
				archive1.searchAlbum();
				break;
			case 4:
				archive1.showCollection();
				break;
			case 5:
				archive1.playRandomAlbum();
				break;
			default:
			case 6:
				int lenght = IOStream.askPlaylistLenght();
				for (int i=0; i<lenght; i++) archive1.playRandomAlbum();
				break;
			}
		} while (choose!=0);
	}
}
