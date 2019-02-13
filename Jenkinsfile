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
                    args '-p 8081:8080' 
             }
			}			 
            steps {
		sh 'echo workspace_var:'
		sh 'ls $WORKSPACE'
		sh 'echo jonas2jonas2jonas2jonas2jonas'
		    
		sh 'java -jar $WORKSPACE/target/workout-rest-services-0.0.1-SNAPSHOT.jar' 
            }
        }
    }
}
