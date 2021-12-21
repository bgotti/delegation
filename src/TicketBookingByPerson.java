public class TicketBookingByPerson implements TravelBooking {

    TravelBooking t;

    public TicketBookingByPerson(TravelBooking t) {
        this.t = t;
    }

    // Delegation en utilisant le polymorphisme
    @Override
    public void bookTicket() {
        t.bookTicket();
    }
}