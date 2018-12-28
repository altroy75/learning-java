package assignments.issuetracker.model;

import assignments.issuetracker.InputProvider;

/**
 * Bug class.
 */
public class Bug extends Item {
	private int severity = 1;	// 1 - 10

	private Bug(Builder builder) {
		super(builder);
		severity = builder.severity;
	}

	public boolean setSeverity(int severity) {
		if (severity >= 1 && severity <= 10) {
			this.severity = severity;
			return true;
		} else {
			return false;
		}
	}

	public int getSeverity() {
		return this.severity;
	}

	
	
	public static class Builder extends Item.Builder<Bug>{

		int severity;

		@Override
		protected void additionalValues(InputProvider inputProvider) {
			severity = inputProvider.getIntValue("severity", "Valid values: 1-10");
			while(severity > 10 || severity < 1) {
				severity = inputProvider.getIntValue("severity","Valid values: 1-10");
			}
		}

		@Override
		public Bug build(InputProvider inputProvider) {
			initValues(inputProvider);
			return new Bug(this);
		}
		
	}
}
