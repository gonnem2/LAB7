package SecondTask;

public class ThreadForSecondTask extends Thread{

    private int[] array;
    private int mostExpensive;

    ThreadForSecondTask(int[] array){
        this.array = array;
        mostExpensive = -10000;
    }

    @Override
    public void run() {
        int max = array[0];

        for (int i: array){
            if (i > max){
                max = i;
            }
        }
        mostExpensive = max;
    }

    public int getMostExpensive(){
        return mostExpensive;
    }
}
