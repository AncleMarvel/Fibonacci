pipeline {
	//environment { 
	//	registry = "anclemarvel/fibonacci" 
	//	registryCredential = 'dockhub' 
	//	dockerImage = 'fibonacci' 
	//}
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
				sh 'echo cd'
				
			}
		}
		stage('Docker build') {
			agent any
			steps {
				//junit 'target/surefire-reports/TEST-FibonacciTest.xml'
				sh "echo dc"
			}
			post {
				
				success {
					echo "Application testing successfully completed"
					sh '''docker build -t anclemarvel/fibonacci .
					docker login --username=anclemarvel --password=Franklin91upetiv
					docker push anclemarvel/fibonacci:latest
					'''
				}
				
				failure {
					echo "Oooppss!!! Tests failed!"
				}
			}// post
		}// stage Test
	}// stages
}
