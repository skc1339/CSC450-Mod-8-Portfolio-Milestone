public class ConcurrentThreadRunner {

    public static void main(String[] args) {
        Thread countUpThread = new Thread(new CountUpTask());
        Thread countDownThread = new Thread(new CountDownTask());

        countUpThread.start();

        try {
            countUpThread.join(); // Ensure second thread starts after the first finishes
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        countDownThread.start();
    }
}

class CountUpTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Counting Up: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("CountUp interrupted: " + e.getMessage());
            }
        }
    }
}

class CountDownTask implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Counting Down: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("CountDown interrupted: " + e.getMessage());
            }
        }
    }
}
