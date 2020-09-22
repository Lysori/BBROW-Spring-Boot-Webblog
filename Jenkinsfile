pipeline {
	agent none
	stages {
		stage('test') {
			agent {
            	docker {
                	image 'maven:3.6.3-adoptopenjdk-14'
                }
			}
			steps {
				echo '### test ###'
				sh 'mvn test'
			}
		}
		stage('package') {
			agent {
            	docker {
                	image 'maven:3.6.3-adoptopenjdk-14'
                }
			}
			steps {
				echo '### package ###'
				sh 'mvn package -DskipTests'
			}
			
		}
	}
}