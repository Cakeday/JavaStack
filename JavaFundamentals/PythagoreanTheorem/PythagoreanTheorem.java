import java.lang.Math;
public class PythagoreanTheorem {
    double hypotenuse;
    public PythagoreanTheorem(){
    }
    public double calculateHypotenuse(int legA, int legB) {
        hypotenuse = Math.sqrt((legA*legA)+(legB*legB));
        return hypotenuse;
    }
}