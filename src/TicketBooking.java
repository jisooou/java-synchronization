public class TicketBooking {
    private int availableTickets = 10;

    public synchronized void bookTicekt(int tickets) {
        if (availableTickets >= tickets) {
            availableTickets -= tickets;
            System.out.println(
                    "Booked " + tickets
                            + " tickets, Remaining tickets: "
                            + availableTickets
            );
        } else {
            System.out.println(
                    "Not enough tickets available to book "
                            + tickets
            );
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
