package Lesson3;

public class Park {
    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double cost;

        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
        }
    }
    public static void main(String[] args) {
        Park park = new Park("Central Park");

        Attraction rollerCoaster = park.new Attraction("Roller Coaster", "10:00 - 18:00", 500);
        Attraction ferrisWheel = park.new Attraction("Ferris Wheel", "09:00 - 20:00", 300);

        rollerCoaster.printAttractionInfo();
        System.out.println();
        ferrisWheel.printAttractionInfo();
    }
}

