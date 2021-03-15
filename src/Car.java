import java.util.Random;

public class Car implements Runnable {
    // khai bao ten cuoc dua xe;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // khoi tao diem start(hay km ban dau);
        int runDistance = 0;
        // khoi tao time bat dau cuoc dua;
        long startTime = System.currentTimeMillis();

        // kiem tra chung nao con xe chua ket thuc quang duong dua thi xe van tiep tuc chay;
        while (runDistance < Main.DISTANCE) {
            try {
                // Random Speed KM/H;
                int speed = (new Random()).nextInt(20);
                // Calculate traveled distance;
                runDistance += speed;
                // build result graphic;
                String log = " | ";
                int percentTravel = (runDistance * 100) / Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += " | ";
                System.out.println("Car " + this.name + " : " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car " + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " + this.name + " Finish in " + (endTime - startTime) / 100 + "s");
    }
}
