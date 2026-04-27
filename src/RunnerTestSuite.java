import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
	AccountTestClass.class,
	BankHandlingTestClass.class,
	LoansTestClass.class
})
class RunnerTestSuite {


}
