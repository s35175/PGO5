package src;

import java.util.Objects;

public class Policy {
    private String policyNumber;
    private String clientName;
    private double basePremium;
    private int riskLevel;
    private double vehicleValue;
    private boolean hasAlarm;
    private boolean claimFreeClient;
    
    private static int createdPolicyCount = 0;
    private static final double ADMINISTRATIVE_FEE = 50.0;

    public Policy(String policyNumber, String clientName, double basePremium, int riskLevel, double vehicleValue, boolean hasAlarm, boolean claimFreeClient) {
        this.policyNumber = policyNumber;
        this.clientName = clientName;
        this.basePremium = basePremium;
        this.riskLevel = riskLevel;
        this.vehicleValue = vehicleValue;
        this.hasAlarm = hasAlarm;
        this.claimFreeClient = claimFreeClient;
        createdPolicyCount++; 
    }

    public static int getCreatedPolicyCount() { 
        return createdPolicyCount; 
    }
    
    public String getPolicyNumber() { 
        return policyNumber; 
    }

    public double calculateFinalPremium() {
        double premium = basePremium;
        if (hasAlarm) {
            premium -= (premium * 0.05);
        }
        return premium + ADMINISTRATIVE_FEE;
    }

    public double calculateRenewalPremium() {
        double premium = basePremium;
        if (claimFreeClient) {
            premium -= (premium * 0.10);
        } else {
            premium += (premium * (riskLevel * 0.05));
        }
        return premium + ADMINISTRATIVE_FEE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() { 
        return Objects.hashCode(policyNumber); 
    }

    @Override
    public String toString() {
        return String.format("Policy[No: %s, Client: %s, Base: $%.2f, Risk: %d, Alarm: %b, ClaimFree: %b]", 
                policyNumber, clientName, basePremium, riskLevel, hasAlarm, claimFreeClient);
    }
}
