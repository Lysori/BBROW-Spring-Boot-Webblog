


pipeline {
    agent any
    stages {
        stage('test mvn compile') {
            steps {
                script {
                    echo 'webhook'
                    infincompile.compile()
                    echo 'Funktionstest'
                }
            }
        }
        
    }
}
