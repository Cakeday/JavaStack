public class Project{
    private String name;
    private String description;

    // get and set name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // get and set description
    public String getDesc(){
        return description;
    }
    public void setDesc(String desc){
        this.description = desc;
    }

    
    // cunstructors
    public Project(){

    }
    public Project(String name) {
        this.name = name;
    }
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void elevatorPitch(){
        System.out.println(name + ": " + description); 
    }
}