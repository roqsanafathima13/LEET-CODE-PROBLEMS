import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore maxPhilosophersEating = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        
        maxPhilosophersEating.acquire();

        
        forks[left].acquire();
        forks[right].acquire();

        
        pickLeftFork.run();
        pickRightFork.run();

        
        eat.run();

        
        forks[left].release();
        forks[right].release();

        
        putLeftFork.run();
        putRightFork.run();

    
        maxPhilosophersEating.release();
    }
}
