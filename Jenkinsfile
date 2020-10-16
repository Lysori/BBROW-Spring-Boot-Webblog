pipeline {
    agent any
    environment {
       BUILDYML = 'buildImage.yml'
       PUSHYML = 'loginPush.yml'
       USERNAME = 'devopsdus2020'
       PASSWORD = 'ext/cj5v9Q8maQdxY1yngPgB57l4Eja2'
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
                    
                    echo 'deploy to nexus still not possible'
                    
                }
            }
        }

     stage('Pull and Build Image') {
            steps {
                script {
                    
                  ansibleplay.imagebuild()
                    
                }
            }
        }
     stage('Push Image') {
            steps {
                script {
                    
                  ansibleplay.imagepush()
                    
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
