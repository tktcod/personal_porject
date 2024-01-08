package kiosk;

public class Menu {
    private String name;
    private String description;
    private String category;
    public Menu(String name, String description, String category){
        setName(name);
        setDescription(description);
        setCategory(category);
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String menuName) {
        this.name = menuName;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
}
