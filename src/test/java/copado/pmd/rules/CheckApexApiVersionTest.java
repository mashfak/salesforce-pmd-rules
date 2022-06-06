package copado.pmd.rules;

import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleViolation;
import net.sourceforge.pmd.lang.LanguageVersion;
import net.sourceforge.pmd.lang.apex.ApexHandler;
import net.sourceforge.pmd.lang.apex.ApexLanguageModule;
import net.sourceforge.pmd.lang.apex.ast.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class CheckApexApiVersionTest {
    private List<RuleViolation> receivedViolations;
    private RuleContext ruleContextMock;
    private CheckApexApiVersion checkApexApiVersion;

    @Before
    public void setUp() {
        checkApexApiVersion = new CheckApexApiVersion();
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
        ruleContextMock.setLanguageVersion(new LanguageVersion(new ApexLanguageModule(),"30",new ApexHandler()));

    }

    @Test
    public void test_CheckApexApiVersion(){
        ASTUserClass astUserClassMock = Mockito.mock(ASTUserClass.class);
        checkApexApiVersion.visit(astUserClassMock,ruleContextMock);
        assertEquals(1,receivedViolations.size());
        assertSame(checkApexApiVersion,receivedViolations.get(0).getRule());
    }
}

