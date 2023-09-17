package Problem3;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int m = input.nextInt();
        int minNumber = 0;
        List<Integer> allnumbers = new ArrayList<>();
        Map<Integer, Integer> check = new HashMap<>(); // число - полка
        for (int i = 0; i < 2 * Math.pow(10, 5); i++) {
            allnumbers.add(0);
        }
        for (int i = 0; i < m; i++) {
            String s = input.next();
            int x = input.nextInt();
            if (s.equals("-")) {
                int indexOfDetail = check.get(x);
                //System.out.println("x - " + x + " " + indexOfDetail);
                allnumbers.set(indexOfDetail - 1, 0);
                check.put(x, 0);
                //System.out.println("index" + (indexOfDetail - 1));
                if (indexOfDetail - 1 < minNumber) {
                    minNumber = indexOfDetail - 1;
                }
                // 0 означает, что детали на этой полке нет, также стараемся обновить минимум
            } else {
                System.out.println(minNumber + 1);
                // сюда попали если хотим положить деталь
                allnumbers.set(minNumber, x);
                check.put(x , minNumber + 1);
                // положили детали, теперь нужно посмотреть на минимум
                for (int k = minNumber + 1; k < allnumbers.size(); k++) {
                    if(allnumbers.get(k) == 0){
                        minNumber = k;
                        break;
                    }
                }

            }
        }
    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
