import java.util.*;

public class demo {

    private static final double EPSILON = 1e-6;

    // Class to keep number and its expression
    static class NumExpr {
        double value;
        String expr;

        NumExpr(double value, String expr) {
            this.value = value;
            this.expr = expr;
        }
    }

    public static void main(String[] args) {
        double[] numbers = {1,2,3,4};
        int target = 10;

        List<NumExpr> numExprList = new ArrayList<>();
        for (double n : numbers) numExprList.add(new NumExpr(n, String.valueOf((int)n)));
        Set<String> res = new HashSet<>();
            findExpression(numExprList, target, res);
        System.out.println(res);
    }

    private static void findExpression(List<NumExpr> nums, double target,Set<String> Solutions) {
        if (nums.size() == 1) {
            if (Math.abs(nums.get(0).value - target) < EPSILON) {
                Solutions.add(nums.get(0).expr);
                return ;
            }
            return ;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (i == j) continue;

                List<NumExpr> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                NumExpr a = nums.get(i);
                NumExpr b = nums.get(j);

                for (NumExpr result : compute(a, b)) {
                    next.add(result);
                    findExpression(next, target, Solutions);
                    next.remove(next.size() - 1);
                }
            }
        }
    }

    private static List<NumExpr> compute(NumExpr a, NumExpr b) {
        List<NumExpr> results = new ArrayList<>();
        results.add(new NumExpr(a.value + b.value, "(" + a.expr + " + " + b.expr + ")"));
        results.add(new NumExpr(a.value - b.value, "(" + a.expr + " - " + b.expr + ")"));
        results.add(new NumExpr(b.value - a.value, "(" + b.expr + " - " + a.expr + ")"));
        results.add(new NumExpr(a.value * b.value, "(" + a.expr + " * " + b.expr + ")"));
        if (Math.abs(b.value) > EPSILON) {
            results.add(new NumExpr(a.value / b.value, "(" + a.expr + " / " + b.expr + ")"));
        }
        if (Math.abs(a.value) > EPSILON) {
            results.add(new NumExpr(b.value / a.value, "(" + b.expr + " / " + a.expr + ")"));
        }
        return results;
    }
}
