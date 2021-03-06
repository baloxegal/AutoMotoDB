package entities;

public class Category extends Entity {
	@SuppressWarnings("unused")
	private Long id;
	private String name;
	private Long parent_category_id;
		
	protected Category() {
		setTable("categories");
	}
	
	protected Category(Long id, String name, Long parent_category_id) {
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

	public long getParentCategoryId() {
		return parent_category_id;
	}

	public void setParentCategoryId(Long parent_category_id) {
		if(parent_category_id >= 0)
			this.parent_category_id = parent_category_id;
	}
}
