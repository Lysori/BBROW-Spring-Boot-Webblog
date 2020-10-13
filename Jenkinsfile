@Library('Fork-lyso') _

pipeline {
    agent any
    stages {
        stage('test mvn compile') {
            steps {
                script {
                mavencompile.version()
                }
            }
        }
        
    }
}
