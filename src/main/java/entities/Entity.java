package entities;

public abstract class Entity {
	
	private long id;
	private String table;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(id >= 0) this.id = id;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
