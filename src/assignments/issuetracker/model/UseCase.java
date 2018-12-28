package assignments.issuetracker.model;

import java.util.HashSet;
import java.util.Set;

import assignments.issuetracker.InputProvider;

/**
 * UseCase class.
 */
public class UseCase extends Item {
	private final static int MAX_NUM_OF_STORIES = 10;
	private Set<Integer> userStories = new HashSet<>(MAX_NUM_OF_STORIES);
	
	private UseCase(Builder builder) {
		super(builder);
	}


	public boolean addUserStory(int userStoryId) {
		if(userStories.size() == MAX_NUM_OF_STORIES) {			
			return false;
		}
		
		userStories.add(userStoryId);
		
		return true;
	}
	
	
	
	public static class Builder extends Item.Builder<UseCase>{

		@Override
		protected void additionalValues(InputProvider inputProvider) {
		}

		@Override
		public UseCase build(InputProvider inputProvider) {
			initValues(inputProvider);
			return new UseCase(this);
		}
		
	}
}
