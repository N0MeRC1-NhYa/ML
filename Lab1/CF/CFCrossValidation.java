import java.util.*;

public class CFCrossValidation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        List<Pair<Integer, Integer>> classArray = new ArrayList<>();
        for (int i = 0; i < n; i++){
            classArray.add(new Pair(in.nextInt(), i + 1));
        }
        classArray.sort(Comparator.comparingInt(Pair::first));
        for (int i = 0; i < k; i ++) {
            int currEl = i;
            ArrayList<Integer> kthRow = new ArrayList<>();
            while (currEl < n) {
                kthRow.add(classArray.get(currEl).second());
                currEl += k;
            }
            System.out.print(kthRow.size());
            for (Integer integer : kthRow) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }
    }
    private static final class Pair<F,S>{
        private final F first;
        private final S second;

        private Pair(F first, S second){
            this.first = first;
            this.second = second;
        }
        protected F first(){
            return first;
        }
        protected S second(){
            return second;
        }
    }
}
