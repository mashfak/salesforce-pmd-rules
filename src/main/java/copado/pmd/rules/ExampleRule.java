package copado.pmd.rules;


import net.sourceforge.pmd.lang.apex.ast.ASTIfBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTUserClass;
import net.sourceforge.pmd.lang.apex.rule.complexity.AvoidDeeplyNestedIfStmtsRule;

public class ExampleRule extends AvoidDeeplyNestedIfStmtsRule {
    public Object visit(ASTUserClass node, Object data) {
        addViolation(data,node);
        return data;
    }

    public Object visit(ASTIfBlockStatement node, Object data) {
        addViolation(data,node);
        return data;
    }

}
