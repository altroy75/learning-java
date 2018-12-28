package assignments.issuetracker.model;

import java.time.LocalDate;

import assignments.issuetracker.InputProvider;

/**
 * Task class.
 */
public class Task extends Item {
	protected LocalDate dueDate;

	private Task(Builder builder) {
		super(builder);
		dueDate = builder.dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getDueDate() {
		return this.dueDate;
	}
	
	
	public static class Builder extends Item.Builder<Task>{

		LocalDate dueDate;

		@Override
		protected void additionalValues(InputProvider inputProvider) {
			dueDate = inputProvider.getDateValue("due date", "");
		}

		@Override
		public Task build(InputProvider inputProvider) {
			initValues(inputProvider);
			return new Task(this);
		}
		
	}
}
