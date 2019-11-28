public class ProjectTest{

    public static void main(String[] args) {
        Project test = new Project();

        test.setName("Project 1");
        test.setDesc("this is some project lol");
        test.setInitialCost(50);
        test.elevatorPitch();

        test.setName("Project 2");
        test.setDesc("this is another project lol");
        test.elevatorPitch();

        test.setName("Project 3");
        test.setDesc("this is a third project lol");
        test.elevatorPitch();



    }
}