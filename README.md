# plangenerator
plangenerator
main: main package holds the driver class with the main method which takes parameters for repayment plan as command line arguments and prints the contents of the repayment plan in a csv file named as output.csv

model: model package holds the Java POJO classes. PlanGeneratorRequest is a POJO class which wraps the parameters for repayment plan. MonthlyPlan is POJO class which wraps the monthly details and forms the basic unit of repayment plan. There is also a Constants enum which has necessary constant values for global use withing the application.

calculators: calculators package holds the necessary calculation interfaces and classes that are required for the repayment plan. It has an interface AnnuityCalculator which is implemented by FixedAnnuityCalculator class and has an overriden method which gives the annuity amount necessary for the repayment plan. Similarly, there is an interface for InterestCalculator which is implemented by SimpleInterestCalculator class and has an overriden method which gives the monthly interest on a given principal value.

plan: plan package has PlanGenerator class which does the necessary manipulation of values to generate a repayment plan (a list of MonthlyPlan).It has dependency on AnnuityCalculator and InterestCalculator which are injected via the main driver class.

util: util package has a CSVPrinter which has the logic for generating a csv file with the contents of repayment plan.

validation: validation package has a pure Java GlobalExceptionHandler class which handles any of the uncaught runtime exceptions which may occur.

The project also has the necessary test classes with junits covering the written code.
