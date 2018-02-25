package manager;

import java.util.LinkedList;
import java.util.List;

import FilmStudio.Worker;
import model.enums.FilmGenre;

public class StudioManager {
	public  List <Worker> availableWorkers = new LinkedList <Worker>();
	
	public void print ()
	{
		
			for (Worker worker : availableWorkers) {
				System.out.println(worker);
			}
		}
	public StudioManager () {}
	
	public void addWorker (Worker addWorker) {
		availableWorkers.add(addWorker);
	}
	public List<Worker> getWorkerGenres() {
				return availableWorkers;
			}
			public void setAvailableWorkers(List<Worker> availableWorkers) {
				this.availableWorkers = availableWorkers;
			}
	
			public  List<Worker> findWorkersByGenres (String workerToFind) 
			{
				List<Worker> workerList = new LinkedList<Worker>();
				
				for (Worker worker : availableWorkers) {
					if(workerToFind.equals (worker.getGenre().name())) {
						workerList.add(worker);
					}
				}
				return workerList;
			}
			
			
			public List<Worker> sortBySalaryPerHour () {
				  availableWorkers.sort((Worker o1, Worker o2)->o1.getSalaryPerHour()-o2.getSalaryPerHour());
				  return availableWorkers;
			} 
			public StudioManager (LinkedList <Worker> availableWorkers) {
				this.availableWorkers = availableWorkers; 
			}
		}