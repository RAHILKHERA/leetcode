package DesignPattern.CreationalPatterns.FactoryMethodPattern;

class GetPlanFactory {

    public GetPlanFactory() {
    }

    public Plan getPlan (String plan) {

        switch (plan) {
            
            case "Domestic": return new DomesticPlan(); 
            case "Commercial" : return new CommercialPlan();
            case "Institutional" : return new InstitutionalPlan();
            default : throw new RuntimeException("Invalid Plan : " + plan);
        }
    }
}