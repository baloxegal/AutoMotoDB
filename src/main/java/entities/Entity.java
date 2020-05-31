package entities;

public abstract class Entity {
	
	private Long id;
	private String table;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id >= 0) this.id = id;
	}
	
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}
