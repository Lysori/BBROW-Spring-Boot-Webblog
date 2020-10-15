pipeline {
    agent any
    environment {
       YMLPATH = 'buildImage.yml'
    }
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
                    
                    ansibleplay.buildImage()
                    
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
