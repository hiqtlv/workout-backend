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
                    args '-v /user/local/app:$WORKSPACE/target -p 8081:8080' 
             }
			}			 
            steps {
		sh 'echo jonasjonasjonasjonasjonas'
		sh 'ls $WORKSPACE/target'
		sh 'echo jonas2jonas2jonas2jonas2jonas'
		    
		sh 'java -jar $WORKSPACE/target/workout-rest-services-0.0.1-SNAPSHOT.jar' 
            }
        }
    }
}
