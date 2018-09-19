# spring
TDD using Spring

Unit testing Spring MVC Controllers
To unit test your Spring MVC Controllers as POJOs, use ModelAndViewAssert combined with MockHttpServletRequest, MockHttpSession, and so on from Spring’s Servlet API mocks. For thorough integration testing of your Spring MVC and REST Controllers in conjunction with your WebApplicationContext configuration for Spring MVC, use the Spring MVC Test Framework instead.


A dummy object is passed around but never used, i.e., its methods are never called. Such an object can for example be used to fill the parameter list of a method.

Fake objects have working implementations, but are usually simplified. For example, they use an in memory database and not a real database.

A stub class is an partial implementation for an interface or class with the purpose of using an instance of this stub class during testing. Stubs usually don’t respond to anything outside what’s programmed in for the test. Stubs may also record information about calls.

A mock object is a dummy implementation for an interface or a class in which you define the output of certain method calls. Mock objects are configured to perform a certain behavior during a test. They typically record the interaction with the system and tests can validate that.


Don't use Impl suffix for naming classes - good discussion.
Also using interfaces for singular class in Spring - some debate on this.
https://stackoverflow.com/questions/2814805/java-interfaces-implementation-naming-convention/2814831

Package Names:
Use the plural for packages with homogeneous contents and the singular for packages with heterogeneous contents.
https://softwareengineering.stackexchange.com/questions/75919/should-package-names-be-singular-or-plural