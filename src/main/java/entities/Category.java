package entities;

public class Category extends Entity {
	private long id;
	private String name;
	private Long parent_category_id;
		
	public Category() {
		setTable("categories");
	}
	
	public Category(long id, String name, Long parent_category_id) {
		this();
		if(id >= 0)
			this.id = id;
		if(name != null)
			this.name = name;
		if(parent_category_id >= 0)
			this.parent_category_id = parent_category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null) this.name = name;
	}

	public Long getParentCategoryId() {
		return parent_category_id;
	}

	public void setParentCategoryId(Long parent_category_id) {
		if(parent_category_id >= 0)
			this.parent_category_id = parent_category_id;
	}
}
