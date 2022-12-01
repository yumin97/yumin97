import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(set.toArray(new String[set.size()])));
        Collections.sort(inputs, (s1,s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length());

        for (String s: inputs) {
            System.out.println(s);
        }
    }
}
