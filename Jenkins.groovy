pipeline {
    agent any
    environment {
        STAGING_SERVER = "AWS EC2"
        PRODUCTION_SERVER = "Digital Oceans"
    }
    stages {
        stage("Build") {
            steps {
                echo "This is the Building Stage. This stage will allow to build code by compiling and packaging using an automation tool, a Build Test tool would be, Maven"
            }
        }
        stage("Unit and Intergration Test") {
            steps {
                 echo "Thiss stage will help verify that code function as intended and that various components of the programme work together as planned, a Unit Test tool would be NUnit and an Intergration Test tool would be Citrus or Protractor"
            }

            post{
                success {
                    emailext attachLog: true, 
                    body: 'Success', 
                    subject: 'Stage Status: Unit and Intergration Test', 
                    to: 'kevinsamarasekara2121@gmail.com'
                }
                failure{
                    emailext attachLog: true, 
                    body: 'Fail', 
                    subject: 'Stage Status: Unit and Intergration Test', 
                    to: 'kevinsamarasekara2121@gmail.com'
                }
            }

        }
        stage("Code Analysis Check") {
            steps {
                echo "Code Analysis check will help to check weather the code complies with industry standard, a Code Analysis Check tool would be, SonarQube"
                
            }
        }
        stage("Security Scan Stage") {
            steps {
                echo "This stage will make sure that there will be a security check for any exploits, a Security Scan Stage tool would be Nikto"
            }

            post{
                success {
                    emailext attachLog: true, 
                    body: 'Success', 
                    subject: 'Stage Status: Security Scan', 
                    to: 'kevinsamarasekara2121@gmail.com'
                }
                failure{
                    emailext attachLog: true, 
                    body: 'Fail', 
                    subject: 'Stage Status: Security Scan', 
                    to: 'kevinsamarasekara2121@gmail.com'
                }
            }
        }
        stage("Deploy to Staging") {
            steps {
                echo "Uploads the program to a staging server, $STAGING_SERVER"
            }
        }
        stage("Integration tests on staging") {
            steps {
                echo "This stage will do checks to make sure the applications functions as intended in a situation like production"
            }

            post {
                success {
                    emailext attachLog: true, 
                    body: 'Success', 
                    subject: 'Status of Integration Test on Staging', 
                    to: 'kevinsamarasekara2121@gmail.com'
                }
                failure {
                    emailext attachLog: true, 
                    body: 'Fail', 
                    subject: 'Status of Integration Test on Staging', 
                    to: 'kevinsamarasekara2121@gmail.com'
            }
        }
        }
        stage("Deploy to Production") {
            steps {
                echo "Upload the Program to a production server, $PRODUCTION_SERVER"
            }
        }
        
    }    
}