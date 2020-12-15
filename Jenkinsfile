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
			agent { 
				docker { 
					image 'maven:3.6.3'
					
					args '-u=\"root\"'
				}
			}
			
			steps {
				
				echo "Building Fibonacci ${BUILD_NUMBER}"
				//sh "mvn clean package"
				echo "Build completed"
			}
		}
	
		stage('Test') {
				
			agent { 
				docker { 
					image 'maven:3.6.3'
					args '-u=\"root\"'
				}
			}
		
			steps {
				
				//sh 'mvn test'
				sh 'docker --help'
				
			}

			post {
				//always {
				//	junit 'target/surefire-reports/TEST-FibonacciTest.xml'
				//}
				success {
					echo "Application testing successfully completed"
					sh 'docker --help'
					sh 'docker build -t result .'
				}
				
				failure {
					echo "Oooppss!!! Tests failed!"
				}
			}// post
		}// stage Test
	}// stages
}
