pipeline {
    agent any
    environment {
       ANSIBLE_YML1 = 'pullNexus_pushAzurecr.yml'
       ANSIBLE_YML2 = 'pullAzurecr_deploy.yml'
       ANSIBLE_YML3 = 'stopContainers_removeImages.yml'
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

        stage('Package and Deploy to Nexus') {
            steps{
                configFileProvider([configFile(fileId: 'default', variable: 'MAVEN_GLOBAL_SETTINGS')]){ 
                    script {

                        mvn.deploy()
                        
                    } 
                }
            }
        }
    
     stage('Pull war from Nexus, build the Image and Push it to Azurecr') {
            steps {
              withCredentials([
                  usernamePassword(credentialsId: 'AZURECR', usernameVariable: 'AZURECR_USER', passwordVariable: 'AZURECR_PASSWORD'),
                  usernamePassword(credentialsId: 'MYSQL', usernameVariable: 'MYSQL_USER', passwordVariable: 'MYSQL_PASSWORD')
              ]) { 
                    script {
                    
                     ansibleplay.nexuspullazurecrpush(ANSIBLE_YML1)
                    
                    }
                }
            }
            
        }
        stage('Deploy with Ansible') {
            steps {
               script {
                    
                  ansibleplay.tomcatdeploy(ANSIBLE_YML2)
                    
                }
            }
        }
        stage('Stop Containers and remove Images') {
            steps {

                echo 'ansibleplay.execute(ANSIBLE_YML3) disabled -> live demo'
               /*script {
                    
                  ansibleplay.execute(ANSIBLE_YML3)
                    
                }*/
            }
        }
    }
}
