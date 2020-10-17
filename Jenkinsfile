pipeline {
    agent any
    environment {
       BUILDYML = 'buildImage.yml'
       PUSHYML = 'loginPush.yml'
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
            steps{
                configFileProvider([configFile(fileId: 'default', variable: 'MAVEN_SETTINGS')]){
                    script {

                        mvn.deploy()
                        
                    }
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
              withCredentials([usernamePassword(credentialsId: 'AZURECR', usernameVariable: 'AZURECR_USERNAME', passwordVariable: 'AZURECR_PASSWORD')]) {
                
                script {
                    
                  ansibleplay.imagepush()
                    
                }
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
