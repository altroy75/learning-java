package assignments.issuetracker.model;

public enum State {
	
	TODO{

		@Override
		public boolean canTransition(State nextState) {
			return nextState != DONE;
		}
		
	},
	INPROGRESS{

		@Override
		public boolean canTransition(State nextState) {
			return nextState != TODO;
		}

		@Override
		public boolean askForValidState() {
			return false;
		}
		
	},
	
	DONE{

		@Override
		public boolean canTransition(State nextState) {
			return nextState != TODO;
		}
		
	};

	
	public abstract boolean canTransition(State nextState);
	
	public boolean askForValidState() {
		return true;
	}
}
