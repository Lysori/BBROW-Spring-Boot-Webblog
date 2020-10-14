


pipeline {
    agent any
    environment{
        POMPATH = '/var/jenkins_home/workspace/BBROW/pom.xml'
    }
    stages {
        stage('mvn compile') {
            steps {
                script {
                    
                    infincompile.compile([flag:" -f ", pomfile: pompath]) 
                    
                }
            }
        }
        stage('mvn test') {
            steps {
                script {
                    
                    bbrowtest.maventest(POMPATH)
                    
                }
            }
        }
        stage('Package and deploy to Nexus') {
            steps {
                script {
                    
                    echo 'Package and deploy to Nexus'
                    
                }
            }
        }
        stage('mvn Install') {
            steps {
                script {
                    
                    echo 'mvn Install'
                    
                }
            }
        }
     stage('Docker Image') {
            steps {
                script {
                    
                  echo 'Docker Image'
                    
                }
            }
        }
     stage('Docker Push') {
            steps {
                script {
                    
                  echo 'Docker Push'
                    
                }
            }
        }
     stage('Deployment to Tomcat') {
            steps {
                script {
                    
                    echo 'Deployment to Tomcat'
                    
                }
            }
        }
        
    }
}
