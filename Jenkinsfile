pipeline {
	agent none
    stages {
        stage('Build-Backend') {
            agent {
                docker {
                    image 'maven:3-alpine' 
                    args '-v /root/.m2:/root/.m2' 
             }
			}
            steps {
                sh 'mvn -B -DskipTests clean install' 
            }
        }
        stage('Deploy-Backend') {
            agent {
                docker {
                    image 'openjdk:8-jdk-alpine' 
                    args '-v /user/local/app:$WORKSPACE/target' 
             }
			}			 
            steps {
		sh 'mkdir -p /user/local/app' 
                sh 'java -jar /user/local/app/workout-rest-services-0.0.1-SNAPSHOT.jar' 
            }
        }
    }
}
