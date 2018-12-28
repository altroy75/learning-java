package assignments.issuetracker.model;

import java.time.LocalDate;

import assignments.issuetracker.InputProvider;

/**
 * Item (WIT) class.
 */
public class Item {
	
	private int id;	
	private String description = "N/A";
	private int priority = 1;		// 1 - 10
	private final LocalDate creationDate = LocalDate.now();
	private State currentState = State.TODO;
	
	
	protected Item(Builder<? extends Item> builder) {
		this.id = builder.id;
		this.description = builder.description;
		this.priority = builder.priority;
	}


	public String getDescription() {
		return description;
	}


	public int getPriority() {
		return priority;
	}


	public State getState() {
		return currentState;
	}


	public boolean setState(State state) {
		if(currentState.canTransition(state)) {
			currentState = state;
			return true;
		}
		
		return false;
	}


	public int getId() {
		return id;
	}


	public LocalDate getCreationDate() {
		return creationDate;
	}

	
	protected static abstract class Builder<T extends Item>{
		
		private static int nextAvailableId = 1;
		
		int id; 
		String description;
		int priority;	

		protected void initValues(InputProvider inputProvider) {
			id = nextAvailableId++;
			description = inputProvider.getStringValue("description","");
			priority = inputProvider.getIntValue("priority","Valid values: 1-10");
			while(priority > 10 || priority < 1) {
				priority = inputProvider.getIntValue("priority","Valid values: 1-10");
			}
			
			additionalValues(inputProvider);
		}
		
		protected abstract void additionalValues(InputProvider inputProvider);
		
		public abstract T build(InputProvider inputProvider);
		
	}
	

}
