package practice;
import java.util.HashMap;
import java.util.Stack;

public class BussiesRoom {
	/*
	 * numRooms: 3 = K
		Appointment times:     [1, 3, 5, 8, 19] => patients arrival time
		Appointment durations: [20, 3, 2, 9, 1] => time spent by a patient in a given room
		**expected output**
		room 1 = 21
		room 2 = 6,17
		room 3 = 7, 20
	 */
	public static void main(String[] args) {
		int[] times = new int[] {1, 3, 5, 8, 19};
		int[] durations = new int[] {20, 3, 2, 9, 1};
		int rooms = 3;
		HashMap<Integer, Stack<Integer>> schedule = new HashMap<>();
		for (int i = 0; i < times.length; i++) {
			int end = times[i] +durations[i];
			int currentBestRoom = 0;
			boolean addNew = false;
			int bestTime = 0;
			if(!schedule.isEmpty())
				bestTime = schedule.get(0).peek();				
			for (int j = 0; j < rooms; j++) {
				if(schedule.containsKey(j)){
					int duration = schedule.get(j).peek();
					if(duration<end && bestTime >= duration ) {
						bestTime = duration;
						currentBestRoom = j;
					}
				}else {
					Stack<Integer> arrSchdl = new Stack<>();
					arrSchdl.push(end);
					schedule.put(j, arrSchdl );
					addNew = true;
					break;
				}
			}
			if(!addNew)
				schedule.get(currentBestRoom).push(end);
		}
		System.out.println(schedule);
	}
	
}
