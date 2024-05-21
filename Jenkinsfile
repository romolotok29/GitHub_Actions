pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'ci_cd', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/romolotok29/aqa25_onl.git'
            }
        }
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                //git 'https://github.com/wildpioneer/AQA21onl.git'
                //checkout scmGit(branches: [[name: '*/ci_cd']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/wildpioneer/AQA21onl.git']])

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '/target/surefire-reports/TEST-*.xml'
                    //archiveArtifacts 'target/allure-results/'
                    allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}