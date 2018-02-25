package FilmStudio;
import java.util.Scanner;

import manager.StudioManager;
import model.enums.FilmGenre;
import FilmStudio.Worker;


public class Main {
	
	public static void main (String[] args) {
		
		
		Actor actor = new Actor ("Neil", "Armstrong","Actor","Ryan" ,"Gosling", 37, 9500,FilmGenre.ComedyFilms,20);
		Cameraman cameraman = new Cameraman (25,"Cameraman","Robert" ,"Elswit", 57, 12000,FilmGenre.DocumentaryFilms,39);
		Producer producer = new Producer (25000000.50,"Producer","Lauren" ,"Greenfield", 63, 20500,FilmGenre.DocumentaryFilms,40);
		Director director = new Director ("First Man","Director","Michael" ,"Bay", 53, 50000,FilmGenre.AdventureFilms,27);
		
		StudioManager manager = new StudioManager();
		manager.addWorker (actor);
		manager.addWorker (cameraman);
		manager.addWorker (producer);
		manager.addWorker (director);
		
		boolean menu = true;
		while (menu) {
			System.out.println("Menu:");
    		System.out.println("1 - Print list of Workers");
    		System.out.println("2 - Find by genre");
    		System.out.println("3 - Print list Salary sorted by hourly rate ");
    		System.out.println("4 - Exit");
    		
    		Scanner scan = new Scanner (System.in);
    		int num = scan.nextInt();

    		switch (num) {
			case 1: {
				manager.print();
				break;
			}
			case 2: {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the genre to find: ");
				String genreToFind = scanner.nextLine();
				System.out.println(manager.findWorkersByGenres(genreToFind).toString());
				break;
			}
			case 3: {
				System.out.println(manager.sortBySalaryPerHour().toString());
				break;
			}
			case 4: default: {
				menu = false;
				System.out.println("Exit program...");
				break;
			}
		}
		

	}
	}

}
		
	


