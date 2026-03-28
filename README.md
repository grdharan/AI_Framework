# Selenium Automation Framework (Java + TestNG + Maven)

This is a production-ready automation framework following the Page Object Model (POM) design pattern.

## Framework Features
- **Design Pattern**: Page Object Model (POM)
- **Base Class**: Handles WebDriver setup/teardown with ThreadLocal for parallel execution.
- **Reporting**: Extent Reports with automatic failure screenshots.
- **Logging**: Log4j2 for detailed execution logs.
- **Data-Driven**: Apache POI for Excel integration.
- **Utilities**: Wait helpers and config reader.
- **CI/CD**: Ready for Jenkins integration.

## How to Run
1. **From IDE**: Right-click on `testng.xml` and select 'Run'.
2. **From Command Line**:
   ```bash
   mvn clean test
   ```

## Jenkins Integration
To run this framework in Jenkins:
1. **Install Plugins**: Ensure "Maven Integration" and "HTML Publisher" plugins are installed.
2. **Create Job**: Create a "Freestyle project" or "Maven project".
3. **Source Code Management**: Link your Git repository.
4. **Build**:
   - Root POM: `pom.xml`
   - Goals and options: `clean test`
5. **Post-build Actions**:
   - Add "Publish HTML reports".
   - HTML directory to archive: `reports/`
   - Index page[s]: `ExtentReport.html`

## Sample Jenkinsfile (Pipeline)
```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
    post {
        always {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Report'
            ])
        }
    }
}
```

## Configuration
Update `src/main/resources/config.properties` for changing the URL, browser, or timeouts.
