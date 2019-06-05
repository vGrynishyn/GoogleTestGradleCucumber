//import org.junit.runner.Description;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import org.junit.runner.notification.RunListener;

//public class TestListener extends RunListener {
//
//    public void testRunStarted(Description description) throws Exception {
//        System.out.println("Number of tests to execute: " + description.testCount());
//    }

//    public void testRunFinished(Result result) throws Exception {
//        System.out.println("Number of tests executed: " + result.getRunCount());
//    }

//    public void testStarted(Description description) throws Exception {
//        System.out.println("Starting: " + description.getMethodName());
//    }
//
//    public void testFinished(Description description) throws Exception {
//        System.out.println("Finished: " + description.getMethodName());
//    }
//
//    public void testFailure(Failure failure) throws Exception {
//        System.out.println("Failed: " + failure.getDescription().getMethodName());
//    }
//
//    public void testAssumptionFailure(Failure failure) {
//        System.out.println("Failed: " + failure.getDescription().getMethodName());
//    }
//
//    public void testIgnored(Description description) throws Exception {
//        System.out.println("Ignored: " + description.getMethodName());
//    }

//
//    @Override
//    public void onTestStart(ITestResult result) {
//        LogInformation.info("==============================================");
//        LogInformation.info("Start test: " + result.getName());
//        LogInformation.info("==============================================");
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        LogInformation.info("==============================================");
//        LogInformation.info("Test finished successfuly: " + result.getName());
//        LogInformation.info("==============================================");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//
//    }
//}