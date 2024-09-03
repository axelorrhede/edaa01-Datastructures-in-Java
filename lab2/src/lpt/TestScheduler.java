package lpt;

import java.util.ArrayList;

public class TestScheduler {

	public static void main(String[] args) {
		Machine[] m = new Machine[3];
		for (int i = 0; i < m.length; i++) {
			m[i] = new Machine(i + 1);
		}
		
		ArrayList<Job> jobList = new ArrayList<Job>();
		String [] names = {"j1", "j2", "j3", "j4", "j5", "j6", "j7"};
		int[] times = {2, 14, 4, 16, 6, 5, 3};
		for (int i = 0; i < names.length; i++) {
			jobList.add(new Job(names[i], times[i]));
		}
		
		Scheduler s = new Scheduler(m);
		s.makeSchedule(jobList);
		s.printSchedule();
	}

}
/*fel 1:
 * NullPointerException är exekveringsfelet, den kan inte läsa arrayen this.machines eftersom den är null
 * Metoderna som kördes samtidigt var: main, makeSchedule, machineWithLeastToDo, asså 3 st
 * rad 12 i scheduler i konstruktorn, vi deklarerar en ny machines i konstruktorn, istället för att använda den som deklareats för hela klassen
 * 
 * 
 * Fel 2 ArrayIndexOutOfBoundsException, index 3 är för långt för vektorn
 * i printschedule, metoden main körs samtidigt, löses genom att ta bort likamedtecknet
 * rad 48 i metoden printschedule i scheduler
 * 
 * För att inte använda metoden machineWithLeastToDo kan man skapa en lista sorterad efter vilken maskin som har minst att göra
 * 
 * Om vi har Arraylist skrivs 20 st rader ut med talen 0-90 två gånger i ordning
 * 
 * Om vi har hashSet skrivs 10 stycken rader ut med talen 0-90 en gång i oordning
 * 
 * Key - String
 * Value - Integer
 * 7 put ersätter förra nyckeln om det redan finns
 * containsKey()
 */
