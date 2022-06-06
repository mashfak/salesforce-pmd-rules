package copado.pmd.rules;

import net.sourceforge.pmd.lang.apex.ast.*;
import net.sourceforge.pmd.lang.apex.rule.AbstractApexRule;
import net.sourceforge.pmd.RuleContext;

public class CheckApexApiVersion extends AbstractApexRule{
    private final static String VIOLATION_MSG = "The Apex Class API Version Must be Above 40";
    private final Double minimumVersion = 40.0;
    private Double version;

    public Boolean isVersionBelow40(RuleContext context){
        boolean answer = false;
        try {
            version = Double.parseDouble(context.getLanguageVersion().getVersion());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        if (version<minimumVersion){
            answer = true;
        }
        return answer;
    }

    @Override
    public Object visit(ASTUserClass node, Object data) {
        if (isVersionBelow40((RuleContext) data)){
            this.addViolationWithMessage(data,node,VIOLATION_MSG);
        }
        return data;
    }
}