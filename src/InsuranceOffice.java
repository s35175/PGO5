package src;

import java.util.ArrayList;

public class InsuranceOffice {
    private String officeName;
    private ArrayList<Policy> policies; 
    
    public InsuranceOffice(String officeName) {
        this.officeName = officeName;
        this.policies = new ArrayList<>();
    }
    
    public void addPolicy(Policy policy) {
        policies.add(policy);
    }
    
    public void displayAllPolicies() {
        System.out.println("--- Policies in " + officeName + " ---");
        for (Policy p : policies) { 
            System.out.println(p.toString()); 
        }
    }
}
