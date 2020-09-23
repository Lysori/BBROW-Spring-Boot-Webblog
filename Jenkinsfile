pipeline {
    agent none
    stages {
        stage('test') {
            agent {
                docker {
                	label 'test-docker' 
                	image 'maven:3-alpine' 
                }
            }
            steps {
                sh 'mvn --version'
            }
        }
    }
}