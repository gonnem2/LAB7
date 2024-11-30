package SecondTask;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestForSecondTask {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {2, 6, 12, 34}, {123, 23, 9999, 1}, {0, 1, 2, 3}, {0, 1, 2333333, 3}};
        int[] res = new int[matrix.length];
        int c = 0;
        HashSet<Thread> threads = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            ThreadForSecondTask thread = new ThreadForSecondTask(matrix[i]);
            thread.start();
            threads.add(thread);
        }
        for (Thread i: threads){
            try {
                i.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            res[c++] = ((ThreadForSecondTask) i).getMostExpensive();
        }
        int mostExpensive = res[0];
        for (int i : res){
            if (i > mostExpensive){
                mostExpensive = i;
            }
        }
        System.out.println(mostExpensive);
    }
}
