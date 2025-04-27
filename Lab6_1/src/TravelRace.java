public class TravelRace {
    public static void main(String[] args) throws InterruptedException {
        Race race = new Race();

        Thread[] participants = {
                new Thread(new Participant("Участник 1", race)),
                new Thread(new Participant("Участник 2", race)),
                new Thread(new Participant("Участник 3", race))
        };

        for (Thread t : participants) t.start();

        synchronized (race) {
            while (race.getFinishedCount() < 3) {
                race.wait();
            }
        }

        System.out.println("\nПобедитель: " + race.getWinnerName()
                + ", способ: " + race.getWinnerTransport());
        System.out.println("Все выборы: " + race.getAllChoices());
    }
}
