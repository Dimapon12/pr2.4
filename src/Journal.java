import java.util.HashMap;
import java.util.Map;

public class Journal {
    private Map<String, Grades> studentsJournal = new HashMap<String, Grades>();
    String[] lessons, names;

    public Journal(String[] names, String[] lessons) {
        this.names = names;
        this.lessons = lessons;
        for (String name:names) {
            Grades grades = new Grades(lessons);
            studentsJournal.put(name, grades);
        }
    }

    public Map<String, Double> findLessThen(double v) {
        Map<String, Double> res = new HashMap<String, Double>();

        for (String name : studentsJournal.keySet()) {
            double avg = studentsJournal.get(name).getAverage();
            if (avg < v)
                res.put(name, avg);
        }
        return res;
    }

    public void print() {
        System.out.printf("%10s", "");
        for (String lesson:lessons) {
            System.out.printf("%18s", lesson);
        }
        System.out.println();
        System.out.println();
        for (String name : studentsJournal.keySet()) {
            System.out.printf("%10s", name);
            studentsJournal.get(name).print();
            System.out.println();
        }
    }
}
