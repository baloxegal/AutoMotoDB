package entities;

public abstract class Entity {
	
	private Long id;
	private String table;
	
	public abstract Long getId();

	public abstract void setId(Long id);
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
