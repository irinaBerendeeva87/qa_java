π **Unit tests ZOO Program** π

Application for zoologists: they are exploring the feline family. To record observations, scientists use a special program.

As part of the training, I wrote unit tests with using the Jacoco, Mockito ΠΈ JUnit4.
The project used Java 11 and used the Maven build system. And the Jacoco report was generated.
In this project I used DI and wrote mocks with Mockito. 
 
π **Task** π

The Lion class shouldn't depend on the Feline class. Use the DI. 
Cover the Feline, Cat and Lion classes with tests. Use mock and parameterization where needed.
Generate Jacoco report with not less 70% coverage.

π **Instructions how to run** π

1. Clone this repo and clone your version of the report. 
2. Run AllTest.java

**Generate a Jacoco report**

1. Make command : mvn verify
2. Find the file in the target/site/jacoco/ folder index.html , rightβclick on it and select Open In - Browser β your browser.
