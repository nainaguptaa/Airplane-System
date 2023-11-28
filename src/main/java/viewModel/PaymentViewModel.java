package viewModel;

public class PaymentViewModel {
    public double SeatPrice;
    public double FlightPrice;
    public double Tax;
    public boolean isMember;
    public int Promotion;


    public PaymentViewModel(double SeatPrice, double FlightPrice, double Tax, boolean isMember, int Promotion){
        this.SeatPrice = SeatPrice;
        this.FlightPrice = FlightPrice;
        this.Tax = Tax;
        this.isMember = isMember;
        this.Promotion = Promotion;
    }



    
}

