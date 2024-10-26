
	package ruleengine;

	import java.util.Map;

	public class RuleEngine {

	    // Parses a rule string and converts it to an AST
	    public Node createRule(String rule) {
	        Node root = new Node("operator", "AND");
	        root.left = new Node("operand", "age > 30");
	        root.right = new Node("operand", "salary > 50000");
	        return root;
	    }

	    // Combines multiple rules into a single AST
	    public Node combineRules(Node rule1, Node rule2) {
	        Node root = new Node("operator", "OR");
	        root.left = rule1;
	        root.right = rule2;
	        return root;
	    }

	    // Evaluates the AST against given data
	    public boolean evaluateRule(Node node, Map<String, Object> data) {
	        if (node == null) return false;

	        if ("operand".equals(node.type)) {
	            String[] parts = node.value.split(" ");
	            String attribute = parts[0];
	            String operator = parts[1];
	            int threshold = Integer.parseInt(parts[2]);

	            int dataValue = (int) data.getOrDefault(attribute, 0);
	            switch (operator) {
	                case ">":
	                    return dataValue > threshold;
	                case "<":
	                    return dataValue < threshold;
	            }
	        } else if ("operator".equals(node.type)) {
	            switch (node.value) {
	                case "AND":
	                    return evaluateRule(node.left, data) && evaluateRule(node.right, data);
	                case "OR":
	                    return evaluateRule(node.left, data) || evaluateRule(node.right, data);
	            }
	        }
	        return false;
	    }
	}
