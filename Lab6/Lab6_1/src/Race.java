import java.util.HashMap;
import java.util.Map;

class Race {
    private String winnerName;
    private String winnerTransport;
    private int finishedCount = 0;
    private final Map<String, String> choices = new HashMap<>();

    public synchronized boolean setWinner(String name, String transport) {
        if (winnerName == null) {
            winnerName = name;
            winnerTransport = transport;
            return true;
        }
        return false;
    }

    public synchronized void addChoice(String name, String transport) {
        choices.put(name, transport);
    }

    public synchronized void finishParticipant() {
        finishedCount++;
    }

    public synchronized int getFinishedCount() {
        return finishedCount;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getWinnerTransport() {
        return winnerTransport;
    }

    public Map<String, String> getAllChoices() {
        return new HashMap<>(choices);
    }
}