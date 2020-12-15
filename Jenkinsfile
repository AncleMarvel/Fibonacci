pipeline {
	agent none
	options {timestamps()}
	
	stages {
		stage('Check scm') {
			agent any
			steps {
				checkout scm
			}
		}
		
		stage('Build') {
			steps {
				echo "Building Fibonacci ${BUILD_NUMBER}"
				sh "mvn clean package"
				echo "Build completed"
			}
		}
	
		stage('Test') {
				
			agent { 
				docker { 
					image 'maven'
					args '-u=\"root\"'
				}
			}
		
			steps {
				sh 'mvn test'
				
			}

			post {
				always {
					junit 'target/surefire-reports/TEST-FibonacciTest.xml'
				}
				success {
					echo "Application testing successfully completed"
					sh 'docker build -t target/Fibonacci-1.0.jar .'
					sh 'docker run -d -p 8080:8080 target/Fibonacci-1.0.jar'
				}
				
				failure {
					echo "Oooppss!!! Tests failed!"
				}
			}// post
		}// stage Test
	}// stages
}
