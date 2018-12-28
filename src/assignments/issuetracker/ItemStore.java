package assignments.issuetracker;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import assignments.issuetracker.model.Bug;
import assignments.issuetracker.model.Task;
import assignments.issuetracker.model.UseCase;
import assignments.issuetracker.model.UserStory;

public final class ItemStore {
	
	private Map<Integer,Bug> bugs = new HashMap<>();
	private Map<Integer,Task> tasks = new HashMap<>();
	private Map<Integer,UserStory> userStories = new HashMap<>(); //need to store user stories by id as there's a need to print all user stories belonging to a use case, which stores user story ids.
	private Map<Integer,UseCase> useCases = new HashMap<>();//need to print use cases by id

	public void addItem(Bug bug) {
		bugs.put(bug.getId(),bug);
	}

	public void addItem(Task task) {
		tasks.put(task.getId(),task);
	}
	
	public void addItem(UserStory us) {
		userStories.put(us.getId(),us);
	}
	
	public void addItem(UseCase uc) {
		useCases.put(uc.getId(), uc);
	}
	
	public UseCase getUseCaseById(int id) {
		return useCases.get(id);
	}
	
	public UserStory getUserStoryById(int id) {
		return userStories.get(id);
	}
	
	public void performOnBugs(Consumer<Bug> consumer) {
		for (Bug bug : bugs.values()) {
			consumer.accept(bug);
		}
	}
	
	public void performOnTasks(Consumer<Task> consumer) {
		for (Task task : tasks.values()) {
			consumer.accept(task);
		}
	}
} 
