import java.io.*;
import java.util.*;

public class Kathleen {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("kathleen.dat"));
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            Map<String, Set<String>> travel = new HashMap<String, Set<String>>();
            Map<String, Boolean> travelled = new HashMap<String, Boolean>();
            Queue<String> queue = new LinkedList<String>();

            for (int i = 0; i < n; i++) {
                String city = in.next();
                travel.put(city, new HashSet<String>());
                travelled.put(city, false);


                if (i == 0) {
                    queue.add(city);
                }
            }
            in.nextLine();

            for (int i = 0; i < m; i++) {
                String city1 = in.next();
                String city2 = in.next();
                travel.get(city1).add(city2);
                travel.get(city2).add(city1);
            }

            while (!queue.isEmpty()) {
                String city = queue.remove();
                if (!travelled.get(city)) {
                    travelled.put(city, true);
                    for (String s : travel.get(city)) {
                        queue.add(s);
                    }
                }
            }

            String result = "Yes";
            for (String s : travelled.keySet()) {
                if (!travelled.get(s)) {
                    result = "No";
                }
            }
            System.out.println(result);

        }
        in.close();
    }
}