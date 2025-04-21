package DesignPattern.CreationalPatterns.BuilderPatter_1;

import java.time.LocalDate;
import java.util.Calendar;

public class Demo {
    public static void main(String[] args) {

        VacationPackage trip = new VacationPackageBuilderImpl("Bali", LocalDate.of(2025, Calendar.MAY, 1),
                LocalDate.of(2025, Calendar.MAY, 10))
                .withHotelName("Ocean View Resort")
                .withFlightsIncluded(true)
                .withMealsIncluded(true)
                .addGuidedTours("Ubud Tour")
                .addGuidedTours("Snorkeling Adventure")
                .withInsuranceIncluded(true)
                .build();

        System.out.println(trip.toString());
    }
}
