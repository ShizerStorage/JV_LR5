import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class ClientRequest implements Comparable<ClientRequest> {
    String user;
    int priority;
    LocalDateTime time;

    public ClientRequest(String user, int priority) {
        this.user = user;
        this.priority = priority;
        this.time = LocalDateTime.now();
    }

    @Override
    public int compareTo(ClientRequest other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "[user=" + user + ", pr=" + priority + ", time=" + time + "]";
    }
}

public class RequestQueueApp {
    private PriorityQueue<ClientRequest> requestQueue = new PriorityQueue<>();
    private Queue<ClientRequest> history = new LinkedList<>();

    public static void main(String[] args) {
        RequestQueueApp app = new RequestQueueApp();
        app.simulate();
    }

    private void simulate() {
        // Додавання кількох запитів
        addRequest("Alice", 2);
        addRequest("Bob", 5);
        addRequest("Carol", 1);

        System.out.println("Обробка запитів за пріоритетом:");
        while (!requestQueue.isEmpty()) {
            ClientRequest req = requestQueue.poll();
            System.out.println("Оброблено: " + req);
            history.add(req);
        }

        System.out.println("\nСтатистика оброблених запитів:");
        history.forEach(System.out::println);
    }

    private void addRequest(String user, int priority) {
        ClientRequest req = new ClientRequest(user, priority);
        requestQueue.add(req);
        System.out.println("Додано: " + req);
    }
}
