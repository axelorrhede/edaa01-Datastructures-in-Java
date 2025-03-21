package lpt;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private Machine[] machines;
	/** Skapar en schemaläggare för maskinerna 
		i vektorn machines. */
	
	public Scheduler(Machine[] machineArray) {
		machines = machineArray; //Helvete va det tog tid
	}
	
	/** Returnerar den maskin som har minst att göra. */
	private Machine machineWithLeastToDo() {
		int min = Integer.MAX_VALUE;
		int minPos = -1;
		for (int i = 0; i < machines.length; i++) {
			int totalTime = machines[i].getScheduledTime();
			if (totalTime < min) {
				min = totalTime;
				minPos = i;
			}
		}
		return machines[minPos];
	}
	
	/** Fördelar jobben i listan jobs på maskinerna. */
	public void makeSchedule(List<Job> jobs) {
		List<Job> tempJobList = new ArrayList<>(jobs); // WTF??
		tempJobList.sort((j1, j2) -> j1.getTime() - j2.getTime());  //WTF?? Här är felet men jag vet inte hur man skriver dessa, så jag ändrade bara for-loopen nedan
		for (int i = tempJobList.size()-1; i >= 0; i--) {
			Machine m = machineWithLeastToDo();	 
			m.assignJob(tempJobList.get(i));
		}	
	}
	
	/** Tar bort alla jobb från maskinerna. */
	public void clearSchedule() {
		for(int i = 0; i < machines.length; i++) {
			machines[i].clearJobs();
		}	
	}

	/** Skriver ut maskinernas scheman. */
	public void printSchedule() {
		for (int i = 0; i < machines.length; i++) {
			System.out.println(machines[i]);
		}
	}
}
