/**
 * Task class.
 */
class Task extends Item {
	protected String dueDate = "N/A";

	public Task() {
		super();
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueDate() {
		return this.dueDate;
	}
}
