package FirstTask;

public class ThreadForFirstTask extends Thread{
    private int[] array;
    private int start;
    private int stop;
    private int sum;

    ThreadForFirstTask(int[] array, int start, int stop){
        this.array = array;
        this.start = start;
        this.stop = stop;
        int sum = 0;
    }
    @Override
    public void run() {
        for (int i = start; i <= stop; i++){
            sum += array[i];
        }
    }

    public int getSum(){
        return sum;
    }
}
