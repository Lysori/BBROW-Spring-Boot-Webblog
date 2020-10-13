@Library('Fork-lyso')
import bbrow.maven.mavencompile
import bbrow.maven.services


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
