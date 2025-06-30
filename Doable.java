public class Doable{
	enum Status{
		todo, done, notDone
	}
	private String description;
	private Status status;

	public Doable(String description){
		this.description = description;
		this.status = Status.todo; 
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public void setStatus(Status status) {
	    this.status = status;
	}

	public String getDescription() {
		    return description;
		}

	public Status getStatus() {
	    return status;
	}

	@Override
	public String toString() {
		String statusSing = switch (this.status) {
			case todo-> "☐";
			case done -> "☑";
			case notDone -> "☒";
		};

		return statusSing + " " + this.description ; 
	}






}
