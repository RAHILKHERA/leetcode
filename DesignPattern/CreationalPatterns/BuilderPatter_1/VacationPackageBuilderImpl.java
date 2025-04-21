package DesignPattern.CreationalPatterns.BuilderPatter_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VacationPackageBuilderImpl implements VacationPackageBuilder {

    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private String hotelName;
    private boolean flightsIncluded;
    private boolean mealsIncluded;
    private List<String> guidedTours;
    private boolean insuranceIncluded;

    
    public VacationPackageBuilderImpl(String destination, LocalDate startDate, LocalDate endDate) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        guidedTours = new ArrayList<>();
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String getHotelName() {
        return hotelName;
    }

    @Override
    public boolean isFlightsIncluded() {
        return flightsIncluded;
    }

    @Override
    public boolean isMealsIncluded() {
        return mealsIncluded;
    }

    @Override
    public List<String> getGuidedTours() {
        return guidedTours;
    }

    @Override
    public boolean isInsuranceIncluded() {
        return insuranceIncluded;
    }

    @Override
    public VacationPackageBuilder withHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    @Override
    public VacationPackageBuilder withFlightsIncluded(boolean flightsIncluded) {
        this.flightsIncluded = flightsIncluded;
        return this;
    }

    @Override
    public VacationPackageBuilder withMealsIncluded(boolean mealsIncluded) {
        this.mealsIncluded = mealsIncluded;
        return this;
    }

    @Override
    public VacationPackageBuilder addGuidedTours(String tour) {
        this.guidedTours.add(tour);
        return this;
    }

    @Override
    public VacationPackageBuilder withInsuranceIncluded(boolean insuranceIncluded) {
        this.insuranceIncluded = insuranceIncluded;
        return this;
    }

    @Override
    public VacationPackage build() {
        VacationPackage vacationPackage = new VacationPackage(this);
        return vacationPackage;
    }
}
