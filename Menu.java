import java.util.Scanner;

public class Menu {
	public final String options = """
			Options:
			1.- Add task
			2.- Delete task
			3.- Mark task as done
			4.- Exit
			""";

	private boolean exit;
	private Schedule currentSchedule;
	private Scanner input;

	public Menu() {
		this.exit = false;
		this.currentSchedule = new Schedule();
		this.input = new Scanner(System.in);
	}

	public void Welcome() {
		System.out.println(Art.logo());
		System.out.println("""
				**************************
				*WELCOME TO TASKABLE BETA*
				**************************
								""");
		System.out.println("current schedule created");
		this.mainMenu();
	}

	private void mainMenu() {
		boolean chosingOption = true;
		while (chosingOption) {
			int choosedOption = -1;
			System.out.println(options);
			this.showSchedule();

			System.out.print("Chose an option: ");

			choosedOption = getANumberLoop();

			switch (choosedOption) {
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
					System.out.println("there is no option number " + Integer.toString(choosedOption));
					break;
			}
		}
	}

	private void addTaskMenu() {
		System.out.print("Add a task description :");
		String taskDescription = input.nextLine();
		this.addTask(taskDescription);
	}

	private void deletingTaskMenu() {
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

	private void markTaskAsDoneMenu() {
		boolean changingTaskStatus = true;
		int taskIndex = -1;
		while (changingTaskStatus) {
			System.out.print("type the number of the task you want to mark as done: ");
			taskIndex = getANumberLoop();
			if (this.currentSchedule.getDoables().isEmpty()){
				System.out.print("The task list is empty");
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

	private int getANumberLoop() {
		boolean getANumber = true;
		int NumberGot = -1;
		while (getANumber) {
			try {
				NumberGot = this.input.nextInt();
				getANumber = false;
			} catch (Exception e) {
				System.out.println("The characters typed do not form a number");
				System.out.println("Try again");
			}
			this.input.nextLine();

		}
		return NumberGot;
	}

	private void addTask(String taskDesription) {
		this.currentSchedule.addTask(taskDesription);
		System.out.println("Task added");
	}

	private void deleteTask(int taskIndex) {
		this.currentSchedule.deleteTask(taskIndex - 1);
		System.out.println("task removed");
	}

	private void markDoneTask(int taskIndex) {
		this.currentSchedule.changeTaskStatus(taskIndex - 1, Doable.Status.done);
		System.out.println("task marked as done");
	}

	private void showSchedule() {
		System.out.println(this.currentSchedule.toString());
	}

}
