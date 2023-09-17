package Problem1;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();
    public static void main(String[] args) {
        int n = input.nextInt();
        if(n == 1){
            System.out.println(1);
            System.exit(0);
        }
        if(n == 2){
            System.out.println(4);
            System.exit(0);
        }
        // тут n >= 3
        // 8 12 16 20 24 , арифметическая прогрессия
        System.out.println(8 + 4 * (n-3));
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
