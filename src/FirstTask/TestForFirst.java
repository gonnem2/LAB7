package FirstTask;

public class TestForFirst {

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 12, 23, 647};
        int start = 0;
        int stop = (arr.length - 1) / 2;
        int end = arr.length - 1;
        ThreadForFirstTask thread1 = new ThreadForFirstTask(arr, start, stop);
        ThreadForFirstTask thread2 = new ThreadForFirstTask(arr, stop + 1, end);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(thread2.getSum() + thread1.getSum());
    }
}
