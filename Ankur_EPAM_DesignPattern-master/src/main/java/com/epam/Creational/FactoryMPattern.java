package com.epam.Creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan {

    public void getRate(){
        rate=2.50;
    }
}
class CommercialPlan extends Plan {

    public void getRate() {
        rate = 4.50;
    }
}

class InstitutionPlan extends Plan {

    public void getRate() {
        rate = 5.50;
    }
}

class GetPlanFactory {

    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTIC")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIAL")){
            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("INSTITUTIONAL")) {
            return new InstitutionPlan();
        }
        return null;
    }
}

class GenerateBill {

    public static void main(String args[])throws IOException {
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("Enter the name of plan for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String planName=br.readLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units=Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planName);

        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
        p.getRate();
        p.calculateBill(units);
    }
}