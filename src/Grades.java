import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Grades {
    private Map<String, Integer> grades = new HashMap<String, Integer>();

    public Grades(String[] lessons){
        Random rand = new Random();
        for (String lesson:lessons) {
            grades.put(lesson, rand.nextInt(3) + 3);
        }
    }

    public double getAverage(){
        double res = 0;
        for (int value : grades.values()) {
            res += value;
        }
        res /= grades.size();
        return res;
    }
    public void print(){
        for (int value : grades.values()) {
            System.out.printf("%18d", value);
        }
    }
}
