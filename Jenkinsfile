@Library('Fork-lyso')
import bbrow.maven.mavencompile


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
