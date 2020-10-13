@Library('Fork-lyso')
import bbrow.*


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
