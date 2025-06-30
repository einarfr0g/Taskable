import java.time.LocalDate;
import java.util.ArrayList;

public class Schedule {
	private LocalDate date;
	private ArrayList<Doable> doables;

	public Schedule() {
		this.date = LocalDate.now();
		this.doables = new ArrayList<Doable>();
	}

	public void addTask(String taskDescription) {
		Doable newTask = new Doable(taskDescription);
		doables.add(newTask);
	}

	public void changeTaskStatus(int taskIndex,Doable.Status status){
		if (this.doables.isEmpty())
			throw new IllegalArgumentException("your Task list is empty");

		if (taskIndex < 0 || taskIndex >= this.doables.size())
			throw new IllegalArgumentException("The Task numeber " + Integer.toString(taskIndex) + " does not exist");

		Doable selectedTask = this.doables.get(taskIndex);
		selectedTask.setStatus(status);
	}

	public void deleteTask(int taskIndex) throws IllegalArgumentException {
		if (this.doables.isEmpty())
			throw new IllegalArgumentException("your Task list is empty");

		if (taskIndex < 0 || taskIndex >= this.doables.size())
			throw new IllegalArgumentException("The Task numeber " + Integer.toString(taskIndex) + " does not exist");

		this.doables.remove(taskIndex);
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDoables(ArrayList<Doable> doables) {
		this.doables = doables;
	}

	public LocalDate getDate() {
		return date;
	}

	public ArrayList<Doable> getDoables() {
		return doables;
	}

	@Override
	public String toString() {
		String toString = "";
		toString += "Date: " + this.date.toString() + "\n" + "\n";
		int i = 1;
		for (Doable task : doables) {
			toString += Integer.toString(i) + " " + task.toString() + "\n";
			i++;
		}
		if( this.doables.isEmpty())
			toString += "No task added yet";

		return toString;

	}

}
