
import java.util.Scanner;

/**
 * The {@code Menu} class provides a simple command-line interface
 * for interacting with a {@code Schedule} of {@code Doable} tasks.
 * <p>
 * It allows users to:
 * <ul>
 * <li>Add new tasks</li>
 * <li>Delete existing tasks</li>
 * <li>Mark tasks as done</li>
 * <li>View the full task list</li>
 * </ul>
 */
public class Menu {
	/**
	 * The available options shown in the main menu.
	 */
	public final String options = """
			Options:
			1.- Add task
			2.- Delete task
			3.- Mark task as done
			4.- Exit
			""";
	/**
	 * The Schedule of the current date
	 */
	private Schedule currentSchedule;

	/**
	 * a Scanner for user input
	 */
	private Scanner input;

	/**
	 * Constructs a new {@code Menu} instance with an empty {@code Schedule}
	 * and initializes input handling via {@code Scanner}.
	 */
	public Menu() {
		this.currentSchedule = new Schedule();
		this.input = new Scanner(System.in);
	}

	/**
	 * Displays a welcome banner and initializes the main menu loop.
	 */
	public void Welcome() {
		System.out.println(Art.logo());
		System.out.println("""
				**************************
				*WELCOME TO TASKABLE BETA*
				**************************
								""");
		System.out.println("Current schedule created");
		this.mainMenu();
	}

	/**
	 * Main loop that repeatedly shows the available options
	 * and executes the selected action based on user input.
	 */
	private void mainMenu() {
		boolean choosingOption = true;
		while (choosingOption) {
			int chosenOption = -1;
			System.out.println(options);
			this.showSchedule();

			System.out.print("Choose an option: ");

			chosenOption = getANumberLoop();

			switch (chosenOption) {
				case 1:
					addTaskMenu();
					break;
				case 2:
					deletingTaskMenu();
					break;
				case 3:
					markTaskAsDoneMenu();
					break;
				case 4:
					System.out.println("Goodbye");
					System.exit(1);
				default:
					System.out.println("There is no option number " + chosenOption);
					break;
			}
		}
	}

	/**
	 * Prompts the user to enter a task description and adds it to the schedule.
	 */
	private void addTaskMenu() {
		//TODO add an option to cancel the operation
		System.out.print("Add a task description: ");
		String taskDescription = input.nextLine();
		this.addTask(taskDescription);
	}

	/**
	 * Prompts the user to enter the index of a task to delete.
	 * Repeats until a valid input is provided.
	 */
	private void deletingTaskMenu() {
		//TODO add an option to cancel the operation
		boolean deletingATask = true;
		while (deletingATask) {
			System.out.print("Type the task number: ");
			int taskIndex = getANumberLoop();
			try {
				deleteTask(taskIndex);
				deletingATask = false;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Try again");
			}
		}
	}

	/**
	 * Prompts the user to select a task to mark as done.
	 * Displays appropriate messages for invalid inputs.
	 */
	private void markTaskAsDoneMenu() {
		//TODO add an option to cancel the operation
		boolean changingTaskStatus = true;
		int taskIndex = -1;
		while (changingTaskStatus) {
			System.out.print("Type the number of the task you want to mark as done: ");
			taskIndex = getANumberLoop();
			if (this.currentSchedule.getDoables().isEmpty()) {
				System.out.println("The task list is empty");
				System.out.println("Returning to the main menu");
				break;
			}
			try {
				markDoneTask(taskIndex);
				System.out.println("Task marked");
				changingTaskStatus = false;
			} catch (Exception e) {
				System.out.println("There is no task number " + taskIndex);
				System.out.println("Try again");
			}
		}
	}

	/**
	 * Reads a valid integer input from the user.
	 * If the input is not a number, it repeats the prompt.
	 *
	 * @return a valid integer entered by the user
	 */
	private int getANumberLoop() {
		boolean getANumber = true;
		int numberGot = -1;
		while (getANumber) {
			try {
				numberGot = this.input.nextInt();
				getANumber = false;
			} catch (Exception e) {
				System.out.println("The characters typed do not form a number");
				System.out.println("Try again");
			}
			this.input.nextLine(); // clear buffer
		}
		return numberGot;
	}

	/**
	 * Adds a new task with the given description to the current schedule.
	 *
	 * @param taskDescription the description of the task to add
	 */
	private void addTask(String taskDescription) {
		this.currentSchedule.addTask(taskDescription);
		System.out.println("Task added");
	}

	/**
	 * Deletes the task at the given index (1-based) from the schedule.
	 *
	 * @param taskIndex the 1-based index of the task to delete
	 */
	private void deleteTask(int taskIndex) {
		this.currentSchedule.deleteTask(taskIndex - 1);
		System.out.println("Task removed");
	}

	/**
	 * Marks the task at the given index (1-based) as {@code done}.
	 *
	 * @param taskIndex the 1-based index of the task to mark
	 */
	private void markDoneTask(int taskIndex) {
		this.currentSchedule.changeTaskStatus(taskIndex - 1, Doable.Status.done);
		System.out.println("Task marked as done");
	}

	/**
	 * Displays the current schedule and all tasks.
	 */
	private void showSchedule() {
		System.out.println(this.currentSchedule.toString());
	}
}
