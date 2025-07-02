
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The {@code Schedule} class represents a collection of {@code Doable} tasks
 * associated with a specific date. It allows for adding, removing, updating,
 * and listing tasks for a given day.
 */
public class Schedule {
	private LocalDate date;
	private ArrayList<Doable> doables;

	/**
	 * Constructs a new {@code Schedule} with the current date
	 * and an empty list of tasks.
	 */
	public Schedule() {
		this.date = LocalDate.now();
		this.doables = new ArrayList<Doable>();
	}

	/**
	 * Adds a new task with the given description to the schedule.
	 *
	 * @param taskDescription a {@code String} representing the task to be added
	 */
	public void addTask(String taskDescription) {
		Doable newTask = new Doable(taskDescription);
		doables.add(newTask);
	}

	/**
	 * Changes the status of a task at the specified index.
	 *
	 * @param taskIndex the index of the task in the list
	 * @param status    the new status to assign to the task
	 * @throws IllegalArgumentException if the task list is empty or the index is invalid
	 */
	public void changeTaskStatus(int taskIndex, Doable.Status status) {
		if (this.doables.isEmpty())
			throw new IllegalArgumentException("Your task list is empty.");

		if (taskIndex < 0 || taskIndex >= this.doables.size())
			throw new IllegalArgumentException("The task number " + taskIndex + " does not exist.");

		Doable selectedTask = this.doables.get(taskIndex);
		selectedTask.setStatus(status);
	}

	/**
	 * Deletes the task at the specified index from the schedule.
	 *
	 * @param taskIndex the index of the task to be removed
	 * @throws IllegalArgumentException if the task list is empty or the index is invalid
	 */
	public void deleteTask(int taskIndex) throws IllegalArgumentException {
		if (this.doables.isEmpty())
			throw new IllegalArgumentException("Your task list is empty.");

		if (taskIndex < 0 || taskIndex >= this.doables.size())
			throw new IllegalArgumentException("The task number " + taskIndex + " does not exist.");

		this.doables.remove(taskIndex);
	}

	/**
	 * Sets the date associated with this schedule.
	 *
	 * @param date a {@code LocalDate} representing the schedule's date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Replaces the list of tasks with a new one.
	 *
	 * @param doables a list of {@code Doable} tasks
	 */
	public void setDoables(ArrayList<Doable> doables) {
		this.doables = doables;
	}

	/**
	 * Returns the date associated with this schedule.
	 *
	 * @return a {@code LocalDate} representing the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Returns the list of tasks in this schedule.
	 *
	 * @return an {@code ArrayList} of {@code Doable} objects
	 */
	public ArrayList<Doable> getDoables() {
		return doables;
	}

	/**
	 * Returns a string representation of the schedule, including the date and
	 * a numbered list of tasks. If there are no tasks, a message is shown instead.
	 *
	 * @return a formatted string listing all tasks and the schedule's date
	 */
	@Override
	public String toString() {
		String toString = "";
		toString += "Date: " + this.date.toString() + "\n\n";
		int i = 1;
		for (Doable task : doables) {
			toString += i + " " + task.toString() + "\n";
			i++;
		}
		if (this.doables.isEmpty())
			toString += "No task added yet";

		return toString;
	}
}

