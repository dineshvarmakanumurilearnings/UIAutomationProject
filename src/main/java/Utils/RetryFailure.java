package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailure implements IRetryAnalyzer{

	int counter=1;
	int retryLimit =3;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<=retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
