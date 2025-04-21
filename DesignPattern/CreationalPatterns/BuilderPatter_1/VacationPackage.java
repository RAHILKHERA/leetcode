package DesignPattern.CreationalPatterns.BuilderPatter_1;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class VacationPackage {
    
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private String hotelName;
    private boolean flightsIncluded;
    private boolean mealsIncluded;
    private List<String> guidedTours;
    private boolean insuranceIncluded;
    
    public VacationPackage(VacationPackageBuilderImpl vacationPackageBuilder) {
        destination = vacationPackageBuilder.getDestination();
        startDate = vacationPackageBuilder.getStartDate();
        endDate = vacationPackageBuilder.getEndDate();
        flightsIncluded = vacationPackageBuilder.isFlightsIncluded();
        mealsIncluded = vacationPackageBuilder.isMealsIncluded();
        insuranceIncluded = vacationPackageBuilder.isInsuranceIncluded();
        guidedTours = vacationPackageBuilder.getGuidedTours();
        hotelName = Optional.ofNullable(vacationPackageBuilder.getHotelName()).orElse("");
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public boolean isFlightsIncluded() {
        return flightsIncluded;
    }

    public boolean isMealsIncluded() {
        return mealsIncluded;
    }

    public List<String> getGuidedTours() {
        return guidedTours;
    }

    public boolean isInsuranceIncluded() {
        return insuranceIncluded;
    }

    @Override
    public String toString() {
        return "VacationPackage [destination=" + destination + ", startDate=" + startDate + ", endDate=" + endDate
                + ", hotelName=" + hotelName + ", flightsIncluded=" + flightsIncluded + ", mealsIncluded="
                + mealsIncluded + ", guidedTours=" + guidedTours + ", insuranceIncluded=" + insuranceIncluded + "]";
    }
    
}
