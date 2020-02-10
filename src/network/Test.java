package network;

public class Test {

    public static boolean added = false;

    public static void main(String[] args) {

        numObject obj_1 = new numObject();
        obj_1.number = 10;

        Thread add_t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (added) {
                        try {
                            synchronized (obj_1) {
                                obj_1.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj_1.addFive();
                    System.out.println("added: " + obj_1.number);
                    added = true;
                    synchronized (obj_1) {
                        obj_1.notify();
                    }

                }
            }
        });
        add_t.start();

        Thread dec_t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (!added) {
                        try {
                            synchronized (obj_1) {
                                obj_1.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj_1.decFive();
                    System.out.println("decced: " + obj_1.number);
                    added = false;
                    synchronized (obj_1) {
                        obj_1.notify();
                    }

                }
            }
        });
        dec_t.start();


        add_t.start();
        dec_t.start();

    }

}

class numObject {

    public int number;

    public synchronized void addFive() {
        this.number += 5;
    }

    public synchronized void decFive() {
        this.number -= 5;
    }

}

