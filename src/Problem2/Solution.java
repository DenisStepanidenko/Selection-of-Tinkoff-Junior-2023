package Problem2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int m = input.nextInt();
        // от числа 1 до числа m * n
        int[][] arr = new int[m][n];
        int finalNumber = n * m; // по условию не может быть больше чем 2 * 10 ^ 5
        int start = 0;
        int finish = 0;
        for (int i = 1; i <= finalNumber; ) {
            //int x = start, y = finish;
//            while (y >= x) {
//                System.out.println(x + ", " + y);
//                arr[x][y] = i;
//                x++;
//                y--;
//                i++;
//            }
            int y = finish;
            for (int x = start; x <= finish; ) {
                //System.out.println(x + ", " + y);
                arr[x][y] = i;
                x++;
                y--;
                i++;
                if (x == (m)) {
                    break;
                }
            }
            finish++;
            if (finish == n) {
                finish--;
                start++;
                if (start == m) {
                    start--;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
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
