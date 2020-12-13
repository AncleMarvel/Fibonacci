pipeline {
	options {timestamps()}
	
	agent none
	stages {
		stage('Check scm') {
			agent any
			
			steps {
				checkout scm
			}
		}
		
		stage('Build') {
			steps {
				echo "Building ...${BUILD_NUMBER}"
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
				sh 'java -jar Fibonacci.jar'
			}

			post {
				always {
					junit 'target/surefire-reports/TEST-FibonacciTest.xml'
				}
				success {
					echo "Application testing successfully completed"
				}
				failure {
					echo "Oooppss!!! Tests failed!"
				}
			}// post
		}// stage Test
	}// stages
}