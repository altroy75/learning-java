package assignments.issuetracker.model;

import assignments.issuetracker.InputProvider;

/**
 * UserStory class.
 */
public class UserStory extends Item {
	private String sprintName;

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getSprintName() {
		return this.sprintName;
	}
	
	
	private UserStory(Builder builder) {
		super(builder);
		sprintName = builder.sprintName;
	}

	
	
	public static class Builder extends Item.Builder<UserStory>{

		String sprintName;

		@Override
		protected void additionalValues(InputProvider inputProvider) {
			sprintName = inputProvider.getStringValue("sprint name", "");
		}

		@Override
		public UserStory build(InputProvider inputProvider) {
			initValues(inputProvider);
			return new UserStory(this);
		}
		
	}
}
