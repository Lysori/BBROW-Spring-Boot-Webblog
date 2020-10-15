


pipeline {
    agent any

    stages {
        stage('mvn compile') {
            steps {
                script {
                    
                    mvn.compile() 
                    
                }
            }
        }
        stage('mvn test') {
            steps {
                script {
                    
                    mvn.test()
                    
                }
            }
        }

        stage('mvn verify/sonar') {
            steps {
                script {
                    
                    mvn.verify()
                    
                }
            }
        }

        stage('Package and deploy to Nexus') {
            steps {
                script {
                    
                    mvn.artifactpackage()
                    ansible-playbook.buildImage()
                    
                }
            }
        }

     stage('Pull and Build Image') {
            steps {
                script {
                    
                  echo 'ansible-playbook pull from nexus and buildImage.yml'
                    
                }
            }
        }
     stage('Push Image') {
            steps {
                script {
                    
                  echo 'ansible-playbook pushImage.yml'
                    
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
