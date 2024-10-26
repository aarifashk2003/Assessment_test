
package ruleengine;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();

        // Step 1: Create individual rules
        Node rule1 = engine.createRule("age > 30 AND salary > 50000");
        Node rule2 = engine.createRule("age < 25 AND experience > 5");

        // Step 2: Combine rules
        Node combinedRule = engine.combineRules(rule1, rule2);

        // Step 3: Test data
        Map<String, Object> testData = new HashMap<>();
        testData.put("age", 32);
        testData.put("salary", 60000);
        testData.put("experience", 3);

        // Step 4: Evaluate combined rule
        boolean isEligible = engine.evaluateRule(combinedRule, testData);
        System.out.println("Is eligible: " + isEligible); // Expected output: true or false based on data
    }
}
