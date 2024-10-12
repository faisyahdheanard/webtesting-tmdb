## Getting Started


### Prerequisites

Before getting started, ensure that you have the following software installed on your machine:

```
1. Java JDK (the latest version)
2. Jetbrains Aqua or IntelliJ IDE or VSCode
```

### Installing
1. Clone this project.
2. Open the project in IntelliJ IDE or Aqua or VSCode.
3. Open the terminal in Intellij IDE or Aqua or VSCode.
4. Build the project

```
./gradlew build

```
5. Edit your account at java/datas/loginData.java:
```
public class loginData {

    public static String USERNAME = "yourmail@gmail.com";
    public static String PASSWORD = "yourPassword";

}
```


### Running the test

To execute the automated tests, run this: 
```
./gradlew clean test

```
or you can run it on testRun in java/testRunner.java

These commands will run the Cucumber tests with the specified configurations and generate HTML test reports in the "target" directory.


## Report path
1. test-output (automation): 
- CucumberReport
- PdfReport
- SparkReport

Screenshot reports:

![Screenshot](https://drive.google.com/uc?export=download&id=1gIYZqwmuDv9F7G5SLS1EgdCzitTs3ikE)
![Screenshot](https://drive.google.com/uc?export=download&id=1R74QYcCrykzIAVF1DpdX-7Y5LRywTeBR)

## Info
Only a few cases are automated due to time constraints.

