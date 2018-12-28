package assignments.issuetracker;

import assignments.issuetracker.model.Bug;
import assignments.issuetracker.model.State;
import assignments.issuetracker.model.Task;
import assignments.issuetracker.model.UseCase;
import assignments.issuetracker.model.UserStory;

/**
 * IssueTracker class.
 */
public class IssueTracker {
	
	private ItemStore itemStore = new ItemStore();
	private InputProvider inputProvider = new ConsoleInputProvider();
	
	public static void main(String[] args) {
		
		IssueTracker issueTracker = new IssueTracker();
		issueTracker.mainMenu();
	}
		
		
	private void mainMenu() {	

		int mainMenuItem;
		
		fromWhile: 
		while (true) {
			printMainMenu();
			mainMenuItem = inputProvider.getIntValue();
			
			switch(mainMenuItem) {
			case 1:
				// Create new item.
				handleCreateItem();
				break;
			case 2:
				// Set item state.
				break;
			case 3:
				// Close all bugs.
				itemStore.performOnBugs((bug) -> bug.setState(State.DONE));
				break;
			case 4:
				// Close all tasks.
				itemStore.performOnTasks((task) -> task.setState(State.DONE));
				break;
			case 5:
				// Link user story to use case.
				break;
			case 6:
				// Set new due date.
				break;
			case 7:
				// Print use case.
				break;
			case 8:
				// Set bug severity.
				break;
			case 9:
				// Change sprint.
				break;
			case 10:
				//Exit
				System.out.println("Exiting...");
				break fromWhile;
		    default:
				break;
				
			}
		}
	}

	private void handleCreateItem() {
		String type = inputProvider.getStringValue("Please choose work item type. B for bug, T for task, US for user story and UC for use case:");
		switch (type) {
		case "B":
			itemStore.addItem(new Bug.Builder().build(new ConsoleInputProvider()));
			break;
		case "T":
			itemStore.addItem(new Task.Builder().build(new ConsoleInputProvider()));
			break;
		case "US":
			itemStore.addItem(new UserStory.Builder().build(new ConsoleInputProvider()));
			break;
		case "UC":
			itemStore.addItem(new UseCase.Builder().build(new ConsoleInputProvider()));
			break;
		default:
			System.out.println("Wrong item type!");
			break;
		}
	}

	public static void printMainMenu() {
		System.out.println("[1] Create new item.");
		System.out.println("[2] Set item state.");
		System.out.println("[3] Close all bugs.");
		System.out.println("[4] Close all tasks.");
		System.out.println("[5] Link user story to use case.");
		System.out.println("[6] Set new due date.");
		System.out.println("[7] Print use case.");
		System.out.println("[8] Set bug severity.");
		System.out.println("[9] Change sprint.");
		System.out.println("[10] Exit.");
		System.out.print("> ");
	}
}
