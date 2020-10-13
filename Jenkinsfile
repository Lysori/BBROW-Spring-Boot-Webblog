@Library('Fork-lyso')
import bbrow.maven.mavencompile
import bbrow.maven.mavencompileInterface


pipeline {
    agent any
    stages {
        stage('test mvn compile') {
            steps {
                script {
                mavencompile.version()
                    echo 'Funktionstest'
                }
            }
        }
        
    }
}
