package copado.pmd.rules;

import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleViolation;
import net.sourceforge.pmd.lang.LanguageVersion;
import net.sourceforge.pmd.lang.apex.ApexHandler;
import net.sourceforge.pmd.lang.apex.ApexLanguageModule;
import net.sourceforge.pmd.lang.apex.ast.ASTIfBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTUserClass;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

public class ExampleRuleTest  {

    private ExampleRule exampleRule;
    private List<RuleViolation> receivedViolations;
    private RuleContext ruleContextMock;

    @Before
    public void setUp() {
        exampleRule = new ExampleRule();
        receivedViolations = new LinkedList<>();
        ruleContextMock = new RuleContext() {
            @Override
            public Report getReport() {
                return new Report() {
                    @Override
                    public void addRuleViolation(RuleViolation violation) {
                        receivedViolations.add(violation);
                    }
                };
            }
        };
        ruleContextMock.setLanguageVersion(new LanguageVersion(new ApexLanguageModule(),"",new ApexHandler()));

    }

    @Test
    public void test_visitASTUserClass_ThenShouldAddViolation() {
        ASTUserClass astUserClassMock = mock(ASTUserClass.class);
        exampleRule.visit(astUserClassMock,ruleContextMock);
        assertEquals(1,receivedViolations.size());
        assertSame(exampleRule,receivedViolations.get(0).getRule());
    }

    @Test
    public void test_visitASTIfBlockStatement_ThenShouldAddViolation() {
        ASTIfBlockStatement astIfBlockStatement = mock(ASTIfBlockStatement.class);
        exampleRule.visit(astIfBlockStatement,ruleContextMock);
        assertEquals(1,receivedViolations.size());
        assertSame(exampleRule,receivedViolations.get(0).getRule());
    }

}
