public class Trip {
    private static int idCounter = 1;
    private int id;
    private String country;
    private int duration;
    private int price;
    private int kilometers;

    public Trip(String country, int duration, int price, int kilometers) {
        this.id = idCounter++;
        this.country = country;
        this.duration = duration;
        this.price = price;
        this.kilometers = kilometers;
    }




    public int getId(){
        return id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }







    public String getCountry() {
        return country;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public int getKilometers() {
        return kilometers;
    }


    @Override
    public String toString() {
        return ("<<--<--<--<--<<->>-->-->-->-->>\n" + "\tTrip ID:" + id + "\n\tCountry: " + country + "\n\tDuration: " + duration + "\n\tPrice: " + price + ",-" + "\n\tKilometers: " + kilometers);
    }
}
