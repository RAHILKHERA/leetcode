package DesignPattern.CreationalPatterns.BuilderPatter_1;

import java.time.LocalDate;
import java.util.List;

public interface VacationPackageBuilder {
    
    public VacationPackageBuilder withHotelName(String hotelName);
    public VacationPackageBuilder withFlightsIncluded(boolean flightsIncluded);
    public VacationPackageBuilder withMealsIncluded(boolean mealsIncluded);
    public VacationPackageBuilder addGuidedTours(String tour);
    public VacationPackageBuilder withInsuranceIncluded(boolean insuranceIncluded);
    public VacationPackage build();
    public String getDestination();
    public LocalDate getStartDate();
    public LocalDate getEndDate();
    public boolean isFlightsIncluded();
    public boolean isInsuranceIncluded();
    public boolean isMealsIncluded();
    public List<String> getGuidedTours();
    public Object getHotelName();
}
