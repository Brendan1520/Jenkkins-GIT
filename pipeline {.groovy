pipeline {
    agent any
    environment {
        DIRECTORY_PATH = "/Users/Brendan/Desktop/SIT223"
        TESTING_ENVIRONMENT = 'Test'
        PRODUCTION_ENVIRONMENT = 'Brendan'
    }
    stages {
        stage("Build") {
            steps {
                echo "fetch the source code from the directory path specified by the environment variable: $DIRECTORY_PATH"
                echo "compile the code and generate any necessary artifacts" 
            }
        }
        stage("Test") {
            steps {
                 echo "unit tests"
                 echo "integration tests"
            }
        }
        stage("Code") {
            steps {
                echo "check the quality of the code"
            }
        }
        stage("Deploy") {
            steps {
                echo "deploy the application to a testing environemnt specified by the environemnt variable: $TESTING_ENVIRONMENT"
            }
        }
        stage("Approval") {
            steps {
                sleep 10
                echo "Approved"
            }
        }
        stage("Deploy to Production") {
            steps {
                echo "Deploy the code to the production Environment using the environment name: $PRODUCTION_ENVIRONMENT"
            }
        }
    }    
}