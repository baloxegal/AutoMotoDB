package entities;

public class Category {
	private long id;
	private String name;
	private Long parent_category_id;
	private Category parent;
	
	public Category() {
		
	}
	
	public Category(long id, String name, Long parent_category_id, Category parent) {
		this.id = id;
		this.name = name;
		this.parent_category_id = parent_category_id;
		this.parent = parent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(id >= 0) this.id = id;
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
		this.parent_category_id = parent_category_id;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent_category_id=" + parent_category_id + ", parent="
				+ parent + "]";
	}
}
