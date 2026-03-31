package src;

public class Main {
    public static void main(String[] args) {
        InsuranceOffice office = new InsuranceOffice("Main Office");
        
        Policy p1 = new Policy("POL-001", "John Doe", 1000.0, 1, 30000.0, true, true);
        Policy p2 = new Policy("POL-002", "Jane Smith", 1500.0, 3, 15000.0, false, false);
        Policy p3 = new Policy("POL-001", "John Doe", 1000.0, 1, 30000.0, true, true); 
        
        office.addPolicy(p1);
        office.addPolicy(p2);
        office.displayAllPolicies();
        
        System.out.println("\nEquals Check (p1 and p2): " + p1.equals(p2));
        System.out.println("Equals Check (p1 and p3): " + p1.equals(p3));
        
        System.out.println("\nCalculations for " + p1.getPolicyNumber() + ":");
        System.out.println("Final Premium: $" + p1.calculateFinalPremium());
        System.out.println("Renewal Premium: $" + p1.calculateRenewalPremium());

        System.out.println("\nCalculations for " + p2.getPolicyNumber() + ":");
        System.out.println("Final Premium: $" + p2.calculateFinalPremium());
        System.out.println("Renewal Premium: $" + p2.calculateRenewalPremium());
        
        System.out.println("\nTotal Policies Created: " + Policy.getCreatedPolicyCount());
    }
}
