package DesignPattern.CreationalPatterns.FactoryMethodPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GenerateBill {
    
    public static void main(String[] args) {
            
        System.out.println("Choose your bill plan 1) Domestic 2) Commercial 3) Institutional");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            GetPlanFactory gpf = new GetPlanFactory();
            Plan plan = gpf.getPlan(br.readLine());
            plan.setRate();

            System.out.println("Enter the number of units consumed ");
            int units = Integer.parseInt(br.readLine());

            System.out.println("The amount of the bill for electricity consumption is : "  + plan.calculateBill(units));
        

        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
