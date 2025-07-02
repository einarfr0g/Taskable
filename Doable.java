/**
 * A {@code Doable} object represents a task that can be marked as done.
 * It has only a {@code String} {@code description} representing the task to do,
 * and a variable of type {@code Status} {@code status} that represents
 * the current state of the task.
 * note: it will later be converted to a interface.
 */
public class Doable {
	/**
	 * The {@code Status} enumeration represents the status of a task:
	 * <ul>
	 * <li>{@code todo}: the task is yet to be done</li>
	 * <li>{@code done}: the task has been completed</li>
	 * <li>{@code notDone}: the task has failed or was not completed</li>
	 * </ul>
	 */
	enum Status {
		todo, done, notDone
	}

	/**
	 * the {@code description} field of type String that represents the task to be
	 * done.
	 */
	private String description;
	/**
	 * The {@code status} field is an instance of the {@code Status} enumeration,
	 * representing the current status of the task.
	 */
	private Status status;

	/**
	 * Constructs a new {@code Doable} object with the given task description.
	 * Initializes the {@code status} field to {@code Status.todo}.
	 * <p>
	 * This constructor does not accept {@code null} as a valid description.
	 *
	 * @param description a non-null {@code String} describing the task
	 * @throws NullPointerException if {@code description} is {@code null}
	 */
	public Doable(String description) {
		// TODO throw NullPointerExceptiont if description parameter is null
		this.description = description;
		this.status = Status.todo;
	}

	/**
	 * Sets the task description.
	 * <p>
	 * This method does not check for {@code null}, so it's recommended
	 * to ensure the input is valid before calling it.
	 *
	 * @param description the new task description
	 */
	public void setDescription(String description) {
		// TODO throw NullPointerExceptiont if description is null
		this.description = description;
	}

	/**
	 * Sets the status of the task.
	 *
	 * @param status the new status to assign to the task
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Returns the current task description.
	 *
	 * @return the task description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the current status of the task.
	 *
	 * @return the task status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Returns a string representation of the task.
	 * The format includes a symbol based on the status followed by the description:
	 * <ul>
	 * <li>{@code ☑} for {@code done}</li>
	 * <li>{@code ☒} for {@code notDone}</li>
	 * <li>{@code ☐} for {@code todo}</li>
	 * </ul>
	 *
	 * @return a formatted string representing the task
	 */
	@Override
	public String toString() {
		String statusSing = switch (this.status) {
			case todo -> "☐";
			case done -> "☑";
			case notDone -> "☒";
		};

		return statusSing + " " + this.description;
	}

}
