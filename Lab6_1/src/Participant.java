import java.util.Random;

class Participant implements Runnable {
    private static final String[] TRANSPORTS = {"суша", "море", "воздух"};
    private final String name;
    private final Race race;
    private final Random random = new Random();

    public Participant(String name, Race race) {
        this.name = name;
        this.race = race;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String transport = TRANSPORTS[random.nextInt(TRANSPORTS.length)];
        race.addChoice(name, transport);

        synchronized (race) {
            if (race.setWinner(name, transport)) {
                System.out.println(name + " выбрал " + transport + " (победитель)");
            } else {
                System.out.println(name + " выбрал " + transport);
            }
            race.finishParticipant();
            race.notifyAll();
        }
    }
}